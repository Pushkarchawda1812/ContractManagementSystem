package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.bo.EmailValidation;

public class EmailValidationTest 
{
	EmailValidation ev= new EmailValidation();

	@Test
	public void testEmailvalidation() 
	{
		try
		{
			assertEquals(true, ev.emailvalidation("pushkarchawda@gmail.com"));
			assertEquals(false, ev.emailvalidation("pushkarchawdagmail.com"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
		
	}

}
