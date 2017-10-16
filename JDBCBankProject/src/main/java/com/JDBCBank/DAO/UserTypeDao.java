package com.JDBCBank.DAO;
import java.util.List;
import com.JDBCBank.domain.UserTypes;
public interface UserTypeDao {
	
public List<UserTypes> getAllUserType();
	
	public UserTypes getUserType(int userTypeId);
}
