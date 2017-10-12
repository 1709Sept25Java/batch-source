package com.revature.domain;

import java.sql.Date;

public class UserHist {

	private int id;
	private String type;
	private Date logDate;
	private Users owner;
	private BankAccount owned;
}
