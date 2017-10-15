package com.revature.main;

import com.revature.bank.Bank;

public class Driver {
	public static void main(String[] args) {
		//Call the Bank Class and start a bank session
		Bank bank = new Bank();
		bank.bankSession();
	}	
}