package ers.dao;

import java.util.List;

import ers.domain.Reimbursements;

public interface ReimbursementsDao {

	public List<Reimbursements> getPending();
	
	public List<Reimbursements> getResolved();
}
