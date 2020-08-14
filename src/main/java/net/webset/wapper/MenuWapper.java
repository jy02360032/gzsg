package net.webset.wapper;


import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.Menu;


/**
 * 	菜单查询Wapper类
 * @author administrator1
 * 2019-12-04
 *
 */
public class MenuWapper extends QueryWrapper<Menu> {

	private static final long serialVersionUID = 1L;

	/**
     * 菜单主键
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String text;

    /**
     * 连接地址
     */
    private String href;

    /**
     * 父节点ID
     */
//    private Integer Fatherid;

    /**
     * 权限匹配字符串
     */
//    private String authstr;

    /**
     * 图标
     */
//    private String icon;

    /**
     * 更新时间
     */
//    private Date lastModified;
    
    /**
     * 子节点数量
     */
//    private Integer tags;
    
    /**
     * 子菜单列表
     */
//    private List<Menu> nodes;
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (this.id != null) {
			this.eq(Menu.ID, this.id);
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		if (StringUtils.isNotBlank(this.text)) {
			this.like(Menu.TEXT, this.text);
		}
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
		if (StringUtils.isNotBlank(this.href)) {
			this.like(Menu.HREF, this.href);
		}
	}
}
