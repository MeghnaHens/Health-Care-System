package com.cg.hcs.bean;

import java.util.List;

public class Admin {
	static int id=1;
	public String userId="HCSAD";
	List<DiagnosticCenter> centerList;
	String lastName,firstName,userPassword,userRole,emailId,userName;
	String gender;
	long contactNumber;
	
	public Admin(String firstName,String lastName,String gender,String userRole,String emailId,long contactNumber,String userPassword,List<DiagnosticCenter> centerList) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender=gender;
		this.userName=firstName+lastName;
		this.userId=userId+(id++);
		this.userRole = userRole;
		this.emailId=emailId;
		this.contactNumber = contactNumber;
		this.userPassword = userPassword;
		this.centerList=centerList;
		
	}
	public Admin() {
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}
	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/*public static void setId() {
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
	public String getUserName(){
		return userName;
	}*/
}
