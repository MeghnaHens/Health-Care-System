package com.cg.hcs.services;

import java.util.List;

import com.cg.hcs.bean.User;

public class CustomerInterfaceImpl implements CustomerInterface {

	@Override
	public boolean Register(List<User> customer, String password,String username)
	{
	for(int i=0;i<customer.size();i++) {
		User usr=customer.get(i);
	     if (usr.getUserPassword().equals(password) && usr.getUsername().equals(username)) 
	        {
	    	 	return true;
	            //System.out.println("Welcome!!!");
	        }
	   /*  else
	     {
	    	 //System.out.println("your account doesn't exists please register first");
	     }*/
	    }
	return false;
	}

	@Override
	public boolean approveAppointment() {
		return true;
	}
}
