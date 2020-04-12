package com.cg.hcs.validation;

import com.cg.hcs.customerException.*;

public class CustomerValidation {
	public static void fnameValidation(String firstname) throws FirstNameException
	{
			String pattern="[A-Z]{1}[a-z]{2,10}";
			if(!firstname.matches(pattern))
				throw new FirstNameException("first letter should be capital!");
	}
	
		public static void lnameValidation(String lastname) throws LastNameException
		{
				String pattern="[A-Z]{1}[a-z]{2,20}";
				if(!lastname.matches(pattern))
					throw new LastNameException("first letter should be capital!");
		}
		
	
	public static void contactNumberValidate(String contactNo) throws ContactNumberException{
		String pattern1 = "[0-9]{10}";
		if(!contactNo.matches(pattern1))
			throw new ContactNumberException("Number should be of 10 digits!");
	}
	
	public static void validatepassword(String password) throws PasswordException
	{
		String pattern2= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				
		if(!password.matches(pattern2))
		throw new PasswordException("password should be equal or greater than 6 must conatain uppercase,lowercase,special characters and digits!!");
	}

	public static void validateeamilId(String emailid) throws EmailIdException
	{
		String pattern3=(
				"^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                    "[a-zA-Z0-9_+&*-]+)*@" + 
	                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                    "A-Z]{2,7}$"); 
	                      
				
				if(!emailid.matches(pattern3))
					throw new EmailIdException("please provide a valid email id");
				
	}
				
	}

