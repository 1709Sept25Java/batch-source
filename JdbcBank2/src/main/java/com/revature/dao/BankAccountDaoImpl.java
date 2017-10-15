package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.revature.domain.BankAccount;
import com.revature.exception.OverdraftException;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class BankAccountDaoImpl implements BankAccountDao{

	public BankAccountDaoImpl() {
		super();
	}

	/*
	 * Function to retrieve all the accounts for the user with the given id
	 * */
	@Override
	public List<BankAccount> getAccounts(int uId) {
		
		List<BankAccount> ba = new ArrayList<>();
		CallableStatement cs = null;
		
		//Try to establish database connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql ="{call GET_ACCOUNTS(?,?)}";
			cs = conn.prepareCall(sql);	//Prepare the call to the Database function GET_ACCOUNTS()
			cs.setInt(1, uId);	//Set the in parameter for the function
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet)cs.getObject(2);	//Store the returned accounts in a result set
			
			if(rs == null) {
				return ba;
			}
			
			//Loop to retrieve the data returned in the ResultSet
			while(rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				int bal = rs.getInt("BALANCE");
				BankAccount b = new BankAccount(id,uId,bal);
				ba.add(b); //Store the retrieved accounts in a list
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//return the accounts
		return ba;
	}

	/*
	 * Function that deletes and account with the matching id and userid
	 * Returns true if the delete was successful
	 * */
	@Override
	public boolean deleteAccount(int uId,int id) {
		
		CallableStatement cs = null;
		//Try to establish the database connection
		 try(Connection conn = ConnectionUtil.getConnection()){
			 
			 String sql = "{call DELETE_ACCOUNT(?,?)}";
			 cs = conn.prepareCall(sql);	//Prepares the call to the database procedure DELETE_ACCOUNT
			 cs.setInt(1, uId);		//Set the in parameters for the procedure
			 cs.setInt(2, id);
			 cs.registerOutParameter(3, java.sql.Types.INTEGER);	//Register the out parameter to be returned
			 
			 cs.executeUpdate();
			 
			 int result = cs.getInt(3);	//Store the returned value
			 if(result == -1) {	//Return false if the delete did not execute properly
				 return false;
			 }
			 
		 } catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 //Return true if the delete executed successfully
		return true;
	}

	@Override
	public boolean createAccount(int uId) {
		
		CallableStatement cs = null;
		
		//Establish the database connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call INSERT_ACCOUNT(?,?)}";
			cs = conn.prepareCall(sql);	//Prepare the call to the stored procedure INSERT_ACCOUNT()
			cs.setInt(1, uId);	//Set the in parameters for the procedure
			cs.registerOutParameter(2, java.sql.Types.INTEGER);	//Register the out parameters
			
			cs.executeUpdate();
			
			int result = cs.getInt(2);	//Store the returned result
			if(result == -1) {
				return false;	//Return false if the account was not successfully added to the database
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Return true if the account was successful inserted
		return true;
	}

	/*
	 * Function to withdraw from an account
	 * It takes in the account id of the account to withdraw from and the amount of money to withdraw
	 * 
	 * */
	@Override
	public int withdraw(BankAccount b, int amt) throws OverdraftException{
		
		CallableStatement cs = null;
		int newBal = 0;
		
		//Throw an exception if the amount entered is greater than the account balance
		if(b.getBalance()<amt) {
			throw new OverdraftException();
		}
		
		//Try to establish database connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call ACCOUNT_WITHDRAW(?,?,?)}";
			cs = conn.prepareCall(sql);	//Prepare call to database procedure ACCOUNT_WITHDRAW()
			cs.setInt(1, b.getId());	//Set the in parameter values for the procedure call
			cs.setDouble(2, amt);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);	//Register the out parameters to retrieve
			
			cs.executeUpdate();
			
			newBal = cs.getInt(3);	//Store the returned result
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Return the new account balance
		return newBal;
	}

	@Override
	public int deposit(int id, int amt) {
		CallableStatement cs = null;
		int newBal = 0;
		
		//Try to establish the database connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call ACCOUNT_DEPOSIT(?,?,?)}";
			cs = conn.prepareCall(sql);	//Prepare call to database procedure ACCOUNT_DEPOSIT()
			//Set the in parameters of the procedure
			cs.setInt(1, id);	
			cs.setInt(2, amt);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);	//Register the out parameter to retrieve
			
			cs.executeQuery();	//Execute the call to the procedure
			
			newBal = cs.getInt(3);	//Store the value returned from the database
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//return the new account balance
		return newBal;
	}

}
