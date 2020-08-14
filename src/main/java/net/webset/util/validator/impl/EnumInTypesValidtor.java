package net.webset.util.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.webset.util.validator.EnumInTypes;

public class EnumInTypesValidtor implements ConstraintValidator<EnumInTypes, Object> {
	Class<?>[] cls; // 枚举类

	@Override
	public void initialize(EnumInTypes constraintAnnotation) {
		cls = constraintAnnotation.target();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value!=null) {
			if (cls.length > 0) {
				for (Class<?> cl : cls) {
					try {
						if (cl.isEnum()) {
							// 枚举类验证
							Object[] objs = cl.getEnumConstants();
							for (Object obj : objs) {
								if (value.equals(obj.toString())) {
									return true;
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				return true;
			}
		}else {
			return true;
		}
		return false;
	}

}
