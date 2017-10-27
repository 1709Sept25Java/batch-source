package dao;

import java.util.List;
import domain.Account;

public interface AccountDao {

	public List <Account> getCustomer();
	public Account getAccountById(int id);
	public Account getAccountType(String type);
	public Account getAccountStatus(String status);
	public Account getAccountAmount(int amount);
	public int createAccount(Account account);
}
