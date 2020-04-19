package com.cg.hcs.services;

import java.util.List;

import com.cg.hcs.bean.User;

public class CustomerInterfaceImpl implements CustomerInterface {

	public void Register(List<User> customer,String userName, String password)
	{
	for(int i=0;i<customer.size();i++) {
		User usr=customer.get(i);
		if(usr.getUsername().contentEquals(userName)&&usr.getUserPassword().equals(password))
		{
			
		      System.out.println( "Welcome!!" );    
		  
		}else
	     {
	    	 System.out.println("your account doesn't exists please register first");
	     }
	    }

	}

	
}
