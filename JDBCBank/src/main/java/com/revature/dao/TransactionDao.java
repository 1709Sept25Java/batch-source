package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Transaction;

public interface TransactionDao {
	public ArrayList<Transaction> viewTransactions();
}