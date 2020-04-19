package com.cg.hcs.exception;

public class IncorrectTimeFormatException extends Exception{
	String msg;
	public IncorrectTimeFormatException(String msg) {
		this.msg=msg;
		}
public String getMessage()
{
	return this.msg=msg;
}
}
