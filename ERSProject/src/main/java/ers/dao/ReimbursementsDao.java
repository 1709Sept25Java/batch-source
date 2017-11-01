package ers.dao;

import java.util.List;

import ers.domain.Reimbursements;

public interface ReimbursementsDao {

	public List<Reimbursements> getPending();
	
	public List<Reimbursements> getResolved();
	
	public List<Reimbursements> getPendingByUserId(int id);
	
	public List<Reimbursements> getResolvedByUserId(int id);
	
	public void approveReimbursements(int id, int u_id);
	
	public void declineReimbursements(int id, int u_id);
}
