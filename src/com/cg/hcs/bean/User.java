package com.cg.hcs.bean;
import java.util.List;

public class User {
	String userId;
	List<DiagnosticCenter> centerList;
	String userName,userPassword,userRole,emailId;
	long contactNumber;
	public User(String userName,String userRole,String emailId,long contactNumber,String userPassword,List<DiagnosticCenter> centerList) 
	{
		this.userName=userName;
		this.userRole=userRole;
		this.emailId=emailId;
		this.contactNumber=contactNumber;
		this.userPassword=userPassword;
		this.centerList=centerList;
	}
}
