package bank.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bank.domain.BankAccounts;
import bank.exceptions.AccountNotEmptyException;
import bank.exceptions.OverdraftException;
import bank.util.ConnectionUtil;

public class BankAccountsDaoImpl implements BankAccountsDao{

	public List<BankAccounts> getBankAccounts() {
		
		List<BankAccounts> bl = new ArrayList<BankAccounts>();
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT * FROM BANK_ACCOUNTS";
			Statement stmt = obj.establishedConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int b_id = rs.getInt("BANK_ACCOUNT_ID");
				int u_id = rs.getInt("USER_ID");
				double bal = rs.getDouble("BALANCE");
				BankAccounts newB = new BankAccounts(b_id, u_id, bal);
				bl.add(newB);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return bl;
	}

	public List<BankAccounts> viewAllBankAccounts(int u_id) {
		
		List<BankAccounts> ba = new ArrayList<BankAccounts>();
		PreparedStatement pstmt = null;
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT BANK_ACCOUNT_ID, BALANCE FROM "
					+ "BANK_ACCOUNTS WHERE USER_ID = ?";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, u_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int b_id = rs.getInt("BANK_ACCOUNT_ID");
				int bal = rs.getInt("BALANCE");
				BankAccounts newB = new BankAccounts(b_id, bal);
				ba.add(newB);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			return ba;
	}

	public int deleteBankAccount(int BankAccountId) throws AccountNotEmptyException {

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		int deleted = 0;
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql1 = "SELECT BALANCE FROM BANK_ACCOUNTS WHERE "
					+ "BANK_ACCOUNT_ID = ?";
			pstmt1 = obj.establishedConnection().prepareStatement(sql1);
			pstmt1.setInt(1, BankAccountId);
			ResultSet rs = pstmt1.executeQuery();
			double bal = 0;
			while(rs.next()) {
				bal = rs.getInt("BALANCE");
			}
			if(bal != 0.0) {
				throw new AccountNotEmptyException("CAN NOT DELETE ACCOUNT..."
						+ "ACCOUNT NOT EMPTY");
			}
			String sql = "{CALL DELETE_BANK_ACCOUNT(?)}";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, BankAccountId);
			deleted = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return deleted;

	}

	public int withdrawFromBankAccount(int BankAccountId, int amt) throws OverdraftException {
	
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		int withdrew = 0;
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql1 = "SELECT BALANCE FROM BANK_ACCOUNTS "
					+ "WHERE BANK_ACCOUNT_ID = ?";
			pstmt1 = obj.establishedConnection().prepareStatement(sql1);
			pstmt1.setInt(1, BankAccountId);
			ResultSet rs = pstmt1.executeQuery();
			double bal = 0;
			while(rs.next()) {
				bal = rs.getInt("BALANCE");
			}
			if(bal < amt) {
				throw new OverdraftException("NOT ENOUGH MONEY IN ACCOUNT TO WITHDRAW");
			}
			String sql = "{CALL WITHDRAW_MONEY(?,?)}";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, BankAccountId);
			pstmt.setInt(2, amt);
			withdrew = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return withdrew;
		
	}

	public int depositToBankAccount(int BankAccountId, int amt) {

		PreparedStatement pstmt = null;
		int deposit = 0;
		
		try {
			
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "{CALL DEPOSIT_MONEY(?,?)}";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, BankAccountId);
			pstmt.setInt(2, amt);
			deposit = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return deposit;
	}

	public int createBankAccount(int u_id, int bal) {
		
		PreparedStatement pstmt = null;
		int created = 0;
		
		try {
			
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "{CALL CREATE_BANK_ACC(?,?)}";
			pstmt = obj.establishedConnection().prepareStatement(sql);
			pstmt.setInt(1, u_id);
			pstmt.setInt(2, bal);
			created = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return created;
		
	}

}
