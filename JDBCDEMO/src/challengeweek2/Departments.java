package challengeweek2;

import java.sql.Date;
public class Departments {
	public Departments(String dept_name) {
		super();
		this.dept_name = dept_name;
	}
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departments(String id, String dept_name) {
		super();
		this.id = id;
		this.dept_name = dept_name;
	}
	private String id;
	private String dept_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	@Override
	public String toString() {
		return "Departments [id=" + id + ", dept_name=" + dept_name + "]";
	}
}
