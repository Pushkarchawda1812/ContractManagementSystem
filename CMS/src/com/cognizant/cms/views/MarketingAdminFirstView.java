package com.cognizant.cms.views;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;

//author Shikha
//This class gives the first view when a selects Create and view Contracts from Admin first view.


public class MarketingAdminFirstView 
{
	public int MAfrontPageView(String userID) throws ClassNotFoundException, IOException, SQLException, ParseException, InterruptedException
	{
		int choice=0;

		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		Scanner sc=new Scanner(System.in);
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		System.out.println("\n\t\t\t\t\t\t\t\t ||| Contract Creation and Details |||");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		System.out.println("\n\n\t\t   1. Create Contract ");
		System.out.println("\n\t\t   2. View All Contracts ");
		System.out.println("\n\t\t   3. Go Back to Previous Screen");

		System.out.print("\n\n\t\t   Enter Your Choice (1-3) : ");

		try
		{
			choice=sc.nextInt();
			sc.nextLine();
		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter an Integer   !!!");
			cmd.dispatchActionCreateContract(userID);
		}


		return choice;

	}

}
