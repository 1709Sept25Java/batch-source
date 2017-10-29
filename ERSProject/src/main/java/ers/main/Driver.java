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
		
		UsersDao ud = new UsersDaoImpl();
		Users u = new Users();
		List<Reimbursements> rl = new ArrayList<>();
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		rl = rd.getResolved();
		System.out.println(rl.toString());
		
		
	}
}
