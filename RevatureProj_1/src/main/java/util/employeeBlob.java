package util;

import java.io.File;

import dao.CustomerDaoImpl;

public class employeeBlob {
	
	public employeeBlob() {
		super();
	}
	
	public static void blob() {
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		String file="C:\\Users\\jinli\\Desktop\\test1.png";
		cdi.sendBlob(file, 1);
	}

}
