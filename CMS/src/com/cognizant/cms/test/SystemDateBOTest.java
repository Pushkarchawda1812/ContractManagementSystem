package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.bo.SystemDateBO;

public class SystemDateBOTest {
	SystemDateBO sd= new SystemDateBO();
	@Test
	public void testSystemDate() 
	{
		String str=sd.systemDate();
		
		try
		{
			assertEquals("20150403",str);
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
		
	}

	@Test
	public void testSystemCurrentDate() 
	{
		String str=sd.systemDate();
		
		try
		{
			assertEquals("20150403",str);
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
	}

}
