package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface AccountDao {
	public Boolean deleteAccount();
	public Boolean depositAccount(int amount);
	public Boolean withdrawAccount(int amount);
}
