package com.cg.hcs.validation;

import com.cg.hcs.exception.*;

public class ValidateImplementation{
	public static void TestNameValidate(String testName) throws TestNameException{
		String pattern="[A-Za-z]{1,20}";
		if(!testName.matches(pattern))
			throw new TestNameException();
	}
	public static void DiagnosticCenterValidate(String centerName) throws DiagnosticCenterNameException{
		String pattern="[A-Za-z]{1,20}";
		if(!centerName.matches(pattern))
			throw new DiagnosticCenterNameException();
	}
	
	public static void DiagnosticCenterIdValidate(String centerId) throws DiagnosticCenterIdException{
		String pattern="[D]{1}[1-9]{1,5}";
		//String pattern="[A-Z1-9]{1,5}";
		if(!centerId.matches(pattern))
			throw new DiagnosticCenterIdException();
	}
}
 