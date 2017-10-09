package com.revature.main;

import java.sql.Connection;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

public class Driver {

public static void main(String[] args) {
			
	Connection con = null;
		try {
			con = ConnectionUtil.GetConnectionFromFile();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
