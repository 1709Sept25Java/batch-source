package dao;

import java.util.List;

public interface ReimbursementTypeDao {

	public List<ReimbursementType> getReimbursementType();
	public ReimbursementType getReimbursementTypeById(int typeId);
	
}
