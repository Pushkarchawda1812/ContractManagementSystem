package com.cognizant.cms.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cognizant.cms.bo.StartDateValidationBO;

public class StartDateValidationBOTest
{
	StartDateValidationBO sdv= new StartDateValidationBO();
	@Test
	public void testDatevalidations() 
	{
		try
		{
			assertEquals(true,sdv.datevalidation("2015"));
			assertEquals(false,sdv.datevalidation("2013"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
