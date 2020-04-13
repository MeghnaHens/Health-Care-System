package com.cg.hcs.bean;
import java.util.List;

public class User {
	static int id=1;
	public String userId="HCSUSER";
	public String username;
	
	List<DiagnosticCenter> centerList;
	String lastName,firstName,userPassword,userRole,emailId;
	long contactNumber;
	
	public User(String firstName,String lastName,String userRole,String emailId,long contactNumber,String userPassword) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId=this.userId+(id++);
		this.username=firstName.substring(0,3)+lastName.substring(0,3);
		this.userRole = userRole;
		this.emailId=emailId;
		this.contactNumber = contactNumber;
		this.userPassword = userPassword;
		
	}
	public User() {
		

	}
	public static void setId() {
		id = id++;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId() {
		this.userId = userId+(id++);
	}
	public String getUserFirstName() {
		return firstName;
	}
	public void setUserFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserLastName() {
		return lastName;
	}
	public void setUserLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
