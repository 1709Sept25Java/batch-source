package revature.assignment2;

import java.util.List;

public interface DAOInterface {
	
	public List<UserType> getUserTypes();
	public UserType getUserTypeById(int id);

}
