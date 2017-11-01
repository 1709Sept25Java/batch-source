package com.revature.domain;

import java.util.List;

public class Employee {

	private int employeeId;
	private String employeeUsername;
	private String employeePassword;
	private String employeeFirst;
	private String employeeLast;
	private String employeeEmail;
	private int lineManagerId;
	private int isManager;
	private List<Integer> employees;
	private List<Integer> resolved;
	private List<Integer> pending;

	public Employee() {
		super();
		this.employeeId = 0;
		this.employeeUsername = null;
		this.employeePassword = null;
		this.employeeFirst = null;
		this.employeeLast = null;
		this.employeeEmail = null;
		this.lineManagerId = 0;
		this.isManager = 0;
		this.employees = null;
		this.pending = null;
		this.resolved = null;
	}

	public Employee(int employeeId, String employeeUsername, String employeePassword, String employeeFirst, String employeeLast,
			String employeeEmail, int lineManager, int isManager) {
		this.employeeId = employeeId;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeFirst = employeeFirst;
		this.employeeLast = employeeLast;
		this.employeeEmail = employeeEmail;
		this.lineManagerId = lineManager;
		this.isManager = isManager;
		this.employees = null;
		this.pending = null;
		this.resolved = null;
	}
	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeFirst() {
		return employeeFirst;
	}

	public void setEmployeeFirst(String employeeFirst) {
		this.employeeFirst = employeeFirst;
	}

	public String getEmployeeLast() {
		return employeeLast;
	}

	public void setEmployeeLast(String employeeLast) {
		this.employeeLast = employeeLast;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public int getLineManager() {
		return lineManagerId;
	}

	public void setLineManager(int lineManager) {
		this.lineManagerId = lineManager;
	}

	public int getIsManager() {
		return this.isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	public List<Integer> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Integer> employees) {
		this.employees = employees;
	}

	public List<Integer> getResolved() {
		return resolved;
	}

	public void setResolved(List<Integer> resolved) {
		this.resolved = resolved;
	}

	public List<Integer> getPending() {
		return pending;
	}

	public void setPending(List<Integer> pending) {
		this.pending = pending;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeFirst=" + employeeFirst + ", employeeLast=" + employeeLast
				+ ", employeeEmail=" + employeeEmail + ", lineManagerId=" + lineManagerId + ", isManager=" + isManager
				+ ", employees=" + employees + ", resolved=" + resolved + ", pending=" + pending + "]";
	}
	
	

}
