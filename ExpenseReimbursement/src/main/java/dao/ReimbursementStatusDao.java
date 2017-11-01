package dao;

import java.util.List;

public interface ReimbursementStatusDao {

	public List<ReimbursementStatus> getReimbursementStatus();
	public String getStatusById(int statusId);
	public ReimbursementStatus getReimbursementStatusById(int statusId);
}
