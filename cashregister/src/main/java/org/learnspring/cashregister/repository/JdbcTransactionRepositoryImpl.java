package org.learnspring.cashregister.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.learnspring.cashregister.model.Transaction;

import org.learnspring.cashregister.model.TransactionType;


public class JdbcTransactionRepositoryImpl implements TransactionRepository{
	
	private DataSource dataSource;	

	public JdbcTransactionRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Long addTransaction(Transaction transaction) throws SQLException {
		String query="insert into Transaction(accountnumber,transactiondate,amount,txtype) values(?,?,?,?) ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setLong(1, transaction.getAccountNumber());
		preparedStatement.setDate(2, new Date(transaction.getTransactionDate().getTime()));
		preparedStatement.setInt(3, transaction.getAmount());
		preparedStatement.setString(4, transaction.getTxType().toString());
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.getGeneratedKeys();
		if(rs.next()){
			return rs.getLong(1);
		}
		return null;
	}
	
	public List<Transaction> getAllTransactionsByAccountNumber(Long accountNumber) throws SQLException {
		String query="select * from Transaction td where td.accountNumber=?";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, accountNumber);
		ResultSet rs=preparedStatement.executeQuery();
		
		List<Transaction> transactions= new ArrayList<Transaction>();
		while(rs.next()){ 
			Transaction transaction= new Transaction();
			
			transaction.setTransactionId(rs.getLong("transactionId"));
			transaction.setTransactionDate(new Date(rs.getDate("transactionDate").getTime()));
			transaction.setAccountNumber(rs.getLong("accountNumber"));
			transaction.setAmount(rs.getInt("amount"));
			String transactionType=rs.getString("txtype");
			if(transactionType.equals(TransactionType.CREDIT)){
				transaction.setTxType(TransactionType.CREDIT);
			}else{
				transaction.setTxType(TransactionType.DEBIT);
			}
			transactions.add(transaction);
		}
		return transactions;
	}
}
