package challengeweek2;

import java.sql.Date;
import java.util.List;


public class Employees {
	public Employees(String firstname, String lastname, Departments departments, int salary, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.departments = departments;
		this.salary = salary;
		this.email = email;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int id, String firstname, String lastname, Departments departments, int salary, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.departments = departments;
		this.salary = salary;
		this.email = email;
	}
	private int id;
	private String firstname;
	private String lastname;
	private Departments departments;
	private int salary;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", departments="
				+ departments + ", salary=" + salary + ", email=" + email + "]";
	}
	
}
