package net.webset.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 工具类
 * @author 梁雪峰
 *
 */
public class Utils {

	/**
	 * 获取错误信息，并且按照一定格式返回给客户端
	 * @param bs
	 * @return
	 */
	public static ResponseEntity<?> getErrors(Set<BindingResult> bs) {
		//初始化错误信息返回类
		Set<String> errors = new HashSet<>();
		if(!bs.isEmpty()) {
			for(BindingResult bind : bs) {
				if(bind.hasErrors()) {
					for(ObjectError oe : bind.getAllErrors()) {
						errors.add(oe.getDefaultMessage());
					}
				}
			}
		}
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}


}
