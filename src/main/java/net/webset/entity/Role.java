package net.webset.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import net.webset.util.options.Add;
import net.webset.util.options.Update;
import net.webset.util.validator.NoReuseRoleName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-29
 */
@TableName(value = "b_role",resultMap = "roleMap")
public class Role implements Serializable {    

	private static final long serialVersionUID = 1L;

	/**
     * 权限主键
     */
	@TableId(value = ID,type=IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
	@NotBlank(message = "权限名称不能为空",groups = {Add.class,Update.class})
	@NoReuseRoleName(message = "权限名称重复",groups = {Add.class})
    @TableField(NAME)
    private String name;

    /**
     * 权限说明
     */
	@NotBlank(message = "权限名称不能为空",groups = {Add.class,Update.class})
    @TableField(TEXT)
    private String text;
	
	/**
	 * 说明
	 */
	@TableField(REMARK)
	private String remark;

    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;
    
    /**
     * 菜单权限关系
     */
    @TableField(exist=false)
    private List<RoleMenu> roleMenus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public List<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TEXT = "text";

    public static final String REMARK = "remark";
    
    public static final String LAST_MODIFIED = "last_modified";

    public static final String UID = "uid";

    public static final String CORE = "role";
    
    public static final String TBNAME = "b_role";

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", name=" + name +
        ", text=" + text +
        ", lastModified=" + lastModified +
        "}";
    }
}
