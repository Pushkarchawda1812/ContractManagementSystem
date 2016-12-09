package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to display the Welcome message for the particular Admin.


public class WelcomeNameDao 
{
	public String welcomeNameDao(String userID) throws SQLException, ClassNotFoundException
	{

		Connection connection =GetConnectionDao.getConnectionDao();
		char first[]=userID.toCharArray();
		if(first[0]=='M')
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.welcomeAdminNameDisplay);
			preparedStatement.setString(1, userID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				String name = rs.getString("Admin_Name");
				connection.close(); 
				return name;
			}
		}	

		if(first[0]=='S')
		{		
			PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.welcomeSupplierNameDisplay);
			preparedStatement.setString(1, userID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				String name = rs.getString("Supplier_Name");
				connection.close(); 
				return name;	
			}
			rs.close();
		}

		connection.close(); 
		return null;
	}

}
