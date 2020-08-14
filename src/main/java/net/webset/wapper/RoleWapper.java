package net.webset.wapper;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.Role;

public class RoleWapper extends QueryWrapper<Role> {

	private static final long serialVersionUID = 1L;

	/**
	 * 权限ID
	 */
	private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限说明
     */
    private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if(this.id != null) {
			this.eq(Role.ID, this.id);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if(StringUtils.isNotBlank(this.name)) {
			this.like(Role.NAME, this.name);
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		if(StringUtils.isNotBlank(this.text)) {
			this.like(Role.TEXT, this.text);
		}
	}
}
