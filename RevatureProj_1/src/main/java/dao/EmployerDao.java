package dao;

import java.util.List;

import domain.Employer;

public interface EmployerDao {

	public List <Employer> getCustomer();
	public Employer getEmployerById(int id);
	public int createEmployer(Employer employer);
}
