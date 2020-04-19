package com.cg.hcs.unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import com.cg.hcs.bean.User;

public class CustomerTesting {

	@Test
	public void test1() {
	String expected="Karishma";
	User u=new User();
	String actual=u.setUserFirstName(expected);
	assertEquals(expected, actual);	
		
	}
	@Test	
	public void test2() {
		String expected="Upadhyay";
		User u=new User();
		String actual=u.setUserLastName(expected);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void test3() {
		long expected=965454966;
		User u= new User();
		long actual = u.setContactNumber(expected);
		assertEquals(expected, actual);	
	}

}
