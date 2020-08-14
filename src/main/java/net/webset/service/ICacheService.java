package net.webset.service;

import java.util.List;
import java.util.Set;

import net.webset.entity.Role;

public interface ICacheService {

	/**
	 * 缓存权限资源列表集合
	 * @param role 权限
	 * @return 用户的资源列表
	 */
	public Set<String> findRolePrimission(Role role);
	
	/**
	 * 删除缓存中的URL列表
	 * @param username 用户名
	 */
	public void delRolePrimission(Role role);
	
	
	/**
	 * 更新缓存用户的可访问资源列表集合
	 * @param username 用户名
	 * @return 
	 */
	public Set<String> updateRolePrimission(Role role);

	/**
	 * 获取缓存中的用户角色关联信息
	 * @param username
	 * @return
	 */
	public List<Role> findUserRoles(String username);
	
	/**
	 * 更新缓存中的用户角色关联信息
	 * @param username
	 * @return
	 */
	public List<Role> updateUserRoles(String username);
	
	/**
	 * 删除缓存中的用户角色关联信息
	 * @param username
	 * @return
	 */
	public void delUserRoles(String username);


}
