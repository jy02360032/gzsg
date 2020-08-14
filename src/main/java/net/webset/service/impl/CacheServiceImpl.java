package net.webset.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.Role;
import net.webset.entity.RoleMenu;
import net.webset.entity.User;
import net.webset.entity.UserRole;
import net.webset.mapper.RoleMapper;
import net.webset.mapper.UserMapper;
import net.webset.service.ICacheService;

/**
 * 缓存管理器
 * @author 梁雪峰
 *
 */
@Service
public class CacheServiceImpl implements ICacheService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 缓存用户的可访问资源列表集合
	 * @param username 用户名
	 * @return 用户的资源列表
	 */
	@Cacheable(value = "authStr",key="#role.id")
	public Set<String> findRolePrimission(Role role){
		role = roleMapper.selectById(role.getId());
		Set<String> urls = new HashSet<String>();
		for(RoleMenu rm : role.getRoleMenus()) {
			if(StringUtils.isNotBlank(rm.getMenu().getAuthstr())){
				urls.add(rm.getMenu().getAuthstr());
			}
		}
		return urls;
	}
	
	/**
	 * 更新缓存用户的可访问资源列表集合
	 * @param username 用户名
	 * @return 
	 */
	@CachePut(value = "authStr",key="#role.id")
	public Set<String> updateRolePrimission(Role role) {
		role = roleMapper.selectById(role.getId());
		Set<String> urls = new HashSet<String>();
		for(RoleMenu rm : role.getRoleMenus()) {
			if(StringUtils.isNotBlank(rm.getMenu().getAuthstr())){
				urls.add(rm.getMenu().getAuthstr());
			}
		}
		return urls;
	}

	/**
	 * 删除缓存中的URL列表
	 * @param username
	 */
	@CacheEvict(value = "authStr",key="#role.id",beforeInvocation = true)
	public void delRolePrimission(Role role) {
		
	}

	/**
	 * 缓存用户的角色信息
	 */
	@Cacheable(value = "userRole",key="#username")
	public List<Role> findUserRoles(String username) {
		QueryWrapper<User> uw = new QueryWrapper<User>();
		uw.eq(User.USERNAME, username);
		User user = userMapper.selectOne(uw);
		List<UserRole> urs = user.getUserRoles();
		List<Role> roles = new ArrayList<Role>();
		if(!urs.isEmpty()) {
			for(UserRole ur : urs) {
				roles.add(ur.getRole());
			}
		}
		return roles;
	}
	
	/**
	 * 更新缓存中的用户角色关联信息
	 * @param username
	 * @return
	 */
	@CachePut(value = "userRole",key="#username")
	public List<Role> updateUserRoles(String username){
		QueryWrapper<User> uw = new QueryWrapper<User>();
		uw.eq(User.USERNAME, username);
		User user = userMapper.selectOne(uw);
		List<UserRole> urs = user.getUserRoles();
		List<Role> roles = new ArrayList<Role>();
		if(!urs.isEmpty()) {
			for(UserRole ur : urs) {
				roles.add(ur.getRole());
			}
		}
		return roles;
	}
	
	/**
	 * 删除缓存中的用户角色关联信息
	 * @param username
	 * @return
	 */
	@CacheEvict(value = "userRole",key="#username",beforeInvocation = true)
	public void delUserRoles(String username) {
		
	}
	
}
