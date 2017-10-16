package com.JDBCBank.main;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.text.ParseException; 
import java.util.Scanner;
import com.JDBCBank.exceptions.*;
import com.JDBCBank.domain.*;
import com.JDBCBank.DAO.*;
import com.JDBCBank.util.JDBCBankConnection;
import com.JDBCBank.Sessions.*;


public class Driver {
	private Scanner sc = new Scanner (System.in);
	public Scanner getScanner() {
		return sc;
	}

	public static void main(String[] args) throws ParseException{
		while (true) {
			SessionOptions.startSession();
		}

	}

}
