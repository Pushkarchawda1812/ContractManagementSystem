package com.cognizant.cms.views;

import java.text.ParseException;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import com.cognizant.cms.bo.SystemDateBO;
import com.cognizant.cms.dao.AdminUpdateAmenityViewDao;
import com.cognizant.cms.dao.AmenityDescriptionDao;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.process.LockUnlockProcess;

//author Ishan
//This class is used to display the interface to Admin to update Amenity view.


public class AdminUpdateAmenityView 

{
	public static String date;
	public void setAdminUpdateAmenityView(String userID, String getAmenityId)throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner s=new Scanner(System.in);
		SystemDateBO sdb= new SystemDateBO();
		AdminLoginView alv= new AdminLoginView();
		AdminUpdateAmenityViewDao adminupdateamenityviewdao=new AdminUpdateAmenityViewDao();
		AmenityRequestStatus amenityrequeststatus =new AmenityRequestStatus ();
		AdminUpdateAmenityView adminupdateamenityview=new AdminUpdateAmenityView();
		AmenityDescriptionDao amenitydescription=new AmenityDescriptionDao();
		AllExceptionLogger ael= new AllExceptionLogger();
		LockUnlockProcess lub=new LockUnlockProcess();
		AdminUpdateAmenityView auav= new AdminUpdateAmenityView();



		int exitChoice=0;
		int enterChoice=0;
		int amenityChoice=0;
		int contractChoice=0;
		String amenityStatus=null;
		String contractStatus=null;
		String remarks;
		try
		{


			do {
				System.out.println("\n\n\t\t   Please select any one of the following choices");
				System.out.println("\n\t\t   1. Read Amenity Description");
				System.out.println("\n\t\t   2. Edit the entered amenity and status");
				System.out.println("\n\t\t   3. Go back to previous page");

				System.out.print("\n\t\t   Enter your choice :  ");
				enterChoice=s.nextInt();
				s.nextLine();

				if(enterChoice==1)
				{
					amenitydescription.amenityDescriptionDao(getAmenityId);
					lub.amenityDescriptionBO(userID, getAmenityId);

				}
				else if(enterChoice==2)
				{
					do
					{
						System.out.print("\n\t\t   Enter Amenity Status : ");
						System.out.println("\n\n\t\t   1. Pending ");
						System.out.println("\n\t\t   2. Approved ");
						System.out.println("\n\t\t   3. Rejected ");
						System.out.println("\n\t\t   4. Go back to previous page");
						System.out.print("\n\n\t\t   Enter Your Choice : ");
						amenityChoice=s.nextInt();
						s.nextLine();

						switch(amenityChoice)
						{
						case 1: amenityStatus="Pending";
						break;

						case 2: amenityStatus="Approved";
						break;

						case 3: amenityStatus="Rejected";
						break;

						case 4: auav.setAdminUpdateAmenityView(userID, getAmenityId);
						break;

						default: System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Between (1-4) Only   !!! ");
						}
					}while((amenityChoice!=1)&&(amenityChoice!=2)&&(amenityChoice!=3)); 

					do
					{
						System.out.print("\n\t\t   Enter Contract Status : ");
						System.out.println("\n\n\t\t   1. Pending ");
						System.out.println("\n\t\t   2. Approved ");
						System.out.println("\n\t\t   3. Expired ");
						System.out.println("\n\t\t   4. Go back to previous page");
						System.out.print("\n\n\t\t   Enter Your Choice : ");
						contractChoice=s.nextInt();
						s.nextLine();			
						switch(contractChoice)
						{
						case 1: contractStatus="Pending";
						break;

						case 2: contractStatus="Approved";
						break;

						case 3: contractStatus="Expired";
						break;

						case 4: auav.setAdminUpdateAmenityView(userID, getAmenityId);
						break;

						default: System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Between (1-4) Only   !!! ");
						}
					}while((contractChoice!=1)&&(contractChoice!=2)&&(contractChoice!=3));



					System.out.print("\n\t\t   Enter Remarks : ");
					remarks=s.nextLine();
					date=sdb.systemDate();
					adminupdateamenityviewdao.adminupdateAmenityViewDao(amenityStatus,remarks,date,getAmenityId);
					adminupdateamenityviewdao.editcontractstatus(contractStatus);
					System.out.println("\n\n\t\t\t\t\t\t\t -------   Selected Amenity is Succesfully Updated   -------");
					System.out.println("\n\n\t\t\t\t\t\t\t         -------   Contract Status Updated   -------");

					do
					{
						System.out.print("\n\n\t\t   Please Enter 1 if you want to check another amenity or please enter 2 to go to main screen : ");
						exitChoice=s.nextInt();


						if(exitChoice==1)
						{
							amenityrequeststatus.amenityRequestStatus(userID); 
						}
						else if(exitChoice==2)
						{
							alv.adminLoginView(userID);
						}
						else
						{
							System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please enter correct choice   !!!");
						}
					}while(exitChoice!=1&&enterChoice!=2);
				}

				else if(enterChoice==3)
				{
					amenityrequeststatus.amenityRequestStatus(userID); 
				}
				else
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!");
				}
			}while(enterChoice!=1&&enterChoice!=2&&enterChoice!=3);
		}

		catch(Exception exp)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!");
			ael.allExceptionLogger(exp);
			adminupdateamenityview.setAdminUpdateAmenityView(userID, getAmenityId);
		}

	}
}
