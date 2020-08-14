package net.webset.util.validator.impl;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import net.webset.entity.User;
import net.webset.mapper.UserMapper;
import net.webset.util.validator.NoReuseUserName;
import net.webset.wapper.UserWapper;

public class NoReuseUserNameValidator implements ConstraintValidator<NoReuseUserName,String>  {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		UserWapper userWapper = new UserWapper();
		userWapper.setUsername(value);
		
		try {
			List<User> isExit = userMapper.selectList(userWapper);
			if(!isExit.isEmpty()){
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

}
