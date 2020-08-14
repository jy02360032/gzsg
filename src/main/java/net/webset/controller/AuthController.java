package net.webset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import net.webset.entity.Role;
import net.webset.service.IRoleService;
import net.webset.util.options.Add;
import net.webset.util.options.Update;
import net.webset.wapper.RoleWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

/**
 * 角色权限管理模块
 * @author 梁雪峰
 *
 */
@RestController
@RequestMapping("/authManager/")
public class AuthController {
	
	@Autowired
	private IRoleService roleService;

	/**
	 * 跳转角色列表页面
	 * @param mav
	 * @return
	 */
	@GetMapping("authList.html")
	public ModelAndView authList(ModelAndView mav) {
		mav.setViewName("roles/rolesList.html");
		return mav;
	}

	@GetMapping("authList.json")
	public ResponseEntity<?> authList(RoleWapper roleWapper,PageUtilWapper pwapper){
		IPage<Role> page = roleService.page(
				new Page<Role>(pwapper.getOffset(), pwapper.getLimit()), roleWapper);
		PageUtilResult<Role> result = new PageUtilResult<>();
		List<Role> roles = page.getRecords();
		Long count = page.getTotal();
		for(int i=0;i<roles.size(); i++) {
			roles.get(i).setRoleMenus(null);
		}
		result.setTotal(count);
		result.setRows(roles);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("authAddPage.html")
	public ModelAndView authAddPage(ModelAndView mav) {
		//初始化权限名称
		Role role = new Role();
		mav.addObject("role", role);
		mav.setViewName("roles/rolesEdit.html");
		return mav;
	}
	
	@GetMapping("authUpdatePage.html")
	public ModelAndView authUpdatePage(ModelAndView mav,Integer id) {
		//初始化权限名称
		Role role = roleService.getById(id);
		mav.addObject("role", role);
		mav.setViewName("roles/rolesEdit.html");
		return mav;
	}

	@PostMapping("authAdd.html")
	public ModelAndView authAdd(@Validated(Add.class) Role role,BindingResult result,
			Integer[] menus,ModelAndView mav) {
		if (result.hasErrors()) { 
			// 现在表示执行的验证出现错误
			mav.setViewName("roles/rolesEdit.html");
			return mav;
		}
		mav.setViewName("roles/rolesList.html");
    	roleService.saveRole(role,menus);
        return mav;
        
	}

	@PostMapping("authUpdate.html")
	public ModelAndView rolesUpdate(@Validated(Update.class) Role role,BindingResult result,
			Integer[] menus,ModelAndView mav) {
		
		if (result.hasErrors()) { // 现在表示执行的验证出现错误
			// 现在表示执行的验证出现错误
			mav.setViewName("roles/rolesEdit.html");
			return mav;
        } 
    	roleService.updateRole(role,menus);
    	mav.setViewName("roles/rolesList.html");
        return mav;
	}
}
