package com.cg.hcs.services;
import java.util.Iterator;
import java.util.List;

import com.cg.hcs.bean.*;
public class ServiceImplementation implements ServiceInterface {
	@Override
	public void addCenter(String centerName,List<Test>testArray,List<DiagnosticCenter>centerArray) {
		DiagnosticCenter d= new DiagnosticCenter(centerName,testArray);
		centerArray.add(d);
	}
	
	@Override
	public void removeCenter(String centerId,List<DiagnosticCenter>centerArray) {
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
			if((center.centerId).equals(centerId)) {
				System.out.println("Diagnostic Center to be removed is: "+center.centerId+"->"+center.centerName);
				centerArray.remove(i);
			}
		}
	}
	 
	@Override
	public void removeTest(String testId,List<Test> testArray) {
		for(int i=0;i<testArray.size();i++) {
			Test test=testArray.get(i);
			if((test.testId).equals(testId)) {
				System.out.println("Test to be removed is: "+test.testId+"->"+test.testName);
				testArray.remove(i);
			}
		}
	}
	
	@Override
	public boolean approveAppointment() {
		return true;
	}
	
	@Override
	public void Register(List<User> customer, String password)
	{
	for(int i=0;i<customer.size();i++) {
		User usr=customer.get(i);
	     if (usr.getUserPassword().equals(password)) 
	        {
	            System.out.println("Welcome!!!");
	        }
	     else
	     {
	    	 System.out.println("your account doesn't exists please register first");
	     }
	    }
	    
	    
	}

	@Override
	public void addTestInCenter(List<DiagnosticCenter> centerArray, List<Test> testArray,String diagnostic,String testName) {
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
			if((center.centerId).equals(diagnostic)) {
				Test t=new Test(testName);
				testArray.add(t);
				center.setListOfTests(testArray);
			}
		}
		
	}
}
