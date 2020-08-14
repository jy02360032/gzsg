package net.webset.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.webset.entity.Role;
import net.webset.entity.RoleMenu;
import net.webset.entity.User;
import net.webset.entity.UserRole;
import net.webset.mapper.UserMapper;
import net.webset.mapper.UserRoleMapper;
import net.webset.service.ICacheService;
import net.webset.service.IRbacService;
import net.webset.service.IUserService;
import net.webset.wapper.UserRoleWapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private ICacheService cacheService;
	
	@Autowired
	private IRbacService rbacService;

	public UserDetails loadUserByUsername(String username) {
		if ("".equals(username.trim())) {
			throw new UsernameNotFoundException("用户名不能为空");
		}
		QueryWrapper<User> uw = new QueryWrapper<User>();
		uw.eq(User.USERNAME, username);
		User user = userMapper.selectOne(uw);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		for (UserRole uerRole : user.getUserRoles()) {
			Role r = uerRole.getRole();
			for (RoleMenu rm : r.getRoleMenus()) {
				rm.getMenu();
			}
		}
		rbacService.findAuthPromission(user.getUsername());
		// 当用户信息有效时放入 Session 中
		session.setAttribute("user", user);
		return user;
	}

	/**
	 * 保存新用户的信息和角色信息
	 * 
	 * @param user  用户信息
	 * @param roles 角色ID集合
	 */
	@Transactional
	public Boolean saveUserAndRoles(User user, String[] roles) {
		BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		// 对注册用户的密码进行加密，这里使用BCryptPassword加密方式
		String pass = bcp.encode(user.getPassword());
		user.setPassword(pass);
		user.setCreatedate(new Date());
		userMapper.insert(user);
		// 开始保存用户关联的角色信息
		for (String r : roles) {
			UserRole ur = new UserRole();
			ur.setRoleid(Integer.parseInt(r));
			ur.setUserid(user.getId());
			userRoleMapper.insert(ur);
		}
		cacheService.findUserRoles(user.getUsername());
		
		return true;
	}

	/**
	 * 删除用户以及用户的相关信息
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	@Transactional
	public Boolean removeUser(Integer id) {

		User user = userMapper.selectById(id);
		if (user != null) {
			UserRoleWapper urWapper = new UserRoleWapper();
			urWapper.setUserid(user.getId());
			List<UserRole> urs = userRoleMapper.selectList(urWapper);
			if (urs.size() > 0) {
				Set<Integer> ids = new HashSet<Integer>();
				for (int i = 0; i < urs.size(); i++) {
					ids.add(urs.get(i).getId());
				}
				userRoleMapper.deleteBatchIds(ids);
			}
			
			userMapper.deleteById(user.getId());
			cacheService.delUserRoles(user.getUsername());
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 更新用户和用户角色关联信息
	 * 
	 * @param user
	 * @param roles
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Boolean updateUserAndRoles(User user, String[] roles) {
		BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		// 对注册用户的密码进行加密，这里使用BCryptPassword加密方式
		if (StringUtils.isNotBlank(user.getPassword())) {
			String pass = bcp.encode(user.getPassword());
			user.setPassword(pass);
		}else {
			user.setPassword(null);
		}
		// 更新用户信息
		userMapper.updateById(user);
		// 获取数据库中用户信息
		user = userMapper.selectById(user.getId());
		// 初始化当前角色信息
		List<UserRole> userRoles = user.getUserRoles();
		if (userRoles.size() > 0 && roles.length > 0) {
			for (UserRole ur : userRoles) {
				userRoleMapper.deleteById(ur.getId());
			}
			for (int i = 0; i < roles.length; i++) {
				UserRole temp = new UserRole();
				temp.setUserid(user.getId());
				temp.setRoleid(Integer.parseInt(roles[i]));
				userRoleMapper.insert(temp);
			}
		} else if (userRoles.size() > 0 && roles.length == 0) {
			for (UserRole ur : userRoles) {
				userRoleMapper.deleteById(ur.getId());
			}
		} else if (userRoles.size() == 0 && roles.length > 0) {
			for (int i = 0; i < roles.length; i++) {
				UserRole temp = new UserRole();
				temp.setUserid(user.getId());
				temp.setRoleid(Integer.parseInt(roles[i]));
				userRoleMapper.insert(temp);
			}
		}
		cacheService.updateUserRoles(user.getUsername());
		return true;
	}
}
