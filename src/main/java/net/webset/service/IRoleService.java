package net.webset.service;

import net.webset.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
public interface IRoleService extends IService<Role> {

	/**
	 * 保存角色信息
	 * @param role
	 * @param menus
	 * @return
	 */
	Boolean saveRole(Role role, Integer[] menus);

	/**
	 * 保存角色信息
	 * @param role
	 * @param menus
	 * @return
	 */
	Boolean updateRole(Role role, Integer[] menus);

}
