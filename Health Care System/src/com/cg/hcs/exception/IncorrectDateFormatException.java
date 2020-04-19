package com.cg.hcs.exception;

public class IncorrectDateFormatException extends Exception{
	String msg;
	public IncorrectDateFormatException(String msg) {
		this.msg=msg;
		}
public String getMessage()
{
	return this.msg=msg;
}
}
