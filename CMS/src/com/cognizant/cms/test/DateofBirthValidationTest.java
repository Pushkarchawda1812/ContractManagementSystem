package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.bo.DateofBirthValidation;

public class DateofBirthValidationTest 
{
	DateofBirthValidation dbv= new DateofBirthValidation();
	
	@Test
	public void testDateofbirthvaloidation() 
	{
		try
		{
			assertEquals(true, dbv.dateofbirthvalidation("2015-04-01"));
			assertEquals(true, dbv.dateofbirthvalidation("1992-04-01"));
			assertEquals(false, dbv.dateofbirthvalidation("19920-04-01"));
			assertEquals(false, dbv.dateofbirthvalidation("2016-04-01"));
			assertEquals(false, dbv.dateofbirthvalidation("2015-05-01"));
			assertEquals(false, dbv.dateofbirthvalidation("2015-04-20"));
			assertEquals(false, dbv.dateofbirthvalidation("2015-20-20"));
			assertEquals(false, dbv.dateofbirthvalidation("2015-13-33"));
			assertEquals(false, dbv.dateofbirthvalidation("2014-20-20"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
		
	}

}
