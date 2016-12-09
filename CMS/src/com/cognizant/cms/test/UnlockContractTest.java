package com.cognizant.cms.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cognizant.cms.process.UnlockContractViewProcess;

public class UnlockContractTest {
	
	UnlockContractViewProcess uc= new UnlockContractViewProcess();
	@Test
	public void testUnlockContractView() 
	{
		try
		{
			assertEquals(true,uc.unlockContractValidate(1));
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
