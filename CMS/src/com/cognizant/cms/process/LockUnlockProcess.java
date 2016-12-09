package com.cognizant.cms.process;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.*;

//author Ishan
//This class if for Locking and Unlocking a Contract for Restricted use purpose.


public class LockUnlockProcess 
{
	public 	void amenityDescriptionBO(String userID,String getAmenityId) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		AdminUpdateAmenityView adminupdateamenityview=new AdminUpdateAmenityView();
		AllExceptionLogger ael= new AllExceptionLogger();
		LockUnlockProcess lub=new LockUnlockProcess();
		Scanner s=new Scanner(System.in);
		int descriptionExitChoice;
		try
		{
			do
			{
				System.out.print("\n\n\t\t   Enter 1 to Go Back to Previous Page : ");
				descriptionExitChoice=s.nextInt();
				s.nextLine();
				if(descriptionExitChoice==1)
				{

					adminupdateamenityview.setAdminUpdateAmenityView(userID,getAmenityId);
				}
				else
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!!");

				}
			}while(descriptionExitChoice!=1);
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter Correct Choice   !!!");
			ael.allExceptionLogger(ex);
			lub.amenityDescriptionBO(userID, getAmenityId);
		}
	}


}



