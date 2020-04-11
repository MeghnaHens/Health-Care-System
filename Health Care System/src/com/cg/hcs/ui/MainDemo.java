package com.cg.hcs.ui;
import java.util.Scanner;
import com.cg.hcs.bean.*;
import com.cg.hcs.dao.*;
import com.cg.hcs.services.*;
import com.cg.hcs.validation.*;
import com.cg.hcs.exception.*;

public class MainDemo {
	public static void main(String[] args) {
		
		boolean login = false;
		Scanner kb=new Scanner(System.in);
		String testName,centerName,firstName,lastName,password,emailid,contactNo;
		
		User usr=new User();
		Admin adm=new Admin();
		ServiceImplementation s=new ServiceImplementation();
		AppointmentInterfaceImplementation ai=new AppointmentInterfaceImplementation();
		CustomerDaoImpl cd=new CustomerDaoImpl();
		TestDaoImpl td=new TestDaoImpl();
		td.addPreAssignedTest();		
		DiagnosticCenterDaoImpl dc=new DiagnosticCenterDaoImpl();
		dc.addExistingCenter();
		
		while(true)
		{
			System.out.println("Log in as:\n1.Admin\n2.Customer");
			int number= kb.nextInt();
			if(number==1)
			{
				AdminDaoImpl ad=new AdminDaoImpl();
				ad.addAdmin();
				
				while(true) {
				System.out.println("Enter User Id: ");
				String id=kb.next();
				System.out.println("Enter Password: ");
				String pass=kb.next();
						
						for(Admin a: ad.getAdminList()) {
							if(a.getUserName().equals(id)) {
								login=s.login(adm, id, pass, ad.getAdminList(), ad.getAdminHash());
								break;
							}
						}
						if(login==true)
						{
							System.out.println("Welcome Admin "+id);
						}
						else
						{
							System.out.println("Enter correct User Name and Password..!");
							break;
						}
					
			while(true)
			{
			System.out.println("\n1.Show List of all diagnostic centers along with the tests done\n2.Add Diagnostic Center\n3.Add Test\n4.Remove Diagnostic Center\n5.Remove Test\n6.Exit");
			int option=kb.nextInt();
			switch(option) 
				{
							case 1:	System.out.println("Center names with Test names are: ");
							for(int i=0;i<dc.getCenterList().size();i++) {
								DiagnosticCenter d=dc.getCenterList().get(i);
								System.out.println("\nCenter Id: "+d.centerId+" Center name: "+d.centerName+"\nThe tests done here are: ");
				
								for(Test t:d.getListOfTests()) {
									
									System.out.println(t.testId+" "+t.testName);
									}
							}
							break;
								
							case 2:System.out.println("Enter the name of Diagnostic center to add in the list:  ");
								centerName=kb.next();
								try {
									ValidateImplementation.DiagnosticCenterValidate(centerName);
									s.addCenter(centerName,td.getTestList(),dc.getCenterList());
									System.out.println("Diagnostic center added successfully..\nNew center list is: ");
									for(DiagnosticCenter d : dc.getCenterList()) {
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
										
										if(s.isDiagnosticCenterPresent(diagnostic,dc.getCenterList())) {
											s.addTestInCenter(dc.getCenterList(),diagnostic,testName);
											
											for(int i=0;i<dc.getCenterList().size();i++)
											{
												DiagnosticCenter center=dc.getCenterList().get(i);
												if((center.centerId).equals(diagnostic)) {
													System.out.println("\nCenter Id: "+center.centerId+" Center name: "+center.centerName+"\nThe tests done here are: ");
													for(Test te:center.getListOfTests()){
														System.out.println(te.testId+" "+te.testName);
														}
												}
											}
										}
										else
											System.out.println("Diagnostic center "+diagnostic+" is not present");
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
						       s.removeCenter(centerId, dc.getCenterList());
						       System.out.println("After removing the center list is: ");
						       for(DiagnosticCenter d : dc.getCenterList()) {
									System.out.println(d.centerId+" "+d.centerName);
								}
								break;
								
							case 5:System.out.println("Enter the diagnostic center id from which you want to remove test: ");
							  
								try {
									    String diagnostic=kb.next();
										ValidateImplementation.DiagnosticCenterIdValidate(diagnostic);
										System.out.println("Enter the Test name to remove: ");
										testName=kb.next();
										kb.nextLine();
										ValidateImplementation.TestNameValidate(testName);
										
										if((s.isDiagnosticCenterPresent(diagnostic,dc.getCenterList()))) { 
											s.removeTestFromCenter(dc.getCenterList(),diagnostic,testName);
											 System.out.println("After removing the test list is: ");
											for(int i=0;i<dc.getCenterList().size();i++)
											{
												DiagnosticCenter center=dc.getCenterList().get(i);
												if((center.centerId).equals(diagnostic)) {
													System.out.println("\nCenter Id: "+center.centerId+" Center name: "+center.centerName+"\nThe tests done here are: ");
													for(Test te:center.getListOfTests()){
														System.out.println(te.testId+" "+te.testName);
														}
												}
											}
										}
										else
											System.out.println("Diagnostic center or test does not present");
								}
								catch(TestNameException e) {
									System.out.println(e);
								}
								catch(DiagnosticCenterIdException e) {
									System.out.println(e);
								}
								break;
								
							case 6:System.out.println("Exit...");
							       System.exit(0);
								
							default: System.out.println("Please enter correct option...");
									break;
					}
				  }
				}
			}
			else if(number==2)
			{
				while(true)
				 {
				System.out.println("Press 1 for REGISTER\nPress 2 for LOGIN");
				int opt=kb.nextInt();
				
		if(opt==1)
		{
			while (true)
			{
			   System.out.println("Enter your first name:");
			 firstName=kb.next();
			
			boolean firstNameFlag=CustomerValidation.nameValidation(firstName);
			if(!firstNameFlag)
				System.out.println("First letter should be capital!");
			else
				break;
			}
			
			
			while (true)
			{
				System.out.println("Enter your last name:");
				lastName=kb.next();
			
			boolean lastNameFlag=CustomerValidation.nameValidation(lastName);
			if(!lastNameFlag)
				System.out.println("First letter should be capital!");
			else
				break;
			}
			
			while(true)
			{
			System.out.println("Enter your email id:");
			emailid=kb.next();
			
			
			boolean emailFlag=CustomerValidation.validateeamilId(emailid);
			if(!emailFlag)
				System.out.println("Enter a valid email account!");
			else 
				break;
			}
			while(true)
			{
				System.out.println("Enter your password:");
				password=kb.next();
				
				boolean passFlag=CustomerValidation.validatepassword(password);
				if(!passFlag)
					System.out.println("Password should be equal or greater than 6 must conatain uppercase and lowercase characters!");
				else
					break;
			}
			
			while(true)
			{
				System.out.println("Enter your contactNo:");
				contactNo=kb.next();
			
			boolean contactNoFlag=CustomerValidation.contactNumberValidate(contactNo);
			if(!contactNoFlag)
				System.out.println("Number should be of 10 digits!");
			else
				break;
			}
				System.out.println("Welcome to health care :) !!");
				User user1=new User(firstName,lastName,"Customer",emailid,Long.parseLong(contactNo),password);
				cd.addCustomer(user1);
				
				String UserName=firstName.substring(0,3)+lastName.substring(0,4);
				System.out.println("Your Username is "+UserName);
				String userId=usr.getUserId();
				System.out.println("Your UserId is "+userId);	
		}
			
		else if(opt==2)
		{
			
			System.out.println("Enter your username:");
			String Id=kb.next();
			System.out.println("Enter your password:");
			String pass=kb.next();
			
			s.Register(cd.getCustomerList(), pass);
			if(cd.getCustomerList().contains(Id)&&pass.contentEquals(usr.getUserPassword())) {
					System.out.println("Congratulations, you successfully logged in !!");
					System.out.println("enter 1 for making an appointment\n enter 2 for checking your appointment status:");
					int op=kb.nextInt();
					
					if(op==1)
					{
						
						System.out.println("Enter your convenient Date in the format: dd-MM-yyyy ");
						
							String date1=kb.next();
											
							//System.out.println("Enter your convenient time (hh:mm):");
							 //String time = kb.next();

							System.out.println("Here are the list of diagnostic center:");
							System.out.println(dc.getCenterList());
														
							System.out.println("enter the diagnostic center name:");
							String centername=kb.next();
							
							System.out.println("here are the list of test the "+centername+" center provides:");
							System.out.println(td.getTestList());
							
							System.out.println("enter the test name from the above options");
							System.out.println("Remember you can't choose more than one test at a time!!\n");
						
							String testname=kb.next();
							ai.makeAppointment(usr,centername,testname,dc.getCenterList(),td.getTestList(),date1);

					System.out.println("your form is submitted");
					}
					
					
					if(op==2)
					{
						System.out.println("provide your appointment details:");
					}
					
			}			
			else 
				System.out.println("Please fill correct username and password....");
			
		}	
		}
			}
			else
				System.out.println("Choose correct option...");	
		}
	}
}
