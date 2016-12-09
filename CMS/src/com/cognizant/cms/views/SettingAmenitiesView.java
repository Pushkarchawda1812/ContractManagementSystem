package com.cognizant.cms.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dao.AdminUpdateAmenityViewDao;
import com.cognizant.cms.dao.SettingAmentiesDao;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.AcknowledgeContractStatusTO;
import com.cognizant.cms.model.SettingAmenitiesTO;

//author Aditi Sharma
//This class is used to add a new Amenity by a Supplier.

public class SettingAmenitiesView extends TermAndConditionView
{
	public void setAmenity(String userID, String contractID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		int enterChoice;
		int choice=0;
		String amenity_Lock=null;

		SupplierLoginView slv= new SupplierLoginView();
		AllExceptionLogger ael= new AllExceptionLogger();
		UnlockContract uc= new UnlockContract();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();


		String Amenity_Name; //Member variable: Value will be provided by Supplier
		String Amenity_Description; //Member variable: Value will be provided by Supplier

		Scanner sc=new Scanner(System.in); //Scanner class used to take input from Supplier

		SettingAmenitiesTO sat=new SettingAmenitiesTO(); //Creating Object "sat" for class SettingAmenitiesTO
		SettingAmentiesDao sad=new SettingAmentiesDao(); //Creating Object "sad" for class SettingAmentiesDao


		cmsd.dispatchLock(contractID);

		termAndConditionView(userID, contractID);

		System.out.print("\n\t\t   Enter the Amenity Name : "); //Taking input 
		Amenity_Name=sc.nextLine();
		sat.setAmenity_Name(Amenity_Name);

		System.out.print("\n\t\t   Enter the Amenity Description : "); //Taking input
		Amenity_Description=sc.nextLine();
		sat.setAmenity_Description(Amenity_Description);

		uc.unlockContractView(contractID);
		do
		{
			System.out.println("\n\t\t   Please select any one option given below to unlock or lock the amenity ");
			System.out.println("\n\t\t   1. lock Amenity ");
			System.out.println("\n\t\t   2. unlock Amenity ");
			System.out.print("\n\t\t   Enter 1 or 2 : ");
			enterChoice=sc.nextInt();
			sc.nextLine();
			if(enterChoice==1)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please wait Amenity is Locking   !!! ");
				amenity_Lock="Lock";
			}
			else if(enterChoice==2)
			{ 
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please wait Amenity is UnLocking   !!! ");
				amenity_Lock="Unlock";
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please enter correct choice   !!!");
			}
		}while((enterChoice!=1)&&(enterChoice!=2));

		sad.setAmenityDao(contractID, userID, Amenity_Name, Amenity_Description,amenity_Lock, sat); //Calling the DataBase module to store the given input

		System.out.print("\n\n\n\t\t\t\t\t\t\t !!!   Amenities Successfully Added   !!!");

		System.out.println("\n\n\n\t\t   1. Enter to go back to Main Menu ");
		System.out.println("\n\t\t   2. Enter to Logout ");
		System.out.print("\n\t\t   Enter Your Choice : ");
		try
		{
			do
			{
				choice=sc.nextInt();
				sc.nextLine();
				switch(choice)
				{
				case 1: slv.supplierLoginView(userID);
				break;

				case 2: System.out.println("\n\t\t\t\t\t\t\t !!!   Logged out Sucessfully   !!! ");
				cmsd.dispatchAction();

				default:System.out.println("\n\t\t\t\t\t\t\t !!!   Enter Your choice Properly   !!!");
				slv.supplierLoginView(userID);	
				}
			}while((choice!=1)&&(choice!=2));
		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Directing to Main Menu   !!!");
			ael.allExceptionLogger(ex);
			slv.supplierLoginView(userID);
		}
	}

	//This method asks the user to accept or decline the terms and conditions before he can add a new Amenity in the Contract.
	@Override
	public void termAndConditionView(String userID, String contractID) 
	{

		AllExceptionLogger ael= new AllExceptionLogger();
		String  fileName="Amenity.txt";      
		String line = null;
		try
		{
			FileReader fileReader = 
				new FileReader(fileName);   
			BufferedReader bufferedReader = 
				new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			} 
			bufferedReader.close();
			termAndConditionEditView(userID, contractID);
		}
		catch(Exception ex)
		{
			ael.allExceptionLogger(ex);
		}

	}



	@Override
	public void termAndConditionEditView(String userID, String contractID) 
	{
		int x=0;
		AdminUpdateAmenityViewDao auav= new AdminUpdateAmenityViewDao();
		SupplierLoginView slv= new SupplierLoginView();
		AllExceptionLogger ael= new AllExceptionLogger();
		Scanner sc= new Scanner(System.in);
		System.out.println("\n\n\t\t   1.ACCEPT");
		System.out.println("\n\t\t   2.DENY");
		do
		{
			System.out.print("\n\n\t\t   Enter Choice : ");
			x=sc.nextInt();
			sc.nextLine();
			if(x==1)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Access Granted   !!!");
			}
			else if(x==2)
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   No changes can be made   !!!");
				AcknowledgeContractStatusTO.setContractID(contractID);
				try
				{
					auav.editcontractstatus("Pending");
					auav.editcontractLock("Unlock");
					slv.supplierLoginView(userID);
				}
				catch(Exception ex)
				{
					ael.allExceptionLogger(ex);
				}
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   Please Press 1 or 2 only   !!!");
			}
		}while((x!=1)&&(x!=2));

	}


}
