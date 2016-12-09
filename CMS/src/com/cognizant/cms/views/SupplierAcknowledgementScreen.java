package com.cognizant.cms.views;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.dao.SupplierAcknowledgementScreenDao;
import com.cognizant.cms.views.AcknowledgementScreen;

//author Ishan
//Used to display the feedback of Admin to Supplier for amenities added by him.

public class SupplierAcknowledgementScreen
{
	public void supplierAcknowledgementScreen(String userID) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner s=new Scanner(System.in);
		String enterAmenityId;
		int flag;
		String enterNumber;
		SupplierAcknowledgementScreenDao  supplieracknowledgementscreendao=new  SupplierAcknowledgementScreenDao();
		AcknowledgementScreen acknowledgementscreen=new AcknowledgementScreen();
		do
		{
			System.out.print("\n\n\t\t   Enter the Amenity ID : ");
			enterAmenityId=s.nextLine();
			flag=supplieracknowledgementscreendao.supplierAcknowledgementScreenDao(enterAmenityId);
			if(flag==0)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!!    Please Enter Correct Amenity ID !!!!");
			}
			else
			{
				do
				{
					System.out.print("\n\t\t   Enter 1 to Go to Previous Page : ");
					enterNumber=s.nextLine();
					if(enterNumber.equalsIgnoreCase("1"))
					{
						acknowledgementscreen.printAcknowledgementScreen(userID);
					}
					else
					{

						System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter 1   !!!");
					}}while(!enterNumber.equalsIgnoreCase("1"));
			}
		}while(flag==0);
	}
}

