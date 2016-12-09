package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.bo.CheckUserName;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.*;
import com.cognizant.cms.process.NewRegisterFormProcess;

//author Pushkar
//This class is used to Register in the System as an Admin.

public class NewAdminRegisterForm extends RegisterUser
{

	public void newAdminRegisterForm() throws ClassNotFoundException, SQLException /*newRegisterForm()*/, IOException, InterruptedException, ParseException
	{
		int age=0;

		Scanner sc=new Scanner(System.in);
		NewAdminRegisterFormTO nr= new NewAdminRegisterFormTO();
		NewRegisterFormProcess nrfbo= new NewRegisterFormProcess();
		ContractManagementSystemDispatcher cmsd=new ContractManagementSystemDispatcher();
		AllExceptionLogger ael= new AllExceptionLogger();
		CheckUserName cun= new CheckUserName();


		try
		{
			String userName;
			do
			{
				System.out.print("\n\t\t   *Enter Admin Name : ");
				userName=sc.nextLine();
				NewAdminRegisterFormTO.setUserName(userName);
				if(cun.checkUserName(userName)==false&& userName.length()<=20)
				{
					NewAdminRegisterFormTO.setUserName(userName);
				}
				else
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   Admin Name must contain only of Alphabets   !!!");
				}		
			}while(cun.checkUserName(userName));


			age=registerUser();

			System.out.println("\n\n\n\t\t ---> Press 1 to SUBMIT ");
			System.out.println("\n\t\t --->  Press 2 to GO BACK ");
			System.out.print("\n\t\t      Enter Your Choice (1-2) : ");
			int option=sc.nextInt();

			if(option==1)
			{
				if(age>24)
				{
					nrfbo.newRegisterFormBo(NewAdminRegisterFormTO.getUserName(),nr);
					cmsd.dispatchAction();
				}
				else
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   User's Age Should be greater than 24 years   !!! ");
					cmsd.dispatchAction();
				}

			}
			else
			{
				cmsd.dispatchAction();
			}
		}
		catch(Exception ex)
		{
			ael.allExceptionLogger(ex);
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Details Correctly   !!!");
			System.out.println("\n\n\t\t    Press 1 to GO BACK ");
			System.out.println("\n\t\t   Enter Your Choice (1) : ");
			int option=sc.nextInt();
			if(option==1)
			{
				cmsd.dispatchAction();
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Wrong Choice   !!!");
				ael.allExceptionLogger(ex);
				cmsd.dispatchAction();
			}
		}

	}

}
