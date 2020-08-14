package net.webset.util;

import java.io.Serializable;

public class Auth implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* ==========用户权限集合=========== */
	private boolean userAdd = false;
	
	private boolean userDel = false;
	
	private boolean userUpdate = false;
	
	private boolean userList = false;
	/* ==========用户权限集合结束========= */
	
	/* ==========角色权限集合=========== */
	private boolean authAdd = false;
	
	private boolean authDel = false;
	
	private boolean authUpdate = false;
	
	private boolean authList = false;
	/* ==========角色权限集合结束========= */

	public boolean isUserAdd() {
		return userAdd;
	}

	public void setUserAdd(boolean userAdd) {
		this.userAdd = userAdd;
	}

	public boolean isUserDel() {
		return userDel;
	}

	public void setUserDel(boolean userDel) {
		this.userDel = userDel;
	}

	public boolean isUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(boolean userUpdate) {
		this.userUpdate = userUpdate;
	}

	public boolean isUserList() {
		return userList;
	}

	public void setUserList(boolean userList) {
		this.userList = userList;
	}

	public boolean isAuthAdd() {
		return authAdd;
	}

	public void setAuthAdd(boolean authAdd) {
		this.authAdd = authAdd;
	}

	public boolean isAuthDel() {
		return authDel;
	}

	public void setAuthDel(boolean authDel) {
		this.authDel = authDel;
	}

	public boolean isAuthUpdate() {
		return authUpdate;
	}

	public void setAuthUpdate(boolean authUpdate) {
		this.authUpdate = authUpdate;
	}

	public boolean isAuthList() {
		return authList;
	}

	public void setAuthList(boolean authList) {
		this.authList = authList;
	}
	
}
