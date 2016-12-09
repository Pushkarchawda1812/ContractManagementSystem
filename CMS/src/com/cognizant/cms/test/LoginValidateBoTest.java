package com.cognizant.cms.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.cognizant.cms.bo.LoginValidateBo;

public class LoginValidateBoTest 
{
	
	LoginValidateBo lv= new LoginValidateBo();
	@Test
	public void testLoginValidate() 
	{
		
		try 
		{
			assertEquals(true, lv.loginValidate("MAJAI130","default"));
			assertEquals(true, lv.loginValidate("SISH102","default"));
			assertEquals(false, lv.loginValidate("MAJAI130","default1"));
			assertEquals(false, lv.loginValidate("SISH102","default1"));
			assertEquals(false, lv.loginValidate("SISH102",null));
			
		} 
		catch (Exception e) 
		{
			fail("Not yet implemented");		
		} 
	
		
	}
	
	@Test
	public void testPasswordValidate() 
	{
		try
		{
			assertEquals(true, lv.passwordValidate("MAJAI130","default"));
			assertEquals(true, lv.passwordValidate("SISH102","default"));
			assertEquals(false, lv.passwordValidate("MAJAI130","default1"));
			assertEquals(false, lv.passwordValidate("SISH102","default1"));
			assertEquals(false, lv.passwordValidate("SISH102",null));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
