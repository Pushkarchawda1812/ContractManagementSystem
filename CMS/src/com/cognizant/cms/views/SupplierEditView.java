package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.bo.EmailValidation;
import com.cognizant.cms.bo.LoginValidateBo;
import com.cognizant.cms.dao.EditSupplierDetailDao;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.RegisterUserTO;

//author Pushkar
//This class is used by the Supplier while editing his profile.
public class SupplierEditView 
{

	Scanner sc=new Scanner(System.in);

	public void supplierEditView(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		SupplierLoginView slv=new SupplierLoginView();
		SupplierEditView sev= new SupplierEditView();
		AllExceptionLogger ael= new AllExceptionLogger();


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
			case 1: sev.passwordEdit(userID);
			slv.supplierLoginView( userID);
			break;

			case 2: sev.emailIDEdit(userID);
			slv.supplierLoginView(userID);
			break;

			case 3: sev.addressEdit(userID);
			slv.supplierLoginView(userID);
			break;

			case 4: sev.contactEdit(userID);
			slv.supplierLoginView(userID);
			break;

			case 5: slv.supplierLoginView(userID);
			break;

			default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Option Between 1 to 5   !!! ");
			sev.supplierEditView(userID);

			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!! ");
			ael.allExceptionLogger(ex);
		}
		sev.supplierEditView(userID);

	}

	public void passwordEdit(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		String password=null;
		String retypePassword=null;
		SupplierEditView sev= new SupplierEditView();
		EditSupplierDetailDao esdd= new EditSupplierDetailDao();
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
			sev.passwordEdit(userID);
		}
		esdd.editSupplierPasswordDao(password,userID);
		sev.supplierEditView(userID);
	}

	public void emailIDEdit(String userID) throws ClassNotFoundException, SQLException
	{
		EmailValidation ev= new EmailValidation();
		EditSupplierDetailDao esdd= new EditSupplierDetailDao();

		System.out.print("\n\t\t   Enter New Email Address : ");
		String emailAddress=sc.nextLine();
		while(ev.emailvalidation(emailAddress)==false)
		{
			System.out.print("\n\n\t\t\t\t\t\t\t !!!   Please Enter Valid Email Address   !!! ");
			System.out.print("\n\n\t\t   *Enter Email Address : ");
			emailAddress=sc.nextLine();
		}
		esdd.editSupplierEmailDao(emailAddress,userID);
	}

	public void contactEdit(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		int count=0;
		long copy=0;
		EditSupplierDetailDao esdd= new EditSupplierDetailDao();
		SupplierEditView sev= new SupplierEditView();
		AllExceptionLogger ael= new AllExceptionLogger();

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
		esdd.editSupplierContactDao(copy,userID);
	}

	public void addressEdit(String userID) throws ClassNotFoundException, SQLException
	{
		EditSupplierDetailDao esdd= new EditSupplierDetailDao();
		System.out.print("\n\t\t   Enter New address : ");
		String address=sc.nextLine();
		esdd.editSupplierAddressDao(address,userID);
	}
}

