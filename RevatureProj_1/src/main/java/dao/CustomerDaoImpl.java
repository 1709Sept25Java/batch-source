package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import driver.ManageConnection;
import domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public List<Customer> getCustomer(){
		List<Customer> cl = new ArrayList<>();
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			      
			PreparedStatement ps=con.prepareStatement(  
			"Select * from ERS_USERS");  
			      
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rms= rs.getMetaData();
			rms.getCatalogName(0);
			//if gets preparedstatement successfully, then returns true
			while(rs.next())
				{
				int cid=rs.getInt("U_ID");
				String username=rs.getString("U_USERNAME");
				String password=rs.getString("U_PASSWORD");
				String fname=rs.getString("U_FIRSTNAME");
				String lname=rs.getString("U_LASTNAME");
				String email=rs.getString("U_EMAIL");
				int reinburseid=rs.getInt("UR_ID");
				
				cl.add(new Customer(cid,username,password,fname,lname,email,reinburseid));
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				System.out.println("IO Exception!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return cl;
	}

	@Override
	public Customer getCustomerById(int id){
		Customer customer = null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement(  
					"Select * from ERS_USERS WHERE U_ID=?");  
					ps.setInt(1,id);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					int cid=rs.getInt("U_ID");
					String username=rs.getString("U_USERNAME");
					String password=rs.getString("U_PASSWORD");
					String fname=rs.getString("U_FIRSTNAME");
					String lname=rs.getString("U_LASTNAME");
					String email=rs.getString("U_EMAIL");
					int reinburseid=rs.getInt("UR_ID");
					
					customer= new Customer(cid,username,password,fname,lname,email,reinburseid);  
					}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			      
		return customer;
	} 
 
	@Override
	public void createCustomer(String user1, String pass1, String fname, String lname, String email) {
			try{  
				Connection con=ManageConnection.getConnectionFromFile(); 
				      
				PreparedStatement ps=con.prepareStatement(  
				"Insert into ERS_USERS(U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME,U_EMAIL) values (?,?,?,?,?)");  
				//ps.setString(1,user1);  
				//ps.setString(2,pass1);  
				      
				ResultSet rs=ps.executeQuery();
				ResultSetMetaData rms= rs.getMetaData();
				ps.executeUpdate();
				rms.getCatalogName(0);
				//if gets preparedstatement successfully, then returns true
				while(rs.next())
					{
					ps.setString(1, user1);
					ps.setString(2, pass1);
					ps.setString(3, fname);
					ps.setString(4, lname);
					ps.setString(5, email);
					}
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
					System.out.println("IO Exception!");
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}

	
	@Override
	public Customer updateCustomer() {
		Customer customer=null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			      
			PreparedStatement ps=con.prepareStatement(  
			"Update ERS_USERS(U_ID,U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID) set (?,?,?,?,?,?,?) where U_ID=?");  
			//ps.setString(1,user1);  
			//ps.setString(2,pass1);  
			      
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rms= rs.getMetaData();
			rms.getCatalogName(0);
			rs.updateRow();
			//if gets preparedstatement successfully, then returns true
			while(rs.next())
				{
				ps.setInt(1, customer.getUserId());
				ps.setString(2, customer.getUsername());
				ps.setString(3, customer.getPassword());
				ps.setString(4, customer.getFirstname());
				ps.setString(5, customer.getLastname());
				ps.setString(6, customer.getEmail());
				ps.setInt(7, customer.getReinburse());
				ps.setInt(8, customer.getUserId());					
				}
			
			customer= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)); 
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				System.out.println("IO Exception!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return customer;
	}
	

	@Override
	public int deleteCustomer(Customer delete) {
		int deleted=0;
		Customer customer=delete;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			      
			PreparedStatement ps=con.prepareStatement(  
			"Delete from ERS_USERS where U_ID=?");   
			      
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rms= rs.getMetaData();
			rms.getCatalogName(0);
			rs.updateRow();
			while(rs.next())
				{
				ps.setInt(1, customer.getUserId());				
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
				System.out.println("IO Exception!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return deleted; 
	}
	@Override
	public String getCustomerIdString(int id) {
		String customer;
		customer=
				getCustomerById(id).getUserId()+" | "
				+ getCustomerById(id).getUsername()+" | "
				+ getCustomerById(id).getPassword()+" | "
				+ getCustomerById(id).getFirstname()+" | "
				+ getCustomerById(id).getLastname()+" | "
				+ getCustomerById(id).getEmail()+" | "
				+ getCustomerById(id).getReinburse()+" | ";
		
		return customer;
		
	}

	@Override
	public Customer getCustomerByUser(String user) {
		Customer customer = null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement(  
					"Select * from ERS_USERS WHERE U_USERNAME=?");  
					ps.setString(1, user);
					//ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					int cid=rs.getInt("U_ID");
					String username=rs.getString("U_USERNAME");
					String password=rs.getString("U_PASSWORD");
					String fname=rs.getString("U_FIRSTNAME");
					String lname=rs.getString("U_LASTNAME");
					String email=rs.getString("U_EMAIL");
					int reinburseid=rs.getInt("UR_ID");
					
					customer= new Customer(cid,username,password,fname,lname,email,reinburseid);  
					}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			      
		return customer;
	}
	
	@Override
	public String getCustomerUserString(String user) {
		String customer;
		customer=
				getCustomerByUser(user).getUserId()+" | "
				+ getCustomerByUser(user).getUsername()+" | "
				+ getCustomerByUser(user).getPassword()+" | "
				+ getCustomerByUser(user).getFirstname()+" | "
				+ getCustomerByUser(user).getLastname()+" | "
				+ getCustomerByUser(user).getEmail()+" | "
				+ getCustomerByUser(user).getReinburse()+" | ";
		
		return customer;
		
	}
	
	@Override
	public Customer getCustomerAcc() {
		Customer customer = null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement(  
					"SELECT ERS_REINBURSEMENTS.R_ID, ERS_REINBURSEMENTS.R_AMOUNT, ERS_REINBURSEMENTS.R_AMOUNT, ERS_REINBURSEMENT_TYPE.RT_TYPE, ERS_REINBURSEMENT_STATUS.RS_STATUS" + 
					" FROM ((ERS_REINBURSEMENTS" + 
					" INNER JOIN ERS_REINBURSEMENT_TYPE ON ERS_REINBURSEMENTS.R_ID = ERS_REINBURSEMENT_TYPE.RT_ID)" + 
					" INNER JOIN ERS_REINBURSEMENT_STATUS ON ERS_REINBURSEMENT_TYPE.RT_ID = ERS_REINBURSEMENT_STATUS.RS_ID)");  
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					int rid=rs.getInt("R_ID");
					int rAmount=rs.getInt("R_AMOUNT");
					String rType=rs.getString("RT_TYPE");
					String rStatus=rs.getString("RS_STATUS");
					
					customer= new Customer(rid,rAmount,rType,rStatus);  
					}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			      
		return customer;
	}

	@Override
	public String getCustomerAccString() {
		String customer;
		customer=
				getCustomerAcc().getUserId()+" | "
				+ getCustomerAcc().getR_Amount()+" | "
				+ getCustomerAcc().getR_Type()+" | "
				+ getCustomerAcc().getR_Status()+" | ";
		
		return customer;
	}

	@Override
	public Customer getCustomerAccById(int id) {
		Customer customer = null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement(  
					"SELECT ERS_REINBURSEMENTS.R_ID, ERS_REINBURSEMENTS.R_AMOUNT, ERS_REINBURSEMENT_TYPE.RT_TYPE, ERS_REINBURSEMENT_STATUS.RS_STATUS" + 
					" FROM ((ERS_REINBURSEMENTS" + 
					" INNER JOIN ERS_REINBURSEMENT_TYPE ON ERS_REINBURSEMENTS.R_ID = ERS_REINBURSEMENT_TYPE.RT_ID)" + 
					" INNER JOIN ERS_REINBURSEMENT_STATUS ON ERS_REINBURSEMENT_TYPE.RT_ID = ERS_REINBURSEMENT_STATUS.RS_ID)" + 
					" Where R_ID=?");  
					ps.setInt(1,id);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					int rid=rs.getInt("R_ID");
					int rAmount=rs.getInt("R_AMOUNT");
					String rType=rs.getString("RT_TYPE");
					String rStatus=rs.getString("RS_STATUS");
					
					customer= new Customer(rid,rAmount,rType,rStatus);  
					}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!"); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
			      
		return customer;
	}

	@Override
	public String getCustomerAccStringById(int id) {
		String customer;
		customer=
				getCustomerAccById(id).getUserId()+" | "
				+ getCustomerAccById(id).getR_Amount()+" | "
				+ getCustomerAccById(id).getR_Type()+" | "
				+ getCustomerAccById(id).getR_Status()+" | ";
		
		return customer;
	}
	
	@Override
	public Customer getCustomerAccByUser(String user) {
		Customer customer = null;
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement(  
					"SELECT ERS_USERS.U_USERNAME, ERS_REINBURSEMENTS.R_ID, ERS_REINBURSEMENTS.R_AMOUNT, ERS_REINBURSEMENT_TYPE.RT_TYPE, ERS_REINBURSEMENT_STATUS.RS_STATUS" + 
					" FROM (((ERS_REINBURSEMENTS" + 
					" INNER JOIN ERS_REINBURSEMENT_TYPE ON ERS_REINBURSEMENTS.R_ID = ERS_REINBURSEMENT_TYPE.RT_ID)" + 
					" INNER JOIN ERS_REINBURSEMENT_STATUS ON ERS_REINBURSEMENT_TYPE.RT_ID = ERS_REINBURSEMENT_STATUS.RS_ID)" + 
					" Inner JOIN ERS_USERS ON ERS_REINBURSEMENT_TYPE.RT_ID= ERS_USERS.U_ID)" + 
					" Where ERS_USERS.U_USERNAME=?");  
					ps.setString(1,user);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
					int rid=rs.getInt("R_ID");
					int rAmount=rs.getInt("R_AMOUNT");
					String rType=rs.getString("RT_TYPE");
					String rStatus=rs.getString("RS_STATUS");
					
					customer= new Customer(rid,rAmount,rType,rStatus);  
					}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("IO Exception!"); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
			      
		return customer;
	}

	@Override
	public String getCustomerAccStringByUser(String user) {
		String customer;
		customer=
				+ getCustomerAccByUser(user).getR_Amount()+" | "
				+ getCustomerAccByUser(user).getR_Type()+" | "
				+ getCustomerAccByUser(user).getR_Status()+" | ";
		
		return customer;
	}

	@Override
	public void sendBlob(String file, int id) {
		try{  
			Connection con=ManageConnection.getConnectionFromFile(); 
			PreparedStatement ps=con.prepareStatement("Update ERS_REINBURSEMENTS SET R_RECEIPT=? WHERE R_ID=?");
			ps.executeQuery();
			
			File test=new File("C:\\Users\\jinli\\Desktop\\test1.txt");
			FileInputStream fileStream=new FileInputStream(file);
			ps.setBinaryStream(1, fileStream);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			System.out.println("Testing file send out");
			
			fileStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
