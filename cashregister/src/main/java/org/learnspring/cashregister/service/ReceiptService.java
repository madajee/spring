package org.learnspring.cashregister.service;

import java.sql.SQLException;
import java.util.List;

import org.learnspring.cashregister.model.Transaction;

public interface ReceiptService {
	
	public void createNewReceipt(Transaction transaction) throws SQLException;
	public List<Transaction> getAllReceiptsByAccountNumber(Long accountNumber) throws SQLException;

}
