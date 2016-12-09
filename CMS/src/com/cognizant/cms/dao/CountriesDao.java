package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to display the list of Countries while new registration. 


public class CountriesDao 
{
	public boolean countriesDao() throws SQLException, ClassNotFoundException
	{	
		

		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.countriesQuery);			

		ResultSet rs = preparedStatement.executeQuery();

		System.out.println("\n\t\t\t Country ID \t\t Country Name");

		while (rs.next())
		{
			String countriesID = rs.getString("Country_ID");
			System.out.print("\n\t\t\t "+countriesID);

			String countriesName = rs.getString("Country_Name");
			System.out.print("\t\t\t "+countriesName);			 

		}
		rs.close();
		connection.close();
		return false; 

	}

}
