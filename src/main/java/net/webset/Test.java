package net.webset;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import net.webset.wapper.UserWapper;
import net.webset.wapper.api.conditions.UserApi;

public class Test {

	public static void main(String[] args) {

		UserApi userApi = new UserApi();
		userApi.setEnable("启用");
		userApi.setId(5);
		userApi.setMail("jy02360032@hotmail.com");
		userApi.setStarttime(new Date());
		UserWapper userWapper = new UserWapper();
		
		BeanUtils.copyProperties(userApi, userWapper);
		System.out.println(userWapper.getStarttime());
	}

}
