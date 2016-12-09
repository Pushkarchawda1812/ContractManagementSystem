package com.cognizant.cms.dao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.constant.QueryConstant;


//author Ishan
//This class is used to display the Amenity Description.


public class AmenityDescriptionDao 

{

	public void amenityDescriptionDao(String selectedId)throws SQLException, ClassNotFoundException
	{

		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection


		PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.amenityDescriptionViewQuery);
		preparedstatement.setString(1,selectedId);
		ResultSet resultset=preparedstatement.executeQuery();
		System.out.format("\n\n\t\t   AMENITIES DESCRIPTION : ");
		while(resultset.next()) 
		{
			System.out.print(resultset.getString("amenity_description"));
		}

		resultset.close();

		connection.close();
	}

}

