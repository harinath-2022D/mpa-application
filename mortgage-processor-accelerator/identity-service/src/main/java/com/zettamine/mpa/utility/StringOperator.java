package com.zettamine.mpa.utility;

public class StringOperator 
{
	public static String replaceAndTrim(String input)
	{
	        String doubleSpaces = input.replaceAll("\\s+", " ");
	      
	        String trimmedString = doubleSpaces.trim();
	        
			return trimmedString.toUpperCase();
	}

}
