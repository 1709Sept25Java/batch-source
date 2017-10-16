package com.revature.bankservices;
import java.util.ArrayList;
import javax.security.auth.login.AccountNotFoundException;
import com.revature.dao.*;
import com.revature.exception.*;

public interface BankServices {
	
	int getAccountBalance(int custId, int acctNo)
		throws InvalidAcctBalance;
	
	int acceptCustomerDetails(String custName, String HomeAddressCity,
			String HomeAddressState, int HomeAddressPincode,
			String LocalAddressCity, String LocalAddressState,
			int LocalAddressPincode) throws InvalidRegisteredUser;

	int openAccount(int custId, int balance, String accType)
		throws InvalidCustomerID, InvalidPswdException, InvalidRegisteredUser;
	
	int withdraw(int custId, int accNo, int amt)
		throws InvalidAcctBalance, InvalidCustomerID, InvalidPswdException, InvalidRegisteredUser;
	
	
	
}
