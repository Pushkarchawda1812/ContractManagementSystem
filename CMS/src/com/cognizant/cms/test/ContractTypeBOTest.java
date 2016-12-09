package com.cognizant.cms.test;

import static org.junit.Assert.*;


import org.junit.Test;

import com.cognizant.cms.bo.ContractTypeBO;

public class ContractTypeBOTest {

	ContractTypeBO ct = new ContractTypeBO();
	@Test
	public void testContracttype() 
	{
		int choice=0;
		int choice1=0;
		int choice2=0;
		String Type_of_Contract=null;
		String Type_of_Contract1=null;
		String Type_of_Contract2=null;
		String startdate2="2014";
		String startdate1="2015";
		String startdate="2016";
		try {
			choice=ct.contracttype(startdate);
			choice1=ct.contracttype(startdate1);
			choice2=ct.contracttype(startdate2);
		} 
		catch (Exception e) 
		{
			System.out.println("\n\t\t\t\t !!! Something Went Wrong !!!");
		}
		if(choice1==1)
		{
		Type_of_Contract="Current Period";
		
		}
		if(choice==2)
		{
			Type_of_Contract1="Next Period";
		}
		if(choice2==3)
		{
			Type_of_Contract2="Last Period";
		}
		try
		{
			assertEquals("Last Period",Type_of_Contract2);
			assertEquals("Next Period",Type_of_Contract1);
			assertEquals("Current Period",Type_of_Contract);
		}
		catch(Exception ex)
		{
			fail("Not yet implemented");
		}
		
	}

}
