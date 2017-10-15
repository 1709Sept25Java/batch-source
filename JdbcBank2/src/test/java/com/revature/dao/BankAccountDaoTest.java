package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.domain.BankAccount;

public class BankAccountDaoTest {

	//Test the view users function
	@Test
	public final void viewAccountsTest() {
		BankAccountDao baDao = new BankAccountDaoImpl();
		List<BankAccount> ba = baDao.getAccounts(7);
		
		assertNotNull(ba);
		
	}
	
}
