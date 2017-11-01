package dao;

import java.sql.Timestamp;
import java.util.List;

public interface ReimbursementsDao {
	public List<Reimbursements> viewPendingRequests(String username);
	public boolean submitRequest(double amount, String description, Timestamp submitted, int userId, int typeId);
	public boolean approveDenyRequest(int resolverid, int status, int remid, int authorid);
	public List<Reimbursements> viewReimResolvedRequest();
	public java.sql.Timestamp getCurrentTimeStamp();
	public List<Reimbursements> viewResolvedRequest(String username);
	public List<Reimbursements> viewAllPendingRequests();
	public List<Reimbursements> viewAllRequest(String firstname,String lastname);

}
