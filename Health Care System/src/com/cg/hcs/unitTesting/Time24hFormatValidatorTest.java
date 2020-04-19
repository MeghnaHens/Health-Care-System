package com.cg.hcs.unitTesting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cg.hcs.exception.IncorrectTimeFormatException;
import com.cg.hcs.validation.DateTimeValidation;

@RunWith(Parameterized.class)
public class Time24hFormatValidatorTest {

	private String arg;
	private static DateTimeValidation time24hFormatValidator;
	private Boolean expectedValidation;

	public Time24hFormatValidatorTest(String str, Boolean expectedValidation) {
		this.arg = str;
		this.expectedValidation = expectedValidation;
	}

	@BeforeClass
	public static void initialize() {
		time24hFormatValidator = new DateTimeValidation();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "10:00 am", false }, // there should be no am|pm
				{ "2.20" , false },    // wrong format
				{ "1 10", false },     // wrong format
				{ "24:20", false },    // out of range
								
				
				{ "09:35", true },                         
				{ "7:30", true },
				{ "23:30", true } };
		    
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		 boolean res;
		try {
			res = time24hFormatValidator.timevalidation(this.arg);
			 String validv = (res) ? "valid" : "invalid";
		        System.out.println("Time Format "+arg+ " is " + validv);
		        assertEquals("Result", this.expectedValidation, res);
		} catch (IncorrectTimeFormatException e) {
			System.out.println("unsuccessful");
		}

	}
}

