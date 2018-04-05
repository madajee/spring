package org.learnspring.cashregister.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.learnspring.cashregister.repository.AccountRepository;
import org.learnspring.cashregister.repository.JdbcAccountRepositoryImpl;
import org.learnspring.cashregister.model.Account;

public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	//private DataSource dataSource;
	
	/*public AccountServiceImpl() {
		
	}*/
	
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void createNewAccount(Account account) throws SQLException {
		//accountRepository =  new JdbcAccountRepositoryImpl(dataSource);
		accountRepository.save(account);
		
	}
	
	

	public Account retriveAccount(Long accountNumber) throws SQLException {
		//accountRepository =  new JdbcAccountRepositoryImpl(dataSource);
		Account account = accountRepository.findAccountByNumber(accountNumber);
		System.out.println("Retrieved Account: " + account);
		return account;
	}

}
