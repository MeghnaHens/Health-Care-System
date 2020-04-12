package com.cg.hcs.customerException;

public class FirstNameException extends Exception{
	String msg;
	public FirstNameException(String msg)
	{
		this.msg=msg;
	}
	public String getMessage() {
		return this.msg=msg;
		}
}
