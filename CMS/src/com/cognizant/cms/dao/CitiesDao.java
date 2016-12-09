package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to display the Cities for corresponding Countries.


public class CitiesDao 
{
	public boolean citiesDao(String countryCode) throws SQLException, ClassNotFoundException
	{	

		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.citiesQuery);
		preparedStatement.setString(1, countryCode);

		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next())
		{
			rs = preparedStatement.executeQuery();
			System.out.println("\n\t\t\t City ID \t\t City Name");

			while (rs.next())
			{
				String citiesID = rs.getString("City_ID");
				System.out.print("\n\t\t\t "+citiesID);

				String citiesName = rs.getString("City_Name");
				System.out.print("\t\t\t"+citiesName);

			}
		}
		else
		{
			System.out.println("\n\n\t\t\t\t !!! Enter a valid Country ID !!!");
			rs.close();
			connection.close();
			return false;
		}
		rs.close();
		connection.close();
		return true ; 

	}

	public boolean citiesCheckDao(String city) throws SQLException, ClassNotFoundException
	{	

		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.CHECKCITYQUERY);
		preparedStatement.setString(1, city);
		
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next())
		{
			rs.close();
			connection.close(); 
			return true;	
		}
		else
		{
			System.out.println("\n\n\t\t\t\t !!! Enter a valid City ID !!!");
			rs.close();
			connection.close(); 
			return false;
		}

	}

}
