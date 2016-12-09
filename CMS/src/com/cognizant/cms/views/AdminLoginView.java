package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Pushkar
//This class gives the first view to Admin when he logs in.

public class AdminLoginView 
{
	public void adminLoginView(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner sc= new Scanner(System.in);

		AdminEditView aev= new AdminEditView();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();
		AdminLoginView alv= new AdminLoginView();
		AllExceptionLogger ael= new AllExceptionLogger();
		UnlockContractView ucv= new UnlockContractView();

		System.out.println("\n\n\t\t   1. Create and View Contract ");
		System.out.println("\n\t\t   2. Approve Amenities ");
		System.out.println("\n\t\t   3. Unlock Contract Request");
		System.out.println("\n\t\t   4. Edit Profile ");
		System.out.println("\n\t\t   5. Logout ");
		System.out.print("\n\n\t\t   Enter your Choice (1-4) : ");
		try
		{
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1: cmsd.dispatchActionCreateContract(userID);
			break;

			case 2: cmsd.dispatchAmenityRequestStatus(userID);
			break;

			case 3: ucv.unlockContractView(userID);
			alv.adminLoginView(userID);
			break;

			case 4: aev.adminEditView(userID);
			break;

			case 5: cmsd.dispatchAction();
			break;

			default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Enter option between 1 to 4   !!! ");   
			alv.adminLoginView(userID);

			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Enter Correct Choice   !!!");
			ael.allExceptionLogger(ex);
			alv.adminLoginView(userID);
		}

	}

}
