package bank.main;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import bank.dao.*;
import bank.domain.*;
import bank.exceptions.InvalidPasswordException;
import bank.exceptions.UsernameDoesNotExistException;
import bank.util.ConnectionUtil;
import bank.session.*;

public class Driver {

	private Scanner sc = new Scanner(System.in);

	public Scanner getScanner() {
		return sc;
	}

	public static void main(String[] args) throws ParseException, UsernameDoesNotExistException, InvalidPasswordException {
	
		while(true) {
			SessionOptions.startSession();
		}
	}
		
}