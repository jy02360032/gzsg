package net.webset.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import net.webset.entity.Menu;
import net.webset.entity.Role;
import net.webset.service.ICacheService;
import net.webset.service.IMenuService;
import net.webset.service.IRbacService;
import net.webset.util.Auth;
import net.webset.util.ReflectionUtil;

@Service("rbacService")
public class RbacServiceImpl implements IRbacService {

	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	@Autowired
	private ICacheService cacheService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IMenuService menuService;
	
	@Override
	public Boolean hasPrimission(HttpServletRequest request,Authentication authentication)  {
		//获取请求类型
		Object principal = authentication.getPrincipal();
		Boolean hasPrimission = false;
		if(principal instanceof UserDetails) {
			String username = ((UserDetails)principal).getUsername();
			//这里需要将用户的信息的所有可访问的URL读取到。
			List<Role> roles = cacheService.findUserRoles(username);
			Set<String> urls = new HashSet<String>();
			if(!roles.isEmpty()) {
				for(Role role : roles) {
					urls.addAll(cacheService.findRolePrimission(role));
				}
			}
			findAuthPromission(username);
			for(String url : urls) {
				if(antPathMatcher.match(url, request.getRequestURI())) {
					hasPrimission = true;
					break;
				}
			}
		}
		return hasPrimission;
	}
	
	/**
	 * 设置权限信息到cookie中。
	 * @param urls
	 */
	public void findAuthPromission(String username) {
//		Auth authPromission = new Auth();
		List<Role> roles = cacheService.findUserRoles(username);
		Set<String> urls = new HashSet<String>();
		if(!roles.isEmpty()) {
			for(Role role : roles) {
				urls.addAll(cacheService.findRolePrimission(role));
			}
		}
		//获取权限实体大集合中所有属性
//		String[] authFilds = ReflectionUtil.getFiledName(authPromission);
		//页面按钮权限authMap
		Map<String,Boolean>  authPromissionMap  = new HashMap<String,Boolean>();
		if(urls.size() > 0) {
			/*modify start*/
			//获取页面中菜单按钮的list
			List<Menu> menuList = menuService.getListByHref();
			for(Menu menu:menuList) {
				String auths = menu.getAuthstr();
				int index1 = auths.lastIndexOf("/");
				int index2 = auths.indexOf("*");
				String authStr = auths.substring(index1+1, index2);
				authPromissionMap.put(authStr, false);
			}
			/*modify end*/
			//初始化所有权限访问表达式
			for(String auth : urls) {
				/*modify start*/
				//页面按钮权限
				for(String key : authPromissionMap.keySet()) {
					if(!key.isEmpty()) {
						if(auth.indexOf(key) != -1) {
							authPromissionMap.put(key, true);
						}
					}
				}
				/*modify end*/
				
				/*for(String authFild : authFilds) {
					if(auth.indexOf(authFild) != -1) {
						ReflectionUtil.setFieldValueByFieldName(authFild, authPromission, true);
					}
				}*/
			}
		}
//		session.setAttribute("authPromission", authPromission);
		session.setAttribute("authPromissionMap", authPromissionMap);
	}
	
	/**
	 * 清除cookie中的权限信息
	 */
	public void delAuthPromission() {
		session.removeAttribute("authPromission");
	}
}
