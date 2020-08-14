package net.webset.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IRbacService {
	
	/**
	 * 动态判断权限信息
	 * @param request
	 * @param auth
	 * @return
	 */
	public Boolean hasPrimission(HttpServletRequest request,Authentication auth);
	
	/**
	 * 设置权限信息到cookie中。
	 * @param urls
	 */
	public void findAuthPromission(String username);
	
	/**
	 * 清除cookie中的权限信息
	 */
	public void delAuthPromission();
	
}
