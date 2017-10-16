
public interface BankAccountDao {
	//GETBANKACCID
	public BankAccount getBankAccountById(int bankaccid);
	public int transaction(int bankId, int amount);
	public int createBankAccount(BankAccount bankaccount);
	public int deleteAccount(int bankaccid);
	
}
