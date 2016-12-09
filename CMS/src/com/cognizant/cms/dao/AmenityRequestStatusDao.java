package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.views.AdminLoginView;
import com.cognizant.cms.constant.QueryConstant;

//author Ishan
//This class is used to display all the Amenities with Pending Status.


public class AmenityRequestStatusDao 
{
	Scanner sc= new Scanner(System.in);

	public void amenityRequestStatusDao(String userID)throws SQLException, ClassNotFoundException, IOException, InterruptedException, ParseException
	{ 

		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection
		AdminLoginView alv= new AdminLoginView();
		Statement statement=connection.createStatement();

		ResultSet resultset=statement.executeQuery(QueryConstant.amenityRequestStatusQuery);

		if(resultset.next()==true)
		{
			System.out.println("\n\n_____________________________________________________________________________________________________________________________________________________________________________________________________");	

			System.out.println();
			System.out.format(" %-20s %-20s %-20s %-30s %-20s %-20s %-20s\n","Amenity ID","Contract ID","Amenity Name","Amenity Description","Supplier ID","Amenity Status","Remarks");
			System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________");


			resultset=statement.executeQuery(QueryConstant.amenityRequestStatusQuery);  

			while(resultset.next())
			{
				if((resultset.getString("Amenity_Status")).equalsIgnoreCase("Pending"))
				{
					System.out.format("\n  %-20s %-20s %-20s %-30s %-20s %-20s %-20s\n",resultset.getString("Amenity_id"),resultset.getString("Contract_id")
							,resultset.getString("Amenity_name"),resultset.getString("Amenity_description"),resultset.getString("Supplier_id")
							,resultset.getString("Amenity_status") ,resultset.getString("Amenity_Remarks"));

				}	
			}
		}
		else
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   No Amenity Exists  !!! ");
			System.out.println("\n\n\t\t   Press Enter to go back ");
			sc.nextLine();
			alv.adminLoginView(userID);
		}
		resultset.close();
		connection.close();  
	}
}

