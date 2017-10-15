package bank.dao;

import java.util.List;

import bank.domain.BankAccounts;
import bank.exceptions.AccountNotEmptyException;
import bank.exceptions.OverdraftException;

public interface BankAccountsDao {

		public List<BankAccounts> getBankAccounts();
		
		public List<BankAccounts> viewAllBankAccounts(int u_id);
		
		public int deleteBankAccount(int BankAccountId) throws AccountNotEmptyException;
		
		public int withdrawFromBankAccount(int BankAccountId, int amt) throws OverdraftException;
		
		public int depositToBankAccount(int BankAccountId, int amt);
		
		public int createBankAccount(int bank_acc_id, int bal);
}
