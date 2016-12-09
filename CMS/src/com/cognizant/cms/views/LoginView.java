package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.bo.LoginValidateBo;
import com.cognizant.cms.dao.WelcomeNameDao;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Pushkar
//This class is used by the user to Login to the System.


public class LoginView 
{
	public void loginView() throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{

		LoginValidateBo lvbo=new LoginValidateBo();
		AllExceptionLogger ael=new AllExceptionLogger();
		AdminLoginView alv=new AdminLoginView();
		SupplierLoginView slv =new SupplierLoginView();
		WelcomeNameDao wnd= new WelcomeNameDao();
		LoginView lv= new LoginView();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();
		Scanner sc=new Scanner(System.in);
		int enterChoice=0;	
		System.out.print("\n\n\t\t   *Enter User ID(case sensitive) : ");
		String userID=sc.nextLine();
		System.out.print("\n\t\t   *Enter Password : ");
		String password=sc.nextLine();
		System.out.print("\n\n\t\t    Logging In");
		Thread.sleep(500);
		System.out.print(". ");
		Thread.sleep(500);
		System.out.print(". ");
		Thread.sleep(500);
		System.out.print(". ");
		Thread.sleep(500);
		System.out.print(". ");
		Thread.sleep(500);
		System.out.println(". \n\n");

		boolean validate=lvbo.loginValidate(userID,password);

		if(validate)
		{
			System.out.println("___________________________________________________________________________________________________________________________________________________________________");

			System.out.println("\n\t\t\t\t\t\t\t Welcome "+wnd.welcomeNameDao(userID)+" to Contract Management System");
			System.out.println("___________________________________________________________________________________________________________________________________________________________________");


			char firstLetter[]= userID.toCharArray();
			if(firstLetter[0]=='M')
			{
				alv.adminLoginView( userID);	
			}
			if(firstLetter[0]=='S')
			{
				slv.supplierLoginView(userID);
			}

		}
		else
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Username or/and Password is Incorrect   !!! ");
		do
		{
			try
			{
				System.out.println("\n\n\t\t   Enter 1 to Login Again and Press 2 to Exit to Main Screen");
				System.out.print("\n\t\t   Enter your Choice : ");
				enterChoice=sc.nextInt();
				sc.nextLine();
				if(enterChoice==1)
				{
					lv.loginView();
				}
				else if(enterChoice==2)
				{
					//fpv.frontPageView();
					cmsd.dispatchAction();
				}
				else
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!! ");
					cmsd.dispatchAction();
				}
			}
			catch(Exception ex1)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!! ");
				ael.allExceptionLogger(ex1);
				lv.loginView();


			}
		}while((enterChoice!=1)&&(enterChoice!=2));



	}

}
