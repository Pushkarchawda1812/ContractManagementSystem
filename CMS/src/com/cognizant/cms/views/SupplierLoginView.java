package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Pushkar
//This class shows the first view when the user logs in as a supplier.

public class SupplierLoginView 
{
	public void supplierLoginView(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner sc= new Scanner(System.in);

		SupplierEditView sev=new SupplierEditView();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();
		SelectContractView scv=new SelectContractView();
		SupplierLoginView slv= new SupplierLoginView();
		AllExceptionLogger ael= new AllExceptionLogger();
		AcknowledgementScreen as= new AcknowledgementScreen();
		System.out.println("\n\n\t\t   1. View all Contracts and Add Amenities");
		System.out.println("\n\t\t   2. View all Amenities Status ");
		System.out.println("\n\t\t   3. Edit Profile ");
		System.out.println("\n\t\t   4. Logout ");
		System.out.print("\n\t\t       Enter your Choice (1-4) : ");
		try
		{
			int choice=sc.nextInt();

			switch(choice)
			{
			case 1: scv.selectContractView(userID);
			break;

			case 2:	as.printAcknowledgementScreen(userID);
			break;

			case 3: sev.supplierEditView(userID);
			break;

			case 4: cmsd.dispatchAction();
			break;

			default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Option Between 1 to 4   !!! "); 
			slv.supplierLoginView(userID);

			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Enter Correct Choice   !!!");
			ael.allExceptionLogger(ex);
			slv.supplierLoginView(userID);
		}

	}

}
