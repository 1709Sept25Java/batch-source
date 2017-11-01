package com.revature.pojo;

public class UserRoles {
	private int roleId;
	private String role;

	public UserRoles() {
		super();

	}

	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", role=" + role + "]";
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRoles(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

}
