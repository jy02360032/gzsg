package net.webset.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.webset.entity.enums.UserStatus;
import net.webset.util.options.Add;
import net.webset.util.options.Delete;
import net.webset.util.options.Update;
import net.webset.util.validator.EnumInTypes;
import net.webset.util.validator.NoReuseUserName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-14
 */
@TableName(value= "b_user",resultMap="userMap")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
	@NotNull(message = "您没有选择用户", groups= {Update.class,Delete.class})
    @TableId(value = ID,type=IdType.AUTO)
	@Id
    private Integer id;

    /**
     * 用户名
     */
	@NotBlank(message="用户名不能为空",groups= {Add.class})
	@Length(min = 5, max = 20, message = "用户名长度为5-20位。",groups= {Add.class})
	@NoReuseUserName(message="用户名已重复",groups= {Add.class})
    @TableField(USERNAME)
    private String username;

    /**
     * 密码
     */
	@NotBlank(message="用户名不能为空",groups= {Add.class})
	@Length(min=6,max=20,message="密码的长度应该在6和20之间",groups= {Add.class}) 
    @TableField(PASSWORD)
    private String password;

    /**
     * 用户中文名称
     */
    @TableField(NAME)
    private String name;

    /**
     * 联系方式
     */
    @TableField(TEL)
    private String tel;

    /**
     * 是否可用
     */
    @EnumInTypes(groups= {Update.class,Add.class},
    		message = "用户状态只能选择【启用】或【禁用】",target = UserStatus.class)
    @TableField(ENABLE)
    private String enable;

    /**
     * 创建时间
     */
    @TableField(CREATEDATE)
    private Date createdate;

    /**
     * 邮箱
     */
    @Email(message="邮箱格式不正确",groups= {Update.class,Add.class})
    @TableField(MAIL)
    private String mail;

    /**
     * 用户头像
     */
    @TableField(FILE)
    private String file;
    
    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;
    
    /**
     * 用户角色关联信息
     */
    @TableField(exist = false)
    private List<UserRole> userRoles;


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

	public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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

    public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>(); 
		
		for(UserRole rs : userRoles) {
				auths.add(new SimpleGrantedAuthority(rs.getRole().getName()));
		}
		return auths; 
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return UserStatus.启用.name().equals(enable);
	}

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String NAME = "name";

    public static final String TEL = "tel";

    public static final String ENABLE = "enable";

    public static final String CREATEDATE = "createdate";

    public static final String MAIL = "mail";

    public static final String FILE = "file";
    
    public static final String DELETE = "delete";
    
    public static final String LAST_MODIFIED = "last_modified";
    
    public static final String CORE = "user";
    
    public static final String TBNAME = "b_user";
    
    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", tel=" + tel +
        ", enable=" + enable +
        ", createdate=" + createdate +
        ", mail=" + mail +
        ", file=" + file +
        "}";
    }
}
