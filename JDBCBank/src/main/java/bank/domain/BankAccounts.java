package bank.domain;

public class BankAccounts {

	private int bankAccountId;
	private int userId;
	private double balance;
	
	public BankAccounts() {
		super();
	}
	
	public BankAccounts(int bankAccountId, double balance) {
		super();
		this.bankAccountId = bankAccountId;
		this.balance = balance;
	}

	public BankAccounts(int bankAccountId, int userId, double balance) {
		super();
		this.bankAccountId = bankAccountId;
		this.userId = userId;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "BankAccounts [bankAccountId=" + bankAccountId + ", userId=" + userId + ", balance=" + balance + "]";
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
}
