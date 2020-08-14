package net.webset.wapper.page;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页基本信息")
public class PageUtilWapper {

	/**
	 * 当前所在条数
	 */
	@ApiModelProperty(value = "分页当前记录位置,该值必须大于等于0",example = "0")
	@Min(value = 0,message = "当前记录数必须大于等于0")
	@NotNull(message = "所在条数不能为空")
	private Integer offset;
	
	/**
	 * 总显示条数
	 */
	@ApiModelProperty(value = "一共显示多少条记录，该值必须大于0",example = "10")
	@Min(value = 1,message = "显示记录数必须大于0")
	@NotNull(message = "显示条数不能为空")
	private Integer limit;
	
	public Integer getOffset() {
		return offset;
	}
	
	public void setOffset(Integer offset) {
		this.offset = (offset/this.limit)+1;
	}
	
	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
