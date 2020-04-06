package com.cg.hcs.validation;

public class CustomerValidation {
	public static boolean firstnameValidation(String firstname)
	{
	String pattern="[A-Z]{1}[a-z]{2,6}";
	if(firstname.matches(pattern))
		return true;
	else
		return false;
	}
	public static boolean contactNumberValidate(String contactNo) {
		String pattern1 = "[0-9]{10}";
		if(contactNo.matches(pattern1))
			return true;
		return false;
	}
	public static boolean validatepassword(String password)
	{
		String pattern2= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				
		if(password.matches(pattern2))
			return true;
		else
			return false;
	}

	public static boolean validateeamilId(String emailid)
	{
		String pattern3=(
				"^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                    "[a-zA-Z0-9_+&*-]+)*@" + 
	                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                    "A-Z]{2,7}$"); 
	                      
				
				if(emailid.matches(pattern3))
					return true;
				else
					return false;
				
	}
				
}
