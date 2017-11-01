package ers.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ers.dao.*;
import ers.domain.Reimbursements;
import ers.domain.Users;
import ers.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args){
		
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		List<Reimbursements> rl = new ArrayList<>();
		rl = rd.getPendingByUserId(4);
		UsersDao ud = new UsersDaoImpl();
		System.out.println(rl.toString());
		
		
	}
}
