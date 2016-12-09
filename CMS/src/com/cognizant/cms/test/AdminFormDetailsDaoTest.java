package com.cognizant.cms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.cms.dao.AdminFormDetailsDao;
import com.cognizant.cms.model.NewAdminRegisterFormTO;
import com.cognizant.cms.model.RegisterUserTO;

public class AdminFormDetailsDaoTest {
	AdminFormDetailsDao af= new AdminFormDetailsDao();
	NewAdminRegisterFormTO na=new NewAdminRegisterFormTO();
	RegisterUserTO ru= new RegisterUserTO();
	@Test
	public void testAdminFormDetailsDao() 
	{
		NewAdminRegisterFormTO.setUserName("REYANSH");
		RegisterUserTO.setPassword("default");
		RegisterUserTO.setDateOfBirth("1980-12-18");
		RegisterUserTO.setEmailAddress("reyansh@gmail.com");
		RegisterUserTO.setContact(3214567890L);
		RegisterUserTO.setAddress("sdsxdsdsdssdsdertyui");
		RegisterUserTO.setCountryCode("IN");
		RegisterUserTO.setCityCode("INMI");
		
		
		
		try
		{
			assertEquals(false, af.adminFormDetailsDao("MAREY", na));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
