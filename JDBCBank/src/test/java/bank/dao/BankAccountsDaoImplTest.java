package bank.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.exceptions.*;

public class BankAccountsDaoImplTest {

	BankAccountsDao bd = new BankAccountsDaoImpl();
	
	@Test(expected = AccountNotEmptyException.class)
	public final void bankAccountNotEmpty() throws AccountNotEmptyException {
			bd.deleteBankAccount(472);
		
	}
	
	@Test(expected = OverdraftException.class)
	public final void notEnoughMoney() throws OverdraftException {
		bd.withdrawFromBankAccount(472, 5000);
	}
	
	@Test
	public void withdrawFromOneAccount() throws OverdraftException {
		int i = bd.withdrawFromBankAccount(472, 1);
		assertEquals(1, i);
	}
	
	@Test
	public void depositToOneAccount(){
		int i = bd.depositToBankAccount(106, 100);
		assertEquals(1, i);
	}
	
	@Test
	public void createOneAccount() {
		int i = bd.createBankAccount(124, 800);
		assertEquals(1, i);
	}
}
