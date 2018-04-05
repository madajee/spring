package org.learnspring.cashregister.repository;

import java.sql.SQLException;

import org.learnspring.cashregister.model.Account;

public interface AccountRepository {
	
	public Account findAccountByNumber(Long accountNUmber) throws SQLException;
	public void save(Account account) throws SQLException;

}
