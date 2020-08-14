package net.webset.wapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.UserRole;

public class UserRoleWapper extends QueryWrapper<UserRole> {

	private static final long serialVersionUID = 1L;

	/**
	 * 关联表主键
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userid;

	/**
	 * 角色ID
	 */
	private Integer roleid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if(this.id != null) {
			this.eq(UserRole.ID, this.id);
		}
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
		if(this.userid != null) {
			this.eq(UserRole.USERID, this.userid);
		}
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
		if(this.roleid != null) {
			this.eq(UserRole.ROLEID, this.roleid);
		}
	}
}
