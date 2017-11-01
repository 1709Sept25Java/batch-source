package com.revaturedao;

import java.sql.SQLException;
import com.revature.pojo.*;

public class ManageReimbursement {

	public static void main(String[] args) throws ClassNotFoundException {

		//getReimbStatusImpl(60, "Cameran");
	}

	public void submitReimbursementImpl() throws ClassNotFoundException {
		String username = "";
		String password = "";

		ReimbursementDao rembDao = new ReimbursementDao();
		Reimbursement reimb = new Reimbursement();
		try {
			User user = new User();
			UserDao userDao = new UserDao();
			Reimbursmentype reimbType = new Reimbursmentype();
			ReimbursmentStatus reimbStatus = new ReimbursmentStatus();

			if (UserBusinessLogic.validateUser(username, password) == true) {
				user = userDao.getUserByUserNamePassword(username, password);

				rembDao.submitReimbursement(600.43, "Travel Expense", null, null, user, reimbType, reimbStatus);
				System.out.println(reimb.getAmount());
			} else {
				System.out.println("wrong username or password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void setReimbStatus(String rsStatus, int rtId) throws ClassNotFoundException {

		ReimbursementDao rembDao = new ReimbursementDao();
		try {
			User user = new User();
			UserDao userDao = new UserDao();
			ReimbursmentStatus reimbStatus = new ReimbursmentStatus();

			String username = user.getUserName();
			String password = userDao.getUserPassword(username);

			if (UserBusinessLogic.validateUser(username, password) == true) {
				user = userDao.getUserByUserNamePassword(username, password);
				reimbStatus.setRs_status(rsStatus);
				reimbStatus.setRt_statusId(rtId);
				rembDao.updateReimbStatus(user);
				System.out.println(reimbStatus.getRs_status());
			} else {
				System.out.println("wrong username or password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void getReimbStatusImpl(int authorId, String username) throws ClassNotFoundException {

		try {

			UserDao userDao = new UserDao();
			ReimbursementDao rembDao = new ReimbursementDao();
			Reimbursement reimb = new Reimbursement();

			String password = userDao.getUserPassword(username);

			if (UserBusinessLogic.validateUser(username, password) == true) {
				User user = userDao.getUserByUserNamePassword(username, password);
				System.out.println("user exists" + user.getFirstName());
				int id = user.getUserId();
				if (authorId == id) {
					rembDao.getReimbStatus(id);
					System.out.println(reimb.getRt_statusId()+ ""+reimb.getAmount());
				}
			} else {
				System.out.println("wrong username or password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
