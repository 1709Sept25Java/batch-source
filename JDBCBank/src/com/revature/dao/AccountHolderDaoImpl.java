package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.domain.AccHolderTransaction;
import com.revature.domain.AccountHolder;
import com.revature.util.ConnectionUtil;

public class AccountHolderDaoImpl {
	
	
	public static void main(String[] args) throws SQLException {
        DisplayMenu();
    }

    public static void DisplayMenu() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        String READ_MENU;

        // Display menu graphics
  
      
        System.out.print("Select option: 1, 2 or 3");

        READ_MENU = userInput.next();

//display menu based on user selection
        switch (READ_MENU) {
            case "1":
                AccountHolder ah1 = new AccountHolder();
                
                break;
            case "2":
                AccHolderTransaction tran = new AccHolderTransaction();
                break;
            case "3":
            	AccHolderTransaction trantype = new AccHolderTransaction();
                break;
            default:
                System.out.println("Invalid selection");
                break; 
        }
    }


	

}
