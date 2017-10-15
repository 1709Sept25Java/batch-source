package bank.domain;

import java.util.Date;

public class Transactions {

		private int transactionId;
		private Date date;
		private int bankAccountId;
		private String info;
		
		public Transactions() {
			super();
		}

		public Transactions(int transactionId, Date date, String info) {
			super();
			this.transactionId = transactionId;
			this.date = date;
			this.info = info;
		}
		
		public Transactions(int transactionId, Date date, int bankAccountId, String info) {
			super();
			this.transactionId = transactionId;
			this.date = date;
			this.bankAccountId = bankAccountId;
			this.info = info;
		}

		@Override
		public String toString() {
			return "Transactions [transactionId=" + transactionId + ", date=" + date + ", bankAccountId="
					+ bankAccountId + ", info=" + info + "]";
		}

		public int getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getBankAccountId() {
			return bankAccountId;
		}

		public void setBankAccountId(int bankAccountId) {
			this.bankAccountId = bankAccountId;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		} 
		
		
		
}
