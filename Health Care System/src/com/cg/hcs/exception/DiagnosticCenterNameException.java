package com.cg.hcs.exception;

public class DiagnosticCenterNameException extends Exception{
	public DiagnosticCenterNameException() {
		System.out.println("Diagnostic center name must be in characters only..!");
	}
}
