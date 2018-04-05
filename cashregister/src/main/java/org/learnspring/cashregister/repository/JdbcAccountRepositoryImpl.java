package org.learnspring.cashregister.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.learnspring.cashregister.model.Account;

import org.learnspring.cashregister.model.Address;

public class JdbcAccountRepositoryImpl implements AccountRepository {
	
private DataSource dataSource;

	public JdbcAccountRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Account findAccountByNumber(Long accountNUmber) throws SQLException {
		String query="select * from account a where a.accountNumber=? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, accountNUmber);
		ResultSet rs=preparedStatement.executeQuery();
		Account account=null;
		if(rs.next()){
			 account= new Account();
			 account.setName(rs.getString("name"));
			account.setAccountNumber(rs.getLong("accountNumber"));
			account.setActive(rs.getBoolean("isactive"));
			Address address= new Address();
			address.setCity(rs.getString("city"));
			address.setCountry(rs.getString("country"));
			account.setAddress(address);
			account.setBalance(rs.getInt("balance"));
			account.setEmailAddress(rs.getString("emailaddress"));
			
		}
		connection.close();
		return account;
	}
	
	public void save(Account account) throws SQLException {
		String query="insert into account(name,isactive,city,country,balance,emailaddress) values(?,?,?,?,?,?)";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, account.getName());
		preparedStatement.setBoolean(2, account.isActive());
		preparedStatement.setString(3, account.getAddress().getCity());
		preparedStatement.setString(4, account.getAddress().getCountry());
		preparedStatement.setInt(5, account.getBalance());
		preparedStatement.setString(6, account.getEmailAddress());
		preparedStatement.executeUpdate();
		
		System.out.println("Account saved");
	}
}
