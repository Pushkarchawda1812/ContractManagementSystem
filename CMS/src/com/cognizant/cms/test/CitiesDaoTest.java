package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.CitiesDao;

public class CitiesDaoTest {
	CitiesDao cd= new CitiesDao();
	@Test
	public void testCitiesDao() 
	{
		try
		{
			assertEquals(true, cd.citiesDao("IN"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testCitiesCheckDao() 
	{
		try
		{
			assertEquals(true, cd.citiesCheckDao("INCI"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
	}

}
