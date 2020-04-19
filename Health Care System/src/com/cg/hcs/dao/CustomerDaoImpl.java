package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.*;

public class CustomerDaoImpl extends CustomerDao {
	ArrayList<User> customerList=new ArrayList<User>();
	
	public void addCustomer(User customer) {
		customerList.add(customer);
	}
	
	public List<User> getCustomerList(){
		return customerList;
	}
}
