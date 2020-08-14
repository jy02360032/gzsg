package net.webset.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.webset.entity.User;
import net.webset.service.impl.UserServiceImpl;
import net.webset.util.Utils;
import net.webset.util.options.Add;
import net.webset.util.options.Delete;
import net.webset.util.options.Update;
import net.webset.wapper.UserWapper;
import net.webset.wapper.api.conditions.UserApi;
import net.webset.wapper.api.vos.UserVO;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/userManager/")
@ApiResponses({
    @ApiResponse(code = 200, message = "成功返回用户信息"),
    @ApiResponse(code = 401, message = "未授权的访问，请重新授权访问用户信息"),
    @ApiResponse(code = 403, message = "没有权限访问用户资源"),
    @ApiResponse(code = 404, message = "未找到用户信息"),
    @ApiResponse(code = 400, message = "验证失败"),
    @ApiResponse(code = 500, message = "服务错误，修复中......")
})
public class UserSwagger {
	
	@Autowired
	private UserServiceImpl userService;
	
	@ApiOperation(value = "用户列表方法",notes = "这是一个分页方法，可以获取用户集合的分页信息")
	@GetMapping("userListAPI.json")
	public ResponseEntity<?> userListAPI(@Validated PageUtilWapper pageWapper,BindingResult pr, 
			@Validated UserApi userApi,BindingResult ur){
		if(pr.hasErrors() || ur.hasErrors()) {
			Set<BindingResult> ss = new HashSet<>();
			ss.add(pr);
			ss.add(ur);
			return Utils.getErrors(ss);
		}
		UserWapper userWapper = new UserWapper();
		BeanUtils.copyProperties(userApi, userWapper);
		// 初始化查询条件
		IPage<User> page = userService.page(
				new Page<User>(pageWapper.getOffset(), pageWapper.getLimit()), userWapper);
		PageUtilResult<User> result = new PageUtilResult<>();
		List<User> users = page.getRecords();
		for(int i=0;i<users.size();i++) {
			users.get(i).setUserRoles(null);
			users.get(i).setPassword(null);
		}
		result.setTotal(page.getTotal());
		result.setRows(users);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取用户信息",notes = "以ID为条件获取用户的详细信息")
	@GetMapping("userListInfoAPI")
	public ResponseEntity<?> userListInfoAPI(@Validated(Update.class) UserVO userVO,BindingResult ur){
		if(ur.hasErrors()) {
			Set<BindingResult> ss = new HashSet<>();
			ss.add(ur);
			return Utils.getErrors(ss);
		}
		User user = userService.getById(userVO.getId());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "创建用户接口",notes = "新建用户信息")
	@PostMapping("userAddAPI")
	public ResponseEntity<?> userAddAPI(@Validated(Add.class) UserVO userVO,BindingResult ur,String[] roles){
		if(ur.hasErrors()) {
			Set<BindingResult> ss = new HashSet<>();
			ss.add(ur);
			return Utils.getErrors(ss);
		}
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		boolean success = userService.saveUserAndRoles(user,roles);
		return new ResponseEntity<>(success, success ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "修改用户接口",notes = "对用户的接口进行修改，ID必须不能为空")
	@PutMapping("userUpdateAPI")
	public ResponseEntity<?> userUpdateAPI(@Validated(Update.class) UserVO userVO,BindingResult ur,String[] roles){
		if(ur.hasErrors()) {
			Set<BindingResult> ss = new HashSet<>();
			ss.add(ur);
			return Utils.getErrors(ss);
		}
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		boolean success = userService.updateUserAndRoles(user,roles);
		return new ResponseEntity<>(success, success ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "创建用户接口",notes = "新建用户信息")
	@DeleteMapping("userDeleteAPI")
	public ResponseEntity<?> userDeleteAPI(@Validated(Delete.class) UserVO userVO,BindingResult ur) {
		if(ur.hasErrors()) {
			Set<BindingResult> ss = new HashSet<>();
			ss.add(ur);
			return Utils.getErrors(ss);
		}
		boolean success = userService.removeUser(userVO.getId());
		return new ResponseEntity<>(success, success ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
