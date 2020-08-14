package net.webset.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.ApiOperation;
import net.webset.entity.Role;
import net.webset.service.IRoleService;
import net.webset.wapper.RoleWapper;
import net.webset.wapper.api.conditions.RoleApi;
import net.webset.wapper.page.PageUtilResult;
import net.webset.wapper.page.PageUtilWapper;

@RestController
@RequestMapping("/authManager/")
public class RoleSwagger {
	
	@Autowired
	private IRoleService roleService;
	
	@ApiOperation(value = "权限集合",notes = "这是一个分页方法，可以获取权限集合的分页信息")
	@GetMapping("roleList.json")
	public ResponseEntity<?> authList(RoleApi roleApi,PageUtilWapper pwapper){
		
		RoleWapper roleWapper = new RoleWapper();
		BeanUtils.copyProperties(roleApi, roleWapper);
		
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
}
