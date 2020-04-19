package com.cg.hcs.unitTesting;

	import static org.junit.Assert.*;

	import java.util.Arrays;
	import java.util.Collection;

	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.junit.runners.Parameterized;
	import org.junit.runners.Parameterized.Parameters;

import com.cg.hcs.exception.IncorrectDateFormatException;
import com.cg.hcs.exception.IncorrectTimeFormatException;
	import com.cg.hcs.validation.DateTimeValidation;

	@RunWith(Parameterized.class)
	public class DateFormatValidatorTest {

		private String arg;
		private static DateTimeValidation dateFormatValidator;
		private Boolean expectedValidation;

		public DateFormatValidatorTest(String str, Boolean expectedValidation) {
			this.arg = str;
			this.expectedValidation = expectedValidation;
		}

		@BeforeClass
		public static void initialize() {
			dateFormatValidator = new DateTimeValidation();
		}

		@Parameters
		public static Collection<Object[]> data() {
			Object[][] data = new Object[][] {
					{ "12/06/2020", false },
					{ "06:12:2020" , false },    // wrong format
					
					
					{ "07-15-2020", true },                         
					{ "08-16-2020", true },
					 };
			    
			return Arrays.asList(data);
		}
		
		@Test
		public void test() {
			 boolean res;
			try {
				res = dateFormatValidator.datevalidation(this.arg);
				 String validv = (res) ? "valid" : "invalid";
			        System.out.println("Time Format "+arg+ " is " + validv);
			        assertEquals("Result", this.expectedValidation, res);
			} catch (IncorrectDateFormatException e) {
				System.out.println("unsuccessful!!");
			}
		       
		 
		}
	}
		
