package net.webset.mapper;

/**
 * 函数调用接口
 * @author 梁雪峰
 *
 */
public interface FunctionMapper {
	
	/**
	 * 获取表序列的下一个值
	 * @param tbname 表名称
	 * @return ID
	 */
	public Integer nextVal(String tbname);

}
