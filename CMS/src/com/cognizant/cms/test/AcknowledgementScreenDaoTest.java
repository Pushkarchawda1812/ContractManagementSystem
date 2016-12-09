package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.AcknowledgementScreenDao;

public class AcknowledgementScreenDaoTest {
	AcknowledgementScreenDao as= new AcknowledgementScreenDao();
	@Test
	public void testAcknowledgementScreenDao() 
	{
		try
		{
			assertEquals(1,as.acknowledgementScreenDao("SISH102"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
