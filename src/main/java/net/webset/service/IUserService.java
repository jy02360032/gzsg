package net.webset.service;

import net.webset.entity.User;

import java.io.IOException;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
public interface IUserService extends IService<User>, UserDetailsService {

	/**
	 * 保存用户和角色信息
	 * 
	 * @param user  用户信息
	 * @param roles 角色ID
	 * @return 是否保存成功
	 * @throws Exception
	 */
	Boolean saveUserAndRoles(User user, String[] roles) throws Exception;

	/**
	 * 更新用户和用户角色关联信息
	 * 
	 * @param user
	 * @param roles
	 * @return
	 * @throws Exception
	 */
	Boolean updateUserAndRoles(User user, String[] roles) throws Exception;

	/**
	 * 删除用户以及用户的相关信息
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 */
	Boolean removeUser(Integer id) throws Exception;

}
