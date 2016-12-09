package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.bo.EmailValidation;
import com.cognizant.cms.bo.LoginValidateBo;
import com.cognizant.cms.dao.EditAdminDetailDao;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.RegisterUserTO;

//author Pushkar
//This class is used by Admin to enter various details while editing the profile.


public class AdminEditView 
{
	EditAdminDetailDao eadd= new EditAdminDetailDao();
	AdminLoginView alv =new AdminLoginView();
	AllExceptionLogger ael= new AllExceptionLogger();
	SupplierEditView sev= new SupplierEditView();
	EmailValidation ev= new EmailValidation();

	Scanner sc=new Scanner(System.in);
	public void adminEditView(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		AdminEditView aev= new AdminEditView();
		AdminLoginView alv= new AdminLoginView();


		System.out.println("\n\n\t\t   1. Change Password ");
		System.out.println("\n\t\t   2. Change Email Address ");
		System.out.println("\n\t\t   3. Change Address ");
		System.out.println("\n\t\t   4. Change Contact Number ");
		System.out.println("\n\t\t   5. Go to Previous Menu ");
		System.out.print("\n\t\t   Enter your Choice (1-5) : ");

		try
		{
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: aev.passwordEdit(userID);
			alv.adminLoginView(userID);
			break;

			case 2: aev.emailIDEdit(userID);
			alv.adminLoginView(userID);
			break;

			case 3: aev.addressEdit(userID);
			alv.adminLoginView(userID);
			break;

			case 4: aev.contactEdit(userID);
			alv.adminLoginView(userID);
			break;

			case 5: alv.adminLoginView(userID);
			break;

			default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Option Between 1 to 5 ");
			aev.adminEditView(userID);

			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Enter Correct Choice   !!! ");
			ael.allExceptionLogger(ex);
		}


		aev.adminEditView(userID);

	}

	//This class is used by Admin to enter new password while editing the profile.

	/*	public void passwordEdit(String userID) throws ClassNotFoundException, SQLException
	{
		System.out.print("\n\t\t   Enter New Password : ");
		String password=sc.nextLine();
		while(password.length()<6)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Length of Password Should be Greater than 6   !!!");
			System.out.print("\n\t\t   Enter New Password : ");
			password=sc.nextLine();		
		}
		eadd.editAdminPasswordDao(password,userID);	

	}*/

	public void passwordEdit(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		String password=null;
		String retypePassword=null;
		AdminEditView aev= new AdminEditView();
		LoginValidateBo lv= new LoginValidateBo();
		System.out.print("\n\t\t\t\t  Enter Old Password : ");
		String oldPassword=sc.nextLine();
		while(oldPassword.length()<6)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Length of Password Should be Greater than 6   !!! ");
			System.out.print("\n\n\t\t\t\t  Enter Old Password : ");
			oldPassword=sc.nextLine();
		}
		if(lv.passwordValidate(userID,oldPassword)==true)
		{
			System.out.print("\n\n\t\t\t\t  Enter New Password : ");
			password=sc.nextLine();
			while(password.length()<6)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Length of Password Should be Greater than 6   !!! ");
				System.out.print("\n\n\t\t\t\t  Enter New Password : ");
				password=sc.nextLine();	
			}
			System.out.print("\n\n\t\t\t\t  Retype New Password : ");
			retypePassword=sc.nextLine();
			while(retypePassword.equals(password)==false)
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   Password Don't Match   !!!");
				System.out.print("\n\n\t\t\t\t  Retype New Password : ");
				retypePassword=sc.nextLine();	
			}
		}
		else
		{
			System.out.println("\n\t\t\t\t\t\t\t !!! Invalid Password !!!");
			aev.passwordEdit(userID);
		}
		eadd.editAdminPasswordDao(password,userID);
		aev.adminEditView(userID);
	}

	//This class is used by Admin to enter new Email Address while editing the profile.

	public void emailIDEdit(String userID) throws ClassNotFoundException, SQLException
	{
		System.out.print("\n\t\t   Enter New Email Address : ");
		String emailAddress=sc.nextLine();
		while(ev.emailvalidation(emailAddress)==false)
		{
			System.out.print("\n\n\t\t\t\t\t\t\t !!!   Please Enter Valid Email Address   !!! ");
			System.out.print("\n\n\t\t   *Enter Email Address : ");
			emailAddress=sc.nextLine();
		}
		eadd.editAdminEmailDao(emailAddress, userID);
	}

	//This class is used by Admin to enter new contact number while editing the profile.

	public void contactEdit(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		int count=0;
		long copy=0;

		try
		{
			System.out.print("\n\t\t   Enter New Contact Number : ");
			long contact=sc.nextLong();
			long contactCopy=contact;
			sc.nextLine();

			do
			{
				count=0;
				while(contactCopy!=0)
				{
					contactCopy=contactCopy/10;
					count++;
				}

				if(count<10||count>10)
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   Contact must be of 10 character   !!! ");
					System.out.print("\n\t\t   *Enter Valid Contact Number : ");
					contact=sc.nextLong();
					sc.nextLine();
					RegisterUserTO.setContact(contact);
				}
				else
				{
					RegisterUserTO.setContact(contact);
				}}while(count!=10 && contact<=0);
		}
		catch(Exception ex3)
		{
			ael.allExceptionLogger(ex3);
			System.out.println("\n\t\t\t\t\t\t\t !!!   Contact must be of 10 character   !!! ");
			sev.supplierEditView(userID);

		}
		eadd.editAdminContactDao(copy, userID);
	}

	//This class is used by Admin to enter new Address while editing the profile.

	public void addressEdit(String userID) throws ClassNotFoundException, SQLException
	{

		System.out.print("\n\t\t   Enter New Address :");
		String address=sc.nextLine();
		eadd.editAdminAddressDao(address, userID);
	}

}
