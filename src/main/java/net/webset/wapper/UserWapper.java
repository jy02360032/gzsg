package net.webset.wapper;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import net.webset.entity.User;

public class UserWapper extends QueryWrapper<User> {

	private static final long serialVersionUID = 1L;

	/**
	 * 公共查询字段ID
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户中文名称
	 */
	private String name;

	/**
	 * 联系方式
	 */
	private String tel;

	/**
	 * 是否可用
	 */
	private String enable;

	/**
	 * 范围时间查询（起始时间）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date starttime;
	
	/**
	 * 范围时间查询（结束时间）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;

	/**
	 * 邮箱
	 */
	private String mail;

	/**
	 * 头像
	 */
	private String file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (this.id != null) {
			this.eq(User.ID, this.id);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		if (StringUtils.isNotBlank(this.username)) {
			this.like(User.USERNAME, this.username);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if (StringUtils.isNotBlank(this.name)) {
			this.like(User.NAME, this.name);
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
		if (StringUtils.isNotBlank(this.tel)) {
			this.like(User.TEL, this.tel);
		}
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
		if (StringUtils.isNotBlank(this.enable)) {
			this.eq(User.ENABLE, this.enable);
		}
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
		if (this.starttime!=null) {
			this.ge(User.CREATEDATE, this.starttime);
		}
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
		if (this.endtime!=null) {
			this.le(User.CREATEDATE, this.endtime);
		}
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
		if (StringUtils.isNotBlank(this.mail)) {
			this.like(User.MAIL, this.mail);
		}
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
