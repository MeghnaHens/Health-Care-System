package com.cg.hcs.customerException;

public class PasswordException extends Exception {
	String msg;

	public PasswordException(String msg)
	{
		this.msg=msg;
	}	
	public String getMessage()
	{
		return this.msg=msg;
	}
}
