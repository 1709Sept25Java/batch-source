package driver;

import java.sql.Connection;
import java.sql.Timestamp;

import connection.Connections;
import dao.*;

public class Driver {

	public static void main(String[] args) {
		Connection con = null;
		try {

			con = Connections.getConnectionFromFile();
			System.out.println(con.getMetaData().getDriverName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	/*	ReimbursementTypeDao rtd = new ReimbursementTypeImpl();
		System.out.println(rtd.getReimbursementType().toString());
		System.out.println(rtd.getReimbursementTypeById(21).toString());
		
		ReimbursementStatusDao rsd = new ReimbursementStatusDaoImpl();
		System.out.println(rsd.getReimbursementStatus().toString());
		System.out.println(rsd.getStatusById(21));
		System.out.println(rsd.getReimbursementStatusById(22));
	
		UserRolesDao urd = new UserRolesDaoImpl();
		System.out.println(urd.getUserRolesById(2).toString());
		*/
		UsersDao ud = new UsersDaoImpl();
		//System.out.println(ud.getUserByUsername("Manager"));
	/*	//System.out.println(ud.checkPassword("Employee", "Employee"));
		System.out.println(ud.checkManager("Manager"));
		System.out.println(ud.getAllUsers().toString());
		System.out.println(ud.empUpdate("Employee", "Employee123", "Hayley", "De Vaen", "hdevaen2@gmail.com"));
		System.out.println(ud.empResetPass("Employee", "password123"));
		System.out.println(ud.getUserById(1));*/
		//System.out.println(ud.isValidUser("Manager","Manager123"));
		//System.out.println(ud.empUpdate("Employee", "Hayley", "Johnson", "hdevaen2@gmail.com"));
		
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//System.out.println(rd.submitRequest(700,"Technology",timestamp,4,24));
		//ReimbursementsDao rd = new ReimbursementsDaoImpl();

		//System.out.println(rd.viewPendingRequests("amenier3"));
		System.out.println(rd.viewResolvedRequest("Employee"));
		//System.out.println(rd.approveDenyRequest(1, 23, 22, 4));
		//System.out.println(rd.viewReimResolvedRequest().toString());
		//System.out.println(rd.viewAllPendingRequests().toString());
		//System.out.println(rd.viewAllRequest("Lorelle","Schutze"));
	}
	

}
