package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao{

	public UsersDaoImpl() {
		super();
	}

	/*
	 * login() function:
	 * Takes in 2 strings for the username and password entered and returns a
	 * Users object of the user retrieved from the database or null if none is
	 * found with matching credentials
	 * */
	@Override
	public Users login(String username, String password) throws InvalidUserException{
		CallableStatement cs = null;
		Users u = null;
		
		//Try to establish the connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call LOGIN(?,?)}";
			cs = conn.prepareCall(sql);	//prepare the function call in the database
			cs.setString(1, username);	//set the username and password to send in
			cs.setString(2, password);
			
			ResultSet rs = cs.executeQuery();	//Execute the call and store in a ResultSet
			
			//Retrieve the User data from the result set
			while(rs.next()) {
				int uId = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				String admin = rs.getString("IS_ADMIN");
				boolean isAdmin = false;
				if(admin.equals("T")) {
					isAdmin = true;
				}
				//Save the user data locally
				u = new Users(uId,uName,password,fname,lname,isAdmin);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Throw an exception if no user matching the credentials entered is found
		if(u == null) {
			throw new InvalidUserException();
		}
		
		//return the user
		return u;
	}

	@Override
	public List<Users> getUsers(int id) {
		List<Users> u = null;
		CallableStatement cs = null;
		
		//Try to establish the database connection
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call VIEW_USERS(?)}";
			cs = conn.prepareCall(sql);	//prepare the call to the database function
			cs.setInt(1, id);	//set the id of the admin looking to view the users (their own user info
			ResultSet rs = cs.executeQuery();										//won't be displayed)
			
			//Retrieve the User data from the ResultSet and store it in a List of Users
			while(rs.next()) {
				Users newU;
				int uId = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				String admin = rs.getString("IS_ADMIN");
				boolean isAdmin = false;
				if(admin.equals("T")) {
					isAdmin = true;
				}
				newU = new Users(uId,uName,fname,lname,isAdmin); //Add retrieved user to list
				u.add(newU);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Return list of users in the database
		return u;
	}

	@Override
	public boolean deleteUser(int id) {
		
		CallableStatement cs = null;
		//Try to establish connection to database
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call DELETE_USERS(?)}";
			cs = conn.prepareCall(sql);	//Prepare call to database procedure
			cs.setInt(1, id);	//Set the in parameters for the DELETE_USERS procedure
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);	//Register the out parameters to catch the return value
			
			cs.executeUpdate();
			
			int result = cs.getInt(2);	//Store the return value 
			if(result == -1) {
				return false;	//If the return value is -1 the delete was not performed
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;	//Return true if the User was sucessfully deleted
	}

	@Override
	public boolean createUser(String username, String password,String isAdmin) {
		
		CallableStatement cs = null;
		//Try to establish connection to the database
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "{call INSERT_USERS(?,?)}";
			cs = conn.prepareCall(sql);	//prepare call to database procedure
			cs.setString(1, username);	//Set the in parameters of INSERT_USERS
			cs.setString(2, password);
			cs.setString(3, isAdmin);
			cs.registerOutParameter(4, java.sql.Types.NUMERIC);	//Register the out parameter to retrieve
			
			cs.executeUpdate();
			
			int result = cs.getInt(4);	//Store the returned value of the procedure
			if(result == -1) {
				return false;	//If the returned value is -1 then the User was not created
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Return true if the create successfully executed
		return true;
	}

}
