package net.webset.wapper.api.conditions;

import java.util.Date;

import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.webset.entity.enums.UserStatus;
import net.webset.util.validator.EnumInTypes;

@ApiModel("用户基本信息")
public class UserApi {
	/**
	 * 公共查询字段ID
	 */
	@ApiModelProperty(value = "用户主键",example = "1")
	@Min(message="主键需为正整数，且大于等于1",value=1)
	private Integer id;
	
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名称,这里是模糊匹配",example = "admin")
	private String username;

	/**
	 * 用户中文名称
	 */
	@ApiModelProperty(value = "用户昵称名称,这里是模糊匹配",example = "梁")
	private String name;

	/**
	 * 联系方式
	 */
	@ApiModelProperty(value = "用户联系方式,这里是模糊匹配",example = "186")
	private String tel;

	/**
	 * 是否可用
	 */
	@ApiModelProperty(value = "用户状态，只可以传【启用】或【禁用】",example = "启用")
	@EnumInTypes(message = "用户状态，只可以传【启用】或【禁用】",target = UserStatus.class)
	private String enable;

	/**
	 * 范围时间查询（起始时间）
	 */
	@ApiModelProperty(value = "时间范围查询开始时间，这里指查询用户的创建时间",example = "2010-10-11")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date starttime;
	
	/**
	 * 范围时间查询（结束时间）
	 */
	@ApiModelProperty(value = "时间范围查询结束时间，这里指查询用户的创建时间",example = "2019-10-11")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "用户邮箱,这里是模糊匹配",example = "jy02360032")
	private String mail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
