package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.bo.CheckUserName;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.model.*;
import com.cognizant.cms.process.NewRegisterSupplierProcess;

//author Pushkar
//This class is used to Register in the System as an Supplier.

public class NewSupplierRegisterForm extends RegisterUser
{
	public void newSupplierRegisterForm() throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner sc=new Scanner(System.in);

		int age=0;

		NewSupplierRegisterFormTO nsr=new NewSupplierRegisterFormTO();
		ContractManagementSystemDispatcher cmsd=new ContractManagementSystemDispatcher();
		NewRegisterSupplierProcess nrfbo= new NewRegisterSupplierProcess();
		CheckUserName cun= new CheckUserName();

		try
		{
			String userName;
			do
			{
				System.out.print("\n\n\t\t   *Enter Supplier Name : ");
				userName=sc.nextLine();
				NewSupplierRegisterFormTO.setSupplierName(userName);
				if(cun.checkUserName(userName)==false && userName.length()<=20)
				{
					NewSupplierRegisterFormTO.setSupplierName(userName);
				}
				else
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   Supplier Name must contain only of Alphabets   !!!");
				}		
			}while(cun.checkUserName(userName));


			age=registerUser();

			System.out.println("\n\n\t\t ---> Press 1 to SUBMIT ");
			System.out.println("\n\t\t ---> Press 2 to GO BACK ");

			System.out.print("\n\t\t      Enter Your Choice (1-2) : ");
			int option=sc.nextInt();
			if(option==1)
			{
				if(age>21)
				{
					nrfbo.newRegisterSupplierBo(NewSupplierRegisterFormTO.getSupplierName(),nsr);
					cmsd.dispatchAction();
				}
				else
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   User's Age Should be greater than 21 years   !!!");
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
			System.out.println("\n\t\t\t\t\t\t\t !!!   Please Enter Details Correctly   !!!");
			System.out.println("\n\t\t ---> Press 1 to GO BACK ");
			System.out.println("\n\t\t      Enter Your Choice (1) : ");
			int option=sc.nextInt();
			if(option==1)
			{
				cmsd.dispatchAction();
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   You Have Entered a Wrong Choice   !!! ");
			}
		}

	}


}

