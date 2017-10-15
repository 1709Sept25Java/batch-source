package bank.dao;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import bank.domain.Transactions;
import bank.util.ConnectionUtil;
import oracle.net.aso.e;

public class TransactionDaoImpl implements TransactionsDao {

	public List<Transactions> getTransactionsByBankAccId(int id) throws ParseException {
		List<Transactions> tl = new ArrayList<Transactions>();
		PreparedStatement pstmt = null;
		Transactions trans = null;
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT TRANSACTION_ID, TRANSACTION_DATE, TRANSACTION_INFO FROM TRANSACTIONS WHERE BANK_ACCOUNT_ID = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int t_id = rs.getInt("TRANSACTION_ID");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					String d = rs.getString("TRANSACTION_DATE");
					Date date = dt.parse(d);
					String info = rs.getString("TRANSACTION_INFO");
					trans = new Transactions(t_id, date, info);
					tl.add(trans);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		return tl;
	}

}
