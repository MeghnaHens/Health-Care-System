package com.cg.hcs.services;

import java.util.List;

import com.cg.hcs.bean.*;

public interface CustomerInterface {
	
	public abstract void Register(List<User> customer,String userName, String password);
}
