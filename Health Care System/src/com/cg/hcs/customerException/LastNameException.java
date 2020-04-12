package com.cg.hcs.customerException;

public class LastNameException extends Exception{
	String msg;
	public LastNameException(String msg)
	{
		this.msg=msg;
	}	
	public String getMessage() {
		return this.msg=msg;
	}
}
