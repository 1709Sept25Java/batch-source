package bank.dao;

import java.text.ParseException;
import java.util.List;

import bank.domain.Transactions;

public interface TransactionsDao {

	public List<Transactions> getTransactionsByBankAccId(int id) throws ParseException;
	
}
