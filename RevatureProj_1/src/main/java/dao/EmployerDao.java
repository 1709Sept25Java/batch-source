package dao;

import java.util.List;

import domain.Customer;
import domain.Employer;

public interface EmployerDao {

	public List <Employer> getCustomer();
	public Employer getEmployerById(int id);
	public int createEmployer(Employer employer);
	public Employer checkapproval(Employer check);
	public String blob(String blob);	
	public int createCustomer(int id);
}
