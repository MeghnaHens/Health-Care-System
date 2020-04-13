package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.hcs.bean.*;

public class CustomerDaoImpl extends CustomerDao {
	
	ArrayList<User> customerList=new ArrayList<User>();
	HashMap<User, String> userHash = new HashMap<>();
	public void addCustomer(User customer) {
		customerList.add(customer);
		this.userHash.put(customer,customer.getUserPassword());
	}
	
	public List<User> getCustomerList(){
		return customerList;
	}
	
	public HashMap<User, String> getuserHash() {
		return this.userHash;
	}
}
