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
import net.webset.entity.User;
import net.webset.entity.UserRole;
import net.webset.service.impl.RoleServiceImpl;
import net.webset.service.impl.UserServiceImpl;
import net.webset.util.options.Add;
import net.webset.util.options.Delete;
import net.webset.util.options.Update;
import net.webset.wapper.RoleWapper;
import net.webset.wapper.UserWapper;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/userManager/")
public class UserManager {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private RoleServiceImpl roleService;

	/**
	 * 用户管理页面跳转
	 * 
	 * @param mav
	 * @return
	 */
	@GetMapping("userList.html")
	public ModelAndView userList(ModelAndView mav) {
		mav.setViewName("user/userList.html");
		return mav;
	}

	/**
	 * 分页获取用户列表
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@GetMapping("userList.json")
	public ResponseEntity<?> userList(UserWapper userWapper,PageUtilWapper pwapper) {
		// 初始化查询条件
		IPage<User> page = userService.page(
				new Page<User>(pwapper.getOffset(), pwapper.getLimit()), userWapper);
		PageUtilResult<User> result = new PageUtilResult<>();
		List<User> users = page.getRecords();
		for(int i=0;i<users.size();i++) {
			users.get(i).setUserRoles(null);
		}
		result.setTotal(page.getTotal());
		result.setRows(page.getRecords());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 跳转添加用户页面
	 * 
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@GetMapping("userAddPage.html")
	public ModelAndView userAddPage(ModelAndView mav) {
		User user = new User();
		mav.addObject("user", user);
		mav.setViewName("user/userEdit.html");
		return mav;
	}

	/**
	 * 初始化角色信息集合
	 * 
	 * @param roleWapper
	 * @return
	 */
	@GetMapping("userAddPageRoles.json")
	public ResponseEntity<?> userAddPageRoles(RoleWapper roleWapper,PageUtilWapper pwapper) {
		IPage<Role> roles = roleService.page(
				new Page<Role>(pwapper.getOffset(), pwapper.getLimit()), roleWapper);
		PageUtilResult<Role> result = new PageUtilResult<Role>();
		result.setRows(roles.getRecords());
		result.setTotal(roles.getTotal());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 保存用户和用户角色关联信息
	 * 
	 * @param user
	 * @param result
	 * @param roles
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@PostMapping("userAdd.html")
	public ModelAndView userAdd(@Validated(Add.class) User user, BindingResult result, 
			String[] roles, ModelAndView mav)  {
		if (result.hasErrors()) { // 现在表示执行的验证出现错误
			List<Role> roleshow = roleService.list();
			mav.addObject("roles", roleshow);
			mav.setViewName("user/userEdit.html");
			return mav;
		}
		userService.saveUserAndRoles(user, roles);
		mav.setViewName("user/userList.html");
		
		return mav;
	}

	/**
	 * 用户修改页面跳转
	 * 
	 * @param mav
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@GetMapping("userUpdatePage.html")
	public ModelAndView userUpdatePage(ModelAndView mav, User condition) {
		List<Role> roles = roleService.list();
		mav.addObject("roles", roles);
		User user = userService.getById(condition.getId());
		mav.addObject("user", user);
		mav.setViewName("user/userEdit.html");
		return mav;
	}

	/**
	 * 用户删除操作。
	 * 
	 * @param user
	 * @param result
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@PostMapping("userDel.html")
	public ModelAndView userDel(@Validated(Delete.class) User user, BindingResult result, 
			ModelAndView mav) {		
		boolean isDel = userService.removeUser(user.getId());
		mav.addObject("info", isDel ? "删除成功" : "删除失败");
		mav.setViewName("user/userList.html");
		return mav;
	}

	/**
	 * 用户更新操作
	 * @param user
	 * @param result
	 * @param roles
	 * @param mav
	 * @return
	 * @throws Exception
	 */
	@PostMapping("userUpdate.html")
	public ModelAndView userUpdate(@Validated(Update.class) User user, BindingResult result, 
			String[] roles, ModelAndView mav)  {
		/*modify start*/
		if (result.hasErrors()) {    // 表示执行的验证出现错误
			List<Role> roleshow = roleService.list();
			User userInfo = userService.getById(user.getId());
			List<UserRole> userRoles = userInfo.getUserRoles(); //获取角色信息
			mav.addObject("user", user);      //更新用户信息
			user.setUserRoles(userRoles);
			mav.addObject("roles", roleshow);
			mav.setViewName("user/userEdit.html");
			return mav;
		}
		/*modify end*/
		boolean isUpdate = userService.updateUserAndRoles(user, roles);
		mav.addObject("info", isUpdate ? "更新成功" : "更新失败");
		mav.setViewName("user/userList.html");
		return mav;
	}
}
