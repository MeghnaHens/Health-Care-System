package com.cg.hcs.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cg.hcs.bean.*;
import com.cg.hcs.services.*;
import com.cg.hcs.validation.*;
import com.cg.hcs.exception.*;

public class MainDemo {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		String testName,centerName;
		ServiceImplementation s=new ServiceImplementation();
		
		List<Test> testArray=new ArrayList<Test>();
		Test t1=new Test("Blood Test");
		Test t2=new Test("X-Ray");
		Test t3=new Test("Urine Test");
		Test t4=new Test("Blood Sugar Test");
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
		
		List<User> admin=new ArrayList<User>();
		User u1=new User("Meghna","Admin","meghna@gmail.com",896733064,"m@123",centerArray);
		admin.add(u1);
		
		while(true)
		{
		System.out.println("1.Show List of all diagnostic centers along with the tests done\n2.Add Diagnostic Center\n3.Add Test\n4.Remove Diagnostic Center\n5.Remove Test\n6.Exit");
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
			
			for(Test t:testArray) {
				System.out.println(t.testId+" "+t.testName);
			}
				
			case 2:System.out.println("Enter the Diagnostic center to add in the list:  ");
				centerName=kb.next();
				try {
					ValidateImplementation.DiagnosticCenterValidate(centerName);
					s.addCenter(centerName,testArray,centerArray);
					System.out.println("After adding the center list is: ");
					for(DiagnosticCenter d:centerArray) {
					System.out.println(d.centerId+" "+d.centerName);
					}
					break;
					}
				catch(DiagnosticCenterNameException e) {
					System.out.println(e);
				}
				break;
				
			case 3:System.out.println("Enter the Test name to add in the list: ");
				testName=kb.next();
				try {
					ValidateImplementation.TestNameValidate(testName);
					s.addTest(testName,testArray);
					for(Test t:testArray) {
						
					System.out.println(t.testId+" "+t.testName);
					}
				}
				catch(TestNameException e) {
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
