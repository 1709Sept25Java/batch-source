
public class BankAccount {

	
	public BankAccount(int balance, Users userId) {
		super();
		this.balance = balance;
		this.userId = userId;
	}
	public BankAccount(int bankaccid, int balance, Users userId) {
		super();
		this.bankaccid = bankaccid;
		this.balance = balance;
		this.userId = userId;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int bankaccid;
	private int balance;
	private Users userId;
	public int getBankaccid() {
		return bankaccid;
	}
	public void setBankaccid(int bankaccid) {
		this.bankaccid = bankaccid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BankAccount [bankaccid=" + bankaccid + ", balance=" + balance + ", userId=" + userId + "]";
	} 
	
	
}
