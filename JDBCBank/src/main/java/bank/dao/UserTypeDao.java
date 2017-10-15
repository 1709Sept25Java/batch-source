package bank.dao;

import java.util.List;

import bank.domain.UserType;

public interface UserTypeDao {
	
	public List<UserType> getAllUserType();
	
	public UserType getUserType(int userTypeId);

}
