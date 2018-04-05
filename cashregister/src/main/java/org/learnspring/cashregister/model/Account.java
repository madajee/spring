package org.learnspring.cashregister.model;

public class Account {
	
	private Long accountNumber;
	private String name;
	private boolean isActive;
	
	private Address address;
	private int balance;
	private String emailAddress;
	
	public Account() {
		
	}

	public Account(Long accountNumber, String name, boolean isActive, int balance,
			String emailAddress,String city,String country) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.isActive = isActive;
		this.balance = balance;
		this.emailAddress = emailAddress;
		Address address= new Address();
		address.setCity(city);
		address.setCountry(country);;
		this.address=address;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

	public Long getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return isActive;
	}

	public Address getAddress() {
		return address;
	}

	public int getBalance() {
		return balance;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", isActive=" + isActive + ", address="
				+ address + ", balance=" + balance + ", emailAddress=" + emailAddress + "]";
	}
	
	

}
