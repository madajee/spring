package org.learnspring.cashregister.model;

import java.util.Date;

import org.learnspring.cashregister.model.TransactionType;

public class Transaction {
	
	private Long transactionId;
	private Long accountNumber;
	private Date transactionDate;
	private int amount;	
	private TransactionType txType;
	public Transaction(Long accountNumber, Date transactionDate, int amount,
			TransactionType txType) {
		super();
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.txType = txType;
	}
	public Transaction() {
		
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public TransactionType getTxType() {
		return txType;
	}
	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}

}
