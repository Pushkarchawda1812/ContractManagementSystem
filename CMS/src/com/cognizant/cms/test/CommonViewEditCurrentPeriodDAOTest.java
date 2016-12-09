package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.CommonViewEditCurrentPeriodDAO;

public class CommonViewEditCurrentPeriodDAOTest {
	CommonViewEditCurrentPeriodDAO cv= new CommonViewEditCurrentPeriodDAO();
	@Test
	public void testContractidvoilation() 
	{
		try
		{
			assertEquals(true, cv.contractidvoilation("MA_JAI_DED_2016143"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
