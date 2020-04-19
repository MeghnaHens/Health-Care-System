package com.cg.hcs.validation;

import com.cg.hcs.exception.IncorrectDateFormatException;
import com.cg.hcs.exception.IncorrectTimeFormatException;

public class DateTimeValidation {
	public static boolean datevalidation(String date) throws IncorrectDateFormatException
	{
			String pattern= "^(1[0-2]|0[1-9])-(3[01]"
                    + "|[12][0-9]|0[1-9])-[0-9]{4}$"; 
			
			
			if(!date.matches(pattern))
			{
				
				throw new IncorrectDateFormatException("please provide date as per the format dd-mm-yyyy");
			}
			else
				return true;
	}
	
		public static boolean timevalidation(String time) throws IncorrectTimeFormatException
		{
				String pattern= "([01]?[0-9]|2[0-3]):[0-5][0-9]";
				if(!time.matches(pattern))
				{
					throw new IncorrectTimeFormatException("please provide time as per the format hh:mm");
				}
						else
							return true;
		}

		
}
