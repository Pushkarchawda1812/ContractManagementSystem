package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Pushkar
//This class shows the first view of the Application.

public class FrontPageView 
{

	public int frontPageView() throws ClassNotFoundException, IOException, SQLException, InterruptedException, ParseException
	{
		int choice=0;
		Scanner sc=new Scanner(System.in);
		AllExceptionLogger ael=new AllExceptionLogger();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();

		do
		{
			System.out.println("\n\n\n\n\t\t    1. Login ");
			System.out.println("\n\t\t    2. New Registeration for Market Admin ");
			System.out.println("\n\t\t    3. New Registeration for Supplier ");
			System.out.println("\n\t\t    4. Exit ");
			System.out.print("\n\n\t\t   Enter Your Choice (1-4) : ");
			try
			{
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:break;
				case 2:break;
				case 3:break;
				case 4:break;
				default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!! ");
				cmsd.dispatchAction();
				}	

			}
			catch(Exception ex2)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!! ");
				ael.allExceptionLogger(ex2);
				cmsd.dispatchAction();


			}}while(choice!=1&&choice!=2&&choice!=3&&choice!=4);

		return choice;



	}

}
