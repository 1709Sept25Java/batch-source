package revature.assignment2;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOAbstract<T> {
	 public abstract int count() throws SQLException; 
	    protected final String tableName;
	    protected Connection con;

	    protected DAOAbstract(Connection con, String tableName) {
	        this.tableName = tableName;
	        this.con = con;
	    }
}
