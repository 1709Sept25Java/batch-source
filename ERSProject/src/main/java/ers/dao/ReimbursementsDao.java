package ers.dao;

import java.io.InputStream;
import java.util.List;

import ers.domain.Reimbursements;
import oracle.sql.BLOB;

public interface ReimbursementsDao {

	public List<Reimbursements> getPending();
	
	public List<Reimbursements> getResolved();
	
	public List<Reimbursements> getPendingByUserId(int id);
	
	public List<Reimbursements> getResolvedByUserId(int id);
	
	public void approveReimbursements(int id, int u_id);
	
	public void declineReimbursements(int id, int u_id);
	
	public void newReimbursements(Double amount, String desc, InputStream rec, int author, String type);

	public void noReceipt(Double amount, String desc, int author, String type);
}
