package net.webset.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@TableName(value = "b_menu",resultMap = "menuMap")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 菜单主键
     */
	@TableId(value = ID,type=IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    @TableField(TEXT)
    private String text;

    /**
     * 连接地址
     */
    @TableField(HREF)
    private String href;

    /**
     * 父节点ID
     */
    @TableField(FATHERID)
    private Integer Fatherid;

    /**
     * 权限匹配字符串
     */
    @TableField(AUTHSTR)
    private String authstr;

    /**
     * 图标
     */
    @TableField(ICON)
    private String icon;

    /**
     * 更新时间
     */
    @TableField(LAST_MODIFIED)
    private Date lastModified;
    
    /**
     * 子节点数量
     */
    @TableField(exist = false)
    private Integer tags;
    
    /**
     * 子菜单列表
     */
    @TableField(exist=false)
    private List<Menu> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    public Integer getFatherid() {
        return Fatherid;
    }

    public void setFatherid(Integer Fatherid) {
        this.Fatherid = Fatherid;
    }
    
    public String getAuthstr() {
        return authstr;
    }

    public void setAuthstr(String authstr) {
        this.authstr = authstr;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    public Integer getTags() {
		return tags;
	}

	public void setTags(Integer tags) {
		this.tags = tags;
	}

	public List<Menu> getNodes() {
		return nodes;
	}

	public void setNodes(List<Menu> nodes) {
		this.nodes = nodes;
	}

	public static final String ID = "id";

    public static final String TEXT = "text";

    public static final String HREF = "href";

    public static final String FATHERID = "Fatherid";

    public static final String AUTHSTR = "authstr";

    public static final String ICON = "icon";

    public static final String LAST_MODIFIED = "last_modified";

    public static final String UID = "uid";

    public static final String CORE = "menu";
    
    public static final String TBNAME = "b_menu";
    
    @Override
    public String toString() {
        return "Menu{" +
        "id=" + id +
        ", text=" + text +
        ", href=" + href +
        ", Fatherid=" + Fatherid +
        ", authstr=" + authstr +
        ", icon=" + icon +
        ", lastModified=" + lastModified +
        "}";
    }
}
