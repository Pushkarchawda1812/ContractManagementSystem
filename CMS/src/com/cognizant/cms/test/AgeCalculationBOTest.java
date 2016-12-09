package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.bo.AgeCalculationBO;

public class AgeCalculationBOTest {
	AgeCalculationBO ac= new AgeCalculationBO();
	@Test
	public void testYearCalculation() 
	{
		
		try
		{
			assertEquals(22, ac.yearCalculation("1992-12-18"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
