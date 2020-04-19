package com.cg.hcs.services;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;

public class AppointmentInterfaceImplementation implements AppointmentInterface{

	public void makeAppointment(User user,String centerName,String testName,List<DiagnosticCenter>centerArray,List<Test>testArray,String date,String time)
	{
		for(int i=0;i<centerArray.size();i++) {
			DiagnosticCenter center=centerArray.get(i);
			if((center.centerName).equals(centerName)) {
				System.out.println("Diagnostic Center  is: "+center.centerId+"->"+center.centerName);
			}
		}
		for(int i=0;i<testArray.size();i++) {
			Test test=testArray.get(i);
			if((test.testName).equals(testName)) {
				System.out.println("Test to be done is: "+test.testId+"->"+test.testName);
				
			}
		}
			try {
			 	
				SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");
				sdf.parse(date);
				SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm");
				sdf1.parse(time);
	       System.out.println("you booked on"+date+" at "+time);
		}
	catch(Exception e)
	{
		System.out.println("please provide correct date and time!!");
	}
	
}
	public void showAppointment(List<User> customer,List<Appointment> appointlist,String userid) {
		for(int i=0;i<customer.size();i++) {
			User usr=customer.get(i);
			if(usr.getUserId().contentEquals(userid))
			{
			   
			    System.out.println("your appointment is pending");
			  
			}else
		     {
		    	 System.out.println("you entered a wrong user Id");
		     }	
		
	}
	}
	public boolean approveAppointment() {
	return false;
	}
}