package com.cg.hcs.customerException;

public class ContactNumberException extends Exception {
		String msg;
	public ContactNumberException(String msg) {
		this.msg=msg;
		}
public String getMessage()
{
	return this.msg=msg;
}
}
