package demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	private String userName;
	private String userEmail;
	private String address;
	
	public Employee() {}

	public Employee(String userId, String userName, String userEmail, String address) 
	{
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.address = address;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getAddress() {
		return address;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", address=" + address + "]";
	}
}
