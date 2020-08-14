package net.webset.wapper.api.vos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.webset.entity.enums.UserStatus;
import net.webset.util.options.Add;
import net.webset.util.options.Delete;
import net.webset.util.options.Update;
import net.webset.util.validator.EnumInTypes;
import net.webset.util.validator.NoReuseUserName;

@ApiModel("用户实体信息")
public class UserVO {

	/**
     * 用户主键
     */
	@ApiModelProperty(value = "用户主键",example = "1")
	@NotNull(message = "您没有选择用户", groups= {Update.class,Delete.class})
	@Min(value = 1,message = "主键值必须大于等于1",groups= {Update.class,Delete.class})
    private Integer id;

    /**
     * 用户名
     */
	@ApiModelProperty(value = "用户名称，这是系统的登录名",example = "xiaoming")
	@NotBlank(message="用户名不能为空",groups= {Add.class})
	@Length(min = 5, max = 20, message = "用户名长度为5-20位。",groups= {Add.class})
	@NoReuseUserName(message="用户名已重复",groups= {Add.class})
    private String username;

    /**
     * 密码
     */
	@ApiModelProperty(value = "用户密码",example = "123456")
	@NotBlank(message="用户名不能为空",groups= {Add.class})
	@Length(min=6,max=20,message="密码的长度应该在6和20之间",groups= {Add.class}) 
    private String password;

    /**
     * 用户中文名称
     */
	@ApiModelProperty(value = "用户昵称",example = "小明")
    private String name;

    /**
     * 联系方式
     */
	@ApiModelProperty(value = "用户联系方式",example = "0431-89812673")
    private String tel;

    /**
     * 是否可用
     */
	@ApiModelProperty(value = "用户状态只能选择【启用】或【禁用】",example = "启用")
    @EnumInTypes(groups= {Update.class,Add.class},
    		message = "用户状态只能选择【启用】或【禁用】",target = UserStatus.class)
    private String enable;
	
    /**
     * 邮箱
     */
	@ApiModelProperty(value = "用户邮箱",example = "jy02360032@hotmail.com")
    @Email(message="邮箱格式不正确",groups= {Update.class,Add.class})
    private String mail;

    /**
     * 用户头像
     */
    private String file;


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
    
}
