package com.revature.dao;
import java.util.ArrayList;
import com.revature.dao.*;


public interface BankingServicesDao {
		
	int insertCustomer(CustomersDao customer);

	boolean updateCustomer(CustomersDao customer);

	boolean updateTransaction(int custId, int accNo, TransactionsDao transaction);

	AccountsDao getAccount(int custId, int accNo);

	ArrayList<AccountsDao> getAccountList(int custId);

	CustomersDao getCustomer(int custId);

	ArrayList<TransactionsDao> getTransactions(int custId, int accNo);

	boolean deleteCustomer(int custId);

	boolean deleteAccount(int custId, int accNo);

	int insertAccount(AccountsDao account, int custId);

	boolean updateAccount(int custId, AccountsDao account);

}
