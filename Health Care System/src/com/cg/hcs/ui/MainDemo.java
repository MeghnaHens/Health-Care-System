package com.cg.hcs.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.cg.hcs.bean.*;
import com.cg.hcs.services.*;
import com.cg.hcs.validation.*;
import com.cg.hcs.exception.*;

public class MainDemo {
	public static void main(String[] args) {
		
		Scanner kb=new Scanner(System.in);
		String testName,centerName,firstname,lastname,password,emailid,contactNo;
		ArrayList<User> Customer=new ArrayList<User>();
		User usr=new User();
		ServiceImplementation s=new ServiceImplementation();
		
		List<Test> testArray=new ArrayList<Test>();
		Test t1=new Test("Blood Test");
		Test t2=new Test("X-Ray");
		Test t3=new Test("Urine Test");
		Test t4=new Test("Blood Sugar Test");
		Test t5=new Test("TSH test");
		testArray.add(t1);
		testArray.add(t2);
		testArray.add(t3);
		testArray.add(t4);
		
		
		List<DiagnosticCenter> centerArray=new ArrayList<DiagnosticCenter>();
		DiagnosticCenter d1=new DiagnosticCenter("Gariahat",testArray);
		DiagnosticCenter d2=new DiagnosticCenter("Kestopur",testArray);
		DiagnosticCenter d3=new DiagnosticCenter("Beleghata",testArray);
		DiagnosticCenter d4=new DiagnosticCenter("Joramandir",testArray);
		centerArray.add(d1);
		centerArray.add(d2);
		centerArray.add(d3);
		centerArray.add(d4);
		DiagnosticCenter dc=new DiagnosticCenter();
		dc.setListOfTests(testArray);
		
		while(true)
		{
			System.out.println("Log in as:\n1.Admin\n2.Customer");
			int log= kb.nextInt();
			if(log==1)
			{
				List<User> admin=new ArrayList<User>();
				HashMap<User, String> adminHash = new HashMap<>();
				User u1=new User("Meghna","Hens","Admin","meghna@gmail.com",8967330644L,"m@1998",centerArray);
				User u2=new User("Neha","Biswakarma","Admin","neha@gmail.com",8013805556L,"n@1996",centerArray);
				User u3=new User("Karishma","Upadhyay","Admin","karishma@gmail.com",8109993685L,"k@1998",centerArray);
				User u4=new User("Nikhil","Gupta","Admin","nikhil@gmail.com",9768519113L,"ni@1998",centerArray);
				admin.add(u1);
				admin.add(u2);
				admin.add(u3);
				admin.add(u4);
				adminHash.put(u1,"Megx123");
				adminHash.put(u2,"Neha123");
				adminHash.put(u3,"Kari123");
				adminHash.put(u4,"Niki123");
				
				while(true) {
				System.out.println("enter User Id: ");
				String id=kb.next();
				System.out.println("Enter Password: ");
				String pass=kb.next();
				
				if(adminHash.containsValue(id) && pass.equals(u1.getUserPassword()))
				{
					System.out.println("Welcome Admin");
				}
				else if(adminHash.containsValue(id) && pass.equals(u2.getUserPassword()))
				{
					System.out.println("Welcome Admin");
				}
				else if(adminHash.containsValue(id) && pass.equals(u3.getUserPassword()))
				{
					System.out.println("Welcome Admin");
				}
				else if(adminHash.containsValue(id) && pass.equals(u4.getUserPassword()))
				{
					System.out.println("Welcome Admin");
				}
				else
				{
					System.out.println("Enter Correct User Name And Password..");
					break;
				}
				
			while(true)
			{
			System.out.println("\n1.Show List of all diagnostic centers along with the tests done\n2.Add Diagnostic Center\n3.Add Test\n4.Remove Diagnostic Center\n5.Remove Test\n6.Exit");
			int option=kb.nextInt();
			switch(option) 
				{
							case 1:	System.out.println("Center names with Test names are: ");
							for(DiagnosticCenter d:centerArray) {
								System.out.println("Center Id: "+d.centerId+" Center name: "+d.centerName+"\nThe tests done here are: ");
								for(Test t:testArray) {
									
									System.out.println(t.testId+" "+t.testName);
									}
								System.out.println("\n");
							}
							break;
								
							case 2:System.out.println("Enter the Diagnostic center to add in the list:  ");
								centerName=kb.next();
								try {
									ValidateImplementation.DiagnosticCenterValidate(centerName);
									s.addCenter(centerName,testArray,centerArray);
									System.out.println("Diagnostic center added successfully..\nNew center list is: ");
									for(DiagnosticCenter d:centerArray) {
									System.out.println(d.centerId+" "+d.centerName);
									}
									break;
									}
								catch(DiagnosticCenterNameException e) {
									System.out.println(e);
								}
								break;
								
							case 3:System.out.println("Enter the diagnostic center id in which you want to add new test: ");
							  
								try {
									    String diagnostic=kb.next();
										ValidateImplementation.DiagnosticCenterIdValidate(diagnostic);
										System.out.println("Enter the Test name to add: ");
										testName=kb.next();
										ValidateImplementation.TestNameValidate(testName);
									
										for(DiagnosticCenter d:centerArray) {
										if(d.getCenterId().equals(diagnostic)) {
											s.addTestInCenter(centerArray,testArray,diagnostic,testName);
										}
										else
										{
											System.out.println("Diagnostic center does not exist...");
											break;
										}
								   }
								}
								catch(TestNameException e) {
									System.out.println(e);
								}
								catch(DiagnosticCenterIdException e) {
									System.out.println(e);
								}
								break;
								
							case 4:System.out.println("Enter the Center Id to remove the test: ");
						       String centerId=kb.next();
						       s.removeCenter(centerId, centerArray);
						       System.out.println("After removing the center list is: ");
						       for(DiagnosticCenter d:centerArray) {
									System.out.println(d.centerId+" "+d.centerName);
								}
								break;
								
							case 5:System.out.println("Enter the test Id to remove the test: ");
							       String testId=kb.next();
							       s.removeTest(testId, testArray);
							       System.out.println("After removing the test list is: ");
							       for(Test t:testArray) {
										System.out.println(t.testId+" "+t.testName);
									}
								break;
								
							case 6:System.out.println("Exited...");
							       System.exit(0);
								
							default: System.out.println("Please enter correct option...");
									break;
					}
				  }
				}
			}
			else if(log==2)
			{
				while(true)
				 {
				System.out.println("Press 1 for REGISTER\nPress 2 for LOGIN");
				int opt=kb.nextInt();
				
		if(opt==1)
		{
			while (true)
			{
			   System.out.println("enter your first name:");
			 firstname=kb.next();
			
			boolean firstnameflag=CustomerValidation.nameValidation(firstname);
			if(!firstnameflag)
				System.out.println("first letter should be capital!");
			else
				break;
			}
			
			
			while (true)
			{
				System.out.println("enter your last name:");
				lastname=kb.next();
			
			boolean lastnameflag=CustomerValidation.nameValidation(firstname);
			if(!lastnameflag)
				System.out.println("first letter should be capital!");
			else
				break;
			}
			
			while(true)
			{
			System.out.println("enter your email id:");
			emailid=kb.next();
			
			
			boolean emailFlag=CustomerValidation.validateeamilId(emailid);
			if(!emailFlag)
				System.out.println("enter a valid email account!");
			else 
				break;
			}
			while(true)
			{
				System.out.println("enter your password:");
				password=kb.next();
				
				boolean passFlag=CustomerValidation.validatepassword(password);
				if(!passFlag)
					System.out.println("password should be equal or greater than 6 must conatain uppercase and lowercase characters!");
				else
					break;
			}
			
			while(true)
			{
				System.out.println("enter your contactNo:");
				contactNo=kb.next();
			
			boolean contactNoFlag=CustomerValidation.contactNumberValidate(contactNo);
			if(!contactNoFlag)
				System.out.println("Number should be of 10 digits!");
			else
				break;
			}
				System.out.println("Welcome to health care :) !!");
				usr.setUserFirstName(firstname);
				usr.setUserLastName(lastname);
				usr.setContactNumber(Long.parseLong(contactNo));
				usr.setEmailId(emailid);
				usr.setUserPassword(password);
				usr.setUserId();
				Customer.add(usr);
				String UserName=firstname.substring(0,3)+lastname.substring(0,3);
				System.out.println("your Username is "+UserName);
				String userId=usr.getUserId();
				System.out.println("your UserId is "+userId);
		}
			
		else if(opt==2)
		{
			
			System.out.println("enter your username:");
			String Id=kb.next();
			System.out.println("enter your password:");
			String pass=kb.next();
			
			s.Register(Customer, pass);
			if(Customer.contains(Id)&&pass.contentEquals(usr.getUserPassword()))
					{
				System.out.println(" Congratulations, you successfully logged in !!");
					}else {
						System.out.println("Please fill correct username and password.....");
					}
			
		}	
		}
			}
			else
				System.out.println("Choose correct option...");	
		}
	}
}
