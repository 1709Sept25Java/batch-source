package domain;

public class Employee {
	
	private int emp_id;
	private String f_name;
	private String l_name;
	private int d_id;
	private double salary;
	private String email;
	
	public Employee(int emp_id, String f_name, String l_name, int d_id, double salary, String email) {
		super();
		this.emp_id = emp_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.d_id = d_id;
		this.salary = salary;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", f_name=" + f_name + ", l_name=" + l_name + ", d_id=" + d_id
				+ ", salary=" + salary + ", email=" + email + "]";
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
