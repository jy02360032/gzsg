package net.webset.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

	/**
	 * 获取实体的类名称-反射
	 * @param o
	 * @return
	 */
	public static String[] getFiledName(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}
	
	/**
	 * 根据属性名设置属性值
	 *
	 * @param fieldName
	 * @param object
	 * @return
	 */
	public static void setFieldValueByFieldName(String fieldName, Object object, Object value) {
		try { // 获取obj类的字节文件对象
			Class<? extends Object> c = object.getClass(); // 获取该类的成员变量
			Field f = c.getDeclaredField(fieldName); // 取消语言访问检查
			f.setAccessible(true); // 给变量赋值
			f.set(object, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
