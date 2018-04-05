package org.learnspring.cashregister.repository;

import java.sql.SQLException;
import java.util.List;

import org.learnspring.cashregister.model.Transaction;

public interface TransactionRepository {
	
	public Long addTransaction(Transaction transaction) throws SQLException;
	public List<Transaction> getAllTransactionsByAccountNumber(Long accountNumber) throws SQLException;

}
