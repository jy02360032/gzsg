package net.webset.util.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.Role;
import net.webset.service.IRoleService;
import net.webset.util.validator.NoReuseRoleName;

public class NoReuseRoleNameValidator implements ConstraintValidator<NoReuseRoleName,String>   {

	@Autowired
	private IRoleService roleService;
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		QueryWrapper<Role> wq = new QueryWrapper<>();
		if(!value.startsWith("ROLE_")) {
			value = "ROLE_" + value;
		}
		wq.eq(Role.NAME, value);
		return roleService.list(wq).isEmpty();
	}
}
