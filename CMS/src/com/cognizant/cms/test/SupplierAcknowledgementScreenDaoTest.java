package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.SupplierAcknowledgementScreenDao;

public class SupplierAcknowledgementScreenDaoTest {
	SupplierAcknowledgementScreenDao sa= new SupplierAcknowledgementScreenDao();
	@Test
	public void testSupplierAcknowledgementScreenDao() 
	{
		try
		{
			assertEquals(1,sa.supplierAcknowledgementScreenDao("206"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
