package com.cg.hcs.customerException;

public class EmailIdException extends Exception{
	String msg;
	public EmailIdException(String msg)
 {
		this.msg=msg;
 }
	public String getMessage() {
		return this.msg=msg;
	}
}
