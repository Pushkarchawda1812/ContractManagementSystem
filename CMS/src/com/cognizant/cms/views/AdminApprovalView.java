package com.cognizant.cms.views;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import com.cognizant.cms.dao.AdminApprovalViewDao;

//author Ishan
//This class displays the amenities which are to be approved by the Admin.


public class AdminApprovalView
{
	public void adminApprovalView(String userID)throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		Scanner s=new Scanner(System.in);
		String amenityId;
		boolean b;

		AdminApprovalViewDao adminapprovalviewdao=new AdminApprovalViewDao();
		AdminUpdateAmenityView adminupdateamenityview=new AdminUpdateAmenityView();

		do
		{
			System.out.print("\n\t\t   Enter the Amenity Id : ");
			amenityId=s.nextLine();
			b=adminapprovalviewdao.adminApprovalViewDao(amenityId);
			if(b==true)
			{
				adminupdateamenityview.setAdminUpdateAmenityView(userID, amenityId);
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Incorrect Amenity Id! Please enter amenity id again   !!!");
			}
		}while(b==false);

	}
}
