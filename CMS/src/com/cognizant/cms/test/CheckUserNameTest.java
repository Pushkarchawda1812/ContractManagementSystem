package com.cognizant.cms.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.cognizant.cms.bo.CheckUserName;



public class CheckUserNameTest {
	
	CheckUserName cun =new CheckUserName();
	@Test
	public void testCheckUserName() {
		
		try{
			assertEquals(false,cun.checkUserName("Pushkar"));
			assertEquals(true,cun.checkUserName("Pushkar1@"));
		}catch(Exception e){
			
		fail("Not yet implemented");
		}
	}

}
