package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.AdminApprovalViewDao;

public class AdminApprovalViewDaoTest {
	AdminApprovalViewDao aa= new AdminApprovalViewDao();
	@Test
	public void testAdminApprovalViewDao() 
	{
		try
		{
			assertEquals(true, aa.adminApprovalViewDao("206"));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
