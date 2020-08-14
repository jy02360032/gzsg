package net.webset.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.webset.entity.Role;
import net.webset.entity.RoleMenu;
import net.webset.mapper.RoleMapper;
import net.webset.mapper.RoleMenuMapper;
import net.webset.service.ICacheService;
import net.webset.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	@Autowired
	private ICacheService cacheService;
	
	@Transactional
	public Boolean saveRole(Role role, Integer[] menus) {
		String name = role.getName();
		if(!name.startsWith("ROLE_")) {
			name = "ROLE_"+name;
			role.setName(name);
		} 
		roleMapper.insert(role);
		if(menus.length > 0) {
			for(Integer menu : menus) {
				RoleMenu rm = new RoleMenu();
				rm.setMenuid(menu);
				rm.setRoleid(role.getId());
				roleMenuMapper.insert(rm);
			}
		}
		cacheService.findRolePrimission(role);
		return true;
	}

	@Transactional
	public Boolean updateRole(Role role, Integer[] menus) {
		roleMapper.updateById(role);
		
		if(menus != null ) {
		role = roleMapper.selectById(role.getId());
		Set<RoleMenu> rms = new HashSet<>(role.getRoleMenus());
		Set<RoleMenu> rmsUpdate = new HashSet<>();
		if(menus.length > 0) {
			for(Integer menu : menus) {
				RoleMenu rm = new RoleMenu();
				rm.setMenuid(menu);
				rm.setRoleid(role.getId());
				rmsUpdate.add(rm);
			}
			
			Iterator<RoleMenu> rmsIT = rms.iterator();
			Iterator<RoleMenu> rmsUpdateIT = rmsUpdate.iterator();
			for(int i=0;i<rms.size();i++) {
				for(int l=0;l<rmsUpdate.size();l++) {
					if(rmsUpdateIT.hasNext() && rmsIT.hasNext()) {
						RoleMenu rm = rmsIT.next();
						RoleMenu rmu = rmsUpdateIT.next();
						if(rm.equals(rmu)) {
							rmsIT.remove();
							rmsUpdateIT.remove();
							i--;
							l--;
							break;
						}
					}else {
						break;
					}
				}
			}
			
			if(!rms.isEmpty()) {
				Set<Integer> ids = new HashSet<Integer>();
				for(RoleMenu menu : rms) {
					ids.add(menu.getId());
				}
				roleMenuMapper.deleteBatchIds(ids);
			}
			
			if(!rmsUpdate.isEmpty()) {
				for(RoleMenu menu : rmsUpdate) {
					roleMenuMapper.insert(menu);
				}
			}
		}
		cacheService.updateRolePrimission(role);
		}
		return true;
	}

}
