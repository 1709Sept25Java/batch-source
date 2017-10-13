package com.revature.dao;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao{

	@Override
	public List<BankAccount> getAccounts(int uId,ConnectionUtil cu) {
		
		List<BankAccount> ba = null;
		CallableStatement cs = null;
		
		try(Connection conn = cu.getConnected()){
			
			String sql ="{call GET_ACCOUNTS(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, uId);
			
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				int bal = rs.getInt("BALANCE");
				BankAccount b = new BankAccount(id,null,bal);
				ba.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ba;
	}

	@Override
	public boolean deleteAccount(int uId,int id,ConnectionUtil cu) {
		
		CallableStatement cs = null;
		 try(Connection conn = cu.getConnected()){
			 
			 String sql = "{call DELETE_ACCOUNT(?,?)}";
			 cs = conn.prepareCall(sql);
			 cs.setInt(1, uId);
			 cs.setInt(2, id);
			 cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			 
			 cs.executeUpdate();
			 
			 int result = cs.getInt(3);
			 if(result == -1) {
				 return false;
			 }
			 
		 } catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean createAccount(int uId,ConnectionUtil cu) {
		
		CallableStatement cs = null;
		
		try(Connection conn = cu.getConnected()){
			
			String sql = "{call INSER_ACCOUNT(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, uId);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cs.executeUpdate();
			
			int result = cs.getInt(2);
			if(result == -1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public int withdraw(int id, double amt,ConnectionUtil cu) {
		
		
		
		return 0;
	}

	@Override
	public int deposit(int id, double amt,ConnectionUtil cu) {
		return 0;
	}

}
