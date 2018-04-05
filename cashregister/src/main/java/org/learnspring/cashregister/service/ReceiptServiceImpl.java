package org.learnspring.cashregister.service;

import java.sql.SQLException;
import java.util.List;

import org.learnspring.cashregister.model.Transaction;
import org.learnspring.cashregister.repository.TransactionRepository;

public class ReceiptServiceImpl implements ReceiptService{
	
	private TransactionRepository receiptRepository;
	
	public void setTransactionRepository(TransactionRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}
	
	@Override
	public void createNewReceipt(Transaction transaction) throws SQLException {
		// TODO Auto-generated method stub
		receiptRepository.addTransaction(transaction);
	}
	
	@Override
	public List<Transaction> getAllReceiptsByAccountNumber(Long accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("AccountNumber IN Service" + accountNumber);
		List<Transaction> transactions=receiptRepository.getAllTransactionsByAccountNumber(accountNumber);
		return transactions;
	}
}
