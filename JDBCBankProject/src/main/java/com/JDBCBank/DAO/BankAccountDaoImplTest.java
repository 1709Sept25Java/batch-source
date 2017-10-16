package com.JDBCBank.DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import com.JDBCBank.exceptions.*;
public class BankAccountDaoImplTest {

	BankAcountDao bd = new BankAccountDaoImpl();
	
	@Test(expected = AccountNotEmptyException.class)
	public final void bankAccountNotEmpty() throws AccountNotEmptyException {
			bd.deleteBankAccount(1003);
		
	}
	
	@Test(expected = OverdraftException.class)
	public final void notEnoughMoney() throws OverdraftException {
		bd.withdrawFromBankAccount(1003, 800);
	}
	
	@Test
	public void withdrawFromAnAccount() throws OverdraftException {
		int i = bd.withdrawFromBankAccount(1009, 200);
		assertEquals(1, i);
	}
	
	@Test
	public void depositToAnAccount(){
		int i = bd.depositToBankAccount(1006, 100);
		assertEquals(1, i);
	}
	
	@Test
	public void createOneNewewAccount() {
		int i = bd.createBankAccount(1010, 800);
		assertEquals(1, i);
	}

		

}
