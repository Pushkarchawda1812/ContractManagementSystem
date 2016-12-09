package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.dao.AmenityRequestStatusDao;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.AdminApprovalView;

//author Ishan
//This class is used to let the Admin enter the Amenity id he wants to check the status of.

public class AmenityRequestStatus 
{
	public void amenityRequestStatus(String userID)throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner s=new Scanner(System.in);

		int enterChoice=0; 
		AdminApprovalView adminapprovalview=new AdminApprovalView();
		AmenityRequestStatusDao amenityrequeststatusdao=new AmenityRequestStatusDao();
		AdminLoginView alv=new AdminLoginView();
		AllExceptionLogger ael=new AllExceptionLogger();
		AmenityRequestStatus amenityrequeststatus=new AmenityRequestStatus();

		amenityrequeststatusdao.amenityRequestStatusDao(userID);
		try
		{
			do
			{
				System.out.println("\n\n\n\t\t   Please Select Your Choice");
				System.out.println("\n\t\t   1. Enter the amenity id you want to check");
				System.out.println("\n\t\t   2. Go back to previous page");
				System.out.print("\n\t\t   Enter 1 or 2 :  ");
				enterChoice=s.nextInt();
				s.nextLine();
				if(enterChoice==1)
				{
					adminapprovalview.adminApprovalView(userID);
				}
				else if(enterChoice==2)
				{
					alv.adminLoginView(userID);
				}
				else
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!\n");
					amenityrequeststatus.amenityRequestStatus(userID);
				}
			}while(enterChoice!=1&&enterChoice!=2);
		}
		catch(Exception exp)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!\n");
			ael.allExceptionLogger(exp);
			amenityrequeststatus.amenityRequestStatus(userID);
		}
	}

}
