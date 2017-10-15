package bank.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.exceptions.InvalidPasswordException;
import bank.exceptions.UsernameDoesNotExistException;

public class UsersDaoImplTest {

	UsersDao ud = new UsersDaoImpl();
	
	@Test
	public final void getUserId() {
		int id = ud.getUserId("admin", "password");
		assertEquals(1, id);
	}
	
	@Test(expected = UsernameDoesNotExistException.class)
	public final void userNameDoesNotExist() throws UsernameDoesNotExistException, InvalidPasswordException {
		boolean bool = ud.isValidUser("jane", "hello");
	}
	
	@Test(expected = InvalidPasswordException.class)
	public final void invalidPassword() throws UsernameDoesNotExistException, InvalidPasswordException {
		boolean bool = ud.isValidUser("BOB", "123");
	}
	
	@Test
	public final void getUserTypeId() {
		int id = ud.getUserTypeId("admin");
		assertEquals(2, id);
	}
	
	@Test
	public final void updateOnePassword() {
		int pw = ud.updatePassword(124, "bananas");
		assertEquals(1, pw);
	}
}
