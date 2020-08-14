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
@TableName(value = "b_role_menu",resultMap = "roleMenuMap")
public class RoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	@TableId(value = ID,type=IdType.AUTO)
    private Integer id;

    /**
     * 权限ID
     */
    @TableField(ROLEID)
    private Integer roleid;

    /**
     * 菜单ID
     */
    @TableField(MENUID)
    private Integer menuid;

    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;
    
    /**
     * 权限菜单信息
     */
    @TableField(exist=false)
    private Menu menu;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    
    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
    
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

    public static final String ID = "id";

    public static final String ROLEID = "roleid";

    public static final String MENUID = "menuid";

    public static final String LAST_MODIFIED = "last_modified";

    public static final String UID = "uid";

    public static final String CORE = "role_menu";
    
    public static final String TBNAME = "b_role_menu";

    @Override
    public String toString() {
        return "RoleMenu{" +
        "id=" + id +
        ", roleid=" + roleid +
        ", menuid=" + menuid +
        ", lastModified=" + lastModified +
        "}";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuid == null) ? 0 : menuid.hashCode());
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
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
		RoleMenu other = (RoleMenu) obj;
		if (menuid == null) {
			if (other.menuid != null)
				return false;
		} else if (!menuid.equals(other.menuid))
			return false;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		return true;
	}
}
