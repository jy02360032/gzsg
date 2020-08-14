package net.webset.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁雪峰
 * @since 2019-04-29
 */
@TableName(value = "b_user_role",resultMap = "userRoleMap")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 用户权限关联表
     */
	@TableId(value = ID,type=IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(USERID)
    private Integer userid;

    /**
     * 权限ID
     */
    @TableField(ROLEID)
    private Integer roleid;

    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;

    /**
     * 角色信息
     */
    @TableField(exist=false)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static final String ID = "id";

    public static final String USERID = "userid";

    public static final String ROLEID = "roleid";

    public static final String LAST_MODIFIED = "last_modified";

    public static final String UID = "uid";

    public static final String CORE = "user_role";
    
    public static final String TBNAME = "b_user_role";
    
    @Override
    public String toString() {
        return "UserRole{" +
        "id=" + id +
        ", userid=" + userid +
        ", roleid=" + roleid +
        ", lastModified=" + lastModified +
        "}";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
    
    
}
