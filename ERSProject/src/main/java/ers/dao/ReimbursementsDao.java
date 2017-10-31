package ers.dao;

import java.util.List;

import ers.domain.Reimbursements;

public interface ReimbursementsDao {

	public List<Reimbursements> getPending();
	
	public List<Reimbursements> getResolved();
	
	public List<Reimbursements> getPendingByUserId(int id);
	
	public List<Reimbursements> getResolvedByUserId(int id);
}
