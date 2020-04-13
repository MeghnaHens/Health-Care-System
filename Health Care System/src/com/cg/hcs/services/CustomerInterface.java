package com.cg.hcs.services;

import java.util.List;

import com.cg.hcs.bean.*;

public interface CustomerInterface {
	public abstract boolean approveAppointment();
	public abstract boolean Register(List<User> customer, String password,String username);
}
