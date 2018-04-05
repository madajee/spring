package org.learnspring.cashregister.service;

import java.sql.SQLException;

import org.learnspring.cashregister.model.Account;

public interface AccountService {
	
	public void createNewAccount(Account account) throws SQLException;
	public Account retriveAccount(Long accountNumber) throws SQLException;

}
