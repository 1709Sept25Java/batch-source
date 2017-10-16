package com.revature.dao;
import java.util.ArrayList;

import com.revature.dao.AddressDao.Address;
public class CustomersDao {
	private int customerId;
	private String customerName;
	private Address laddress;
	private Address haddress;
	private ArrayList<AccountsDao> account = new ArrayList<AccountsDao>(3);

	public CustomersDao() {
		super();
	}

	public CustomersDao(int customerId, String customerName, Address laddress,
			Address haddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.laddress = laddress;
		this.haddress = haddress;
	}

	public CustomersDao(String customerName, Address laddress, Address haddress) {
		super();
		this.customerName = customerName;
		this.laddress = laddress;
		this.haddress = haddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getLaddress() {
		return laddress;
	}

	public void setLaddress(Address laddress) {
		this.laddress = laddress;
	}

	public Address getHaddress() {
		return haddress;
	}

	public void setHaddress(Address haddress) {
		this.haddress = haddress;
	}

	public ArrayList<AccountsDao> getAccount() {
		return account;
	}

	public void setAccount(ArrayList<AccountsDao> account) {
		this.account = account;
	}
	

}
