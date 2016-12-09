package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.model.NewAdminRegisterFormTO;
import com.cognizant.cms.model.RegisterUserTO;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to enter the details of the Admin while registering.


public class AdminFormDetailsDao
{
	public boolean adminFormDetailsDao(String adminGenerateID,NewAdminRegisterFormTO nr) throws SQLException, ClassNotFoundException
	{	
		int seq=0;

		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.adminFormInsertQuery);
		preparedStatement.setString(1,adminGenerateID);
		preparedStatement.setString(2,NewAdminRegisterFormTO.getUserName());
		preparedStatement.setString(3,RegisterUserTO.getPassword());
		preparedStatement.setString(4,RegisterUserTO.getDateOfBirth());
		preparedStatement.setString(5,RegisterUserTO.getEmailAddress());
		preparedStatement.setLong(6,RegisterUserTO.getContact());
		preparedStatement.setString(7,RegisterUserTO.getAddress());
		preparedStatement.setString(8,RegisterUserTO.getCityCode());
		preparedStatement.setString(9,RegisterUserTO.getCountryCode());

		preparedStatement.executeUpdate();

		PreparedStatement preparedStatement1 = connection.prepareStatement(QueryConstant.sequenceAdmin);


		ResultSet rs=preparedStatement1.executeQuery();

		if(rs.next())
		{

			seq=rs.getInt(1);

		}

		System.out.println("\n\n\t\t\t YOU HAVE SUCESFULLY REGISTERED");
		System.out.println("\n\t\t\t\t USER ID : "+adminGenerateID+seq);
		rs.close();
		connection.close();
		return false; 

	}

}
