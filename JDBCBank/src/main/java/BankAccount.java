
public class BankAccount {

	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int bankaccid, int balance) {
		super();
		this.bankaccid = bankaccid;
		this.balance = balance;
	}
	private int bankaccid;
	private int balance;
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
	@Override
	public String toString() {
		return "BankAccount [bankaccid=" + bankaccid + ", balance=" + balance + "]";
	}
	
}
