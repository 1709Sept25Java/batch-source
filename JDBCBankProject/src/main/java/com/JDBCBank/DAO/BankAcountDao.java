package com.JDBCBank.DAO;


import java.util.List;

import com.JDBCBank.domain.BankAccount;
import com.JDBCBank.exceptions.AccountNotEmptyException;
import com.JDBCBank.exceptions.OverdraftException;

public interface BankAcountDao {
	public List<BankAccount> getBankAccounts();
	
	public List<BankAccount> viewAllBankAccounts(int u_id);
	
	public int deleteBankAccount(int BankAccountId) throws AccountNotEmptyException;
	
	public int withdrawFromBankAccount(int BankAccountId, int amt) throws OverdraftException;
	
	public int depositToBankAccount(int BankAccountId, int amt);
	
	public int createBankAccount(int bank_acc_id, int bal);

	

}
