package com.cg.hcs.ui;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

import com.cg.hcs.bean.*;
import com.cg.hcs.customerException.*; 
import com.cg.hcs.dao.*;
import com.cg.hcs.services.*;
import com.cg.hcs.validation.*;
import com.cg.hcs.exception.*;


public class MainDemo {
	static Logger logger=LogManager.getLogger(MainDemo.class);
	public static void main(String[] args) {
		
		
		boolean login = false;
		Scanner kb=new Scanner(System.in);
		String testName,centerName,firstname,lastname,password,emailid,contactNo,date1,time;
		
		User usr=new User();
		Admin adm=new Admin();
		AppointmentDaoImpl adi=new AppointmentDaoImpl();
		AppointmentInterfaceImplementation api = null;
		ServiceImplementation s=new ServiceImplementation();
		CustomerInterfaceImpl c=new CustomerInterfaceImpl();
		AppointmentInterfaceImplementation ai=new AppointmentInterfaceImplementation();
		CustomerDaoImpl cd=new CustomerDaoImpl();
		TestDaoImpl td=new TestDaoImpl();
		td.addPreAssignedTest();		
		DiagnosticCenterDaoImpl dc=new DiagnosticCenterDaoImpl();
		dc.addExistingCenter();
		
		while(true)
		{
			while(true) {
				System.out.println("----------Log in as----------\n1.Admin \n2.Customer");
				String number= kb.next();
					try {
						ValidateImplementation.optionChosenValidate(number);
					}
					catch(WrongOptionChosenException e) {
						//System.out.println(e);
						break;
					}	
				if(Integer.parseInt(number)==1)
				{
					AdminDaoImpl ad=new AdminDaoImpl();
					ad.addAdmin();
					
					while(true) {
					System.out.println("Enter User : ");
					String id=kb.next();
					System.out.println("Enter Password: ");
					String pass=kb.next();
							
						for(Admin a: ad.getAdminList()) {
							if(a.getUserName().equals(id)) {
								login=s.login(adm,pass, ad.getAdminList(), ad.getAdminHash());
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
				while(true) {
			System.out.println("\n-------Choose Your Option--------\n1.Show Profile Details\n2.Show List of all diagnostic centers along with the tests done\n3.Add Diagnostic Center\n4.Add Test in center\n5.Remove Diagnostic Center\n6.Remove Test\n7.Exit");
			String option=kb.next();
			kb.nextLine();
			try {
				ValidateImplementation.optionChosenValidate(option);
			}
			catch(WrongOptionChosenException e) {
				//System.out.println(e);
				break;
			}	
			switch(Integer.parseInt(option)) 
				{
							case 1:System.out.println("____________________Profile Details____________________");
							for(Admin a: ad.getAdminList()) {
								if(a.getUserName().equals(id)) {
									System.out.println("Name: "+a.getFirstName()+" "+a.getLastName());
									System.out.println("User Id: "+a.getUserId());
									System.out.println("User Name: "+a.getUserName());
									System.out.println("User Role: "+a.getUserRole());
									System.out.println("Gender: "+a.getGender());
									System.out.println("Email id: "+a.getEmailId());
									System.out.println("Contact No.: "+a.getContactNumber());
								}
							}
								   break;
			
							case 2:	System.out.println("________________Center names with Test names are:___________________");
							for(int i=0;i<dc.getCenterList().size();i++) {
								DiagnosticCenter d=dc.getCenterList().get(i);
								System.out.println("\nCenter Id: "+d.centerId+" Center name: "+d.centerName+"\nThe tests done here are: ");
				
								for(Test t:d.getListOfTests()) {
									
									System.out.println(t.testId+" "+t.testName);
									}
							}
							break;
								
							case 3:System.out.println("Enter the name of Diagnostic center to add in the list:  ");
								centerName=kb.nextLine();
								try {
									ValidateImplementation.DiagnosticCenterValidate(centerName);
									s.addCenter(centerName,td.getTestList(),dc.getCenterList());
									System.out.println("Diagnostic center added successfully..\n___________New center list is:__________");
									for(DiagnosticCenter d : dc.getCenterList()) 
									{
										System.out.println(d.centerId+" "+d.centerName);
									}
									break;
									}
								catch(DiagnosticCenterNameException e) {
									System.out.println(e);
								}
								break;
								
							case 4:System.out.println("Enter the diagnostic center id in which you want to add new test: ");
							  
								try {
									    String diagnostic=kb.nextLine();
										ValidateImplementation.DiagnosticCenterIdValidate(diagnostic);
										System.out.println("Enter the Test name to add: ");
										testName=kb.nextLine();
										ValidateImplementation.TestNameValidate(testName);
										
										if(s.isDiagnosticCenterPresent(diagnostic,dc.getCenterList())) {
											s.addTestInCenter(dc.getCenterList(),diagnostic,testName);
											System.out.println("_________________After adding the test new Test List is______");
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
								
							case 5:System.out.println("Enter the Center Id to remove: ");
						       String centerId=kb.nextLine();
						       if(s.removeCenter(centerId, dc.getCenterList())) {
							       System.out.println("____________After removing the center list is__________");
							       for(DiagnosticCenter d : dc.getCenterList()) {
										System.out.println(d.centerId+" "+d.centerName);
									}
						       }
						       else
						    	   System.out.println("Diagnostic center does not exist...");
								break;
								
							case 6:System.out.println("Enter the diagnostic center id from which you want to remove test: ");
							  
								try {
									    String diagnostic=kb.nextLine();
										ValidateImplementation.DiagnosticCenterIdValidate(diagnostic);
										System.out.println("Enter the Test name to remove: ");
										testName=kb.nextLine();
										ValidateImplementation.TestNameValidate(testName);
										
										if((s.isDiagnosticCenterPresent(diagnostic,dc.getCenterList()))) { 
											s.removeTestFromCenter(dc.getCenterList(),diagnostic,testName);
											 System.out.println("____________After removing the test list is____________");
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
								
							case 7:System.out.println("Exit...");
									System.exit(0);
								
							default: System.out.println("Please enter correct option...");
									break;
				    }
				  }
			     }
				}
			}
				else if(Integer.parseInt(number)==2)
				{
					while(true)
					 {
					System.out.println("Press 1 for REGISTER \n Press 2 for LOGIN");
					int opt=kb.nextInt();
					
			if(opt==1)
			{
				while(true) {  try{
					System.out.println("enter your first name:");
					firstname=kb.next();
					CustomerValidation.fnameValidation(firstname);
					break;
				}
					catch(FirstNameException e1)
					{
						System.out.println(e1.getMessage());
					}
				}
				
				while(true) {	
					try {
					 System.out.println("enter your last name:");
				    lastname=kb.next();
				    CustomerValidation.lnameValidation(lastname);
				    break;
					}
					catch(LastNameException e1)
					{
						System.out.println(e1.getMessage());
					}
				}
				while(true) {
					try {
					
					System.out.println("enter your email id:");
					 emailid=kb.next();
					CustomerValidation.validateeamilId(emailid);
					break;
					}
					
					catch(EmailIdException e1)
					{
						System.out.println(e1.getMessage());
					}
				}
				while(true) {	try {
					
					System.out.println("enter your password:");
					 password=kb.next();
					CustomerValidation.validatepassword(password);
					break;
				}
					catch(PasswordException e1)
					{
						System.out.println(e1.getMessage());
					}
				}
				while(true) { try {
					System.out.println("enter your contactNo:");
					contactNo=kb.next();
					CustomerValidation.contactNumberValidate(contactNo);
					break;
				}
		      
				
				catch(ContactNumberException e1)
				{
					System.out.println(e1.getMessage());
				}
				}	
				 String UserName=firstname.substring(0,3)+lastname.substring(0,3);
				 usr.setUsername(UserName);
				usr.setUserFirstName(firstname);
				usr.setUserLastName(lastname);
				usr.setContactNumber(Long.parseLong(contactNo));
				usr.setEmailId(emailid);
				usr.setUserPassword(password);
				String userId=usr.getUserId();
				System.out.println("You are welcome!!");
				System.out.println("Your user name is "+UserName);
				System.out.println("your userId is  "+userId);
			}
				
			else if(opt==2)
			{
				
				System.out.println("Enter your userName:");
				String uname=kb.next();
				System.out.println("Enter your password:");
				String pass=kb.next();
				
				c.Register(cd.getCustomerList(),uname, pass);
				if(usr.getUsername().contains(uname)&&pass.contentEquals(usr.getUserPassword())) {
						System.out.println("Congratulations, you successfully logged in !!");
						System.out.println("enter 1 for making an appointment\n enter 2 for checking your appointment status:");
						int op=kb.nextInt();
						
						if(op==1)
						{
								System.out.println("Here are the list of diagnostic center:");
								
								for(DiagnosticCenter d : dc.getCenterList()) {
									System.out.println(d.centerId+" "+d.centerName);
									}
							
								System.out.println("enter the diagnostic center name:");
								String centername=kb.next();
								try {
									ValidateImplementation.DiagnosticCenterValidate(centername);
								} catch (DiagnosticCenterNameException e) {
									System.out.println(e);
								}
								
								System.out.println("here are the list of test the "+centername+" center provides:");
								System.out.println(td.getTestList());
								
								System.out.println("enter the test name from the above options");
								System.out.println("Remember you can't choose more than one test at a time!!\n");
							
								String testname=kb.next();
								kb.nextLine();
								try {
									ValidateImplementation.TestNameValidate(testname);
								} catch (TestNameException e) {
									System.out.println(e);
								}
								
								while(true) {
								try {	
								System.out.println("Enter your convenient Date in the format: MM-dd-yyyy ");
								 date1=kb.next();
								boolean flagdate=DateTimeValidation.datevalidation(date1);
								break;
								}
								catch(IncorrectDateFormatException e2)
								{
									System.out.println(e2.getMessage());
								}
								}
								while(true) {
									try {	
								System.out.println("Enter your convenient time (hh:mm):");
								 time = kb.next();
								boolean flagtime=DateTimeValidation.timevalidation(time);
								break;
								}
								catch(IncorrectTimeFormatException e2)
								{
									System.out.println(e2.getMessage());
								}
								}

								api.makeAppointment(usr,centername,testname,dc.getCenterList(),td.getTestList(),date1,time);
								boolean approvedd=false;
							//	Appointment app=new Appointment(usr,testname,centername,date1,approvedd);
								
								
						System.out.println("your form is submitted");
						}
						
						
						if(op==2)
						{
							System.out.println("provide your appointment details:");
							System.out.println("enter your user Id:");
							String userid=kb.next();
						
							
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
}
