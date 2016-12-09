package com.cognizant.cms.views;

import java.util.*;
import java.sql.SQLException;
import com.cognizant.cms.dao.LockContractViewDao;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Ishan
//This class asks the user to lock a Contract before he can add Amenities to it.


public class LockContractView 
{
	public void getLockContract(String contractID)throws ClassNotFoundException, SQLException
	{
		AllExceptionLogger ael=new AllExceptionLogger();
		LockContractView lcv=new LockContractView();
		
		Scanner s=new Scanner(System.in);
		int choice;
		LockContractViewDao lockcontractviewdao=new LockContractViewDao();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Before adding amenities to contract please lock the contract   !!! ");

		try
		{
		do
		{
			System.out.println("\n\n\t\t   To lock the contract please enter 1");
			System.out.print("\n\t\t   Enter the number : ");
			choice=s.nextInt();
			s.nextLine();

			if(choice==1)
			{
				lockcontractviewdao.lockContractViewDao(contractID);
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!!");
			}
		}while(choice!=1);
		}
		catch(Exception ex5)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!!");
			ael.allExceptionLogger(ex5);
			lcv.getLockContract(contractID);
			
		}
		
		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Contract is succesfully Locked   !!! ");
	}
}
