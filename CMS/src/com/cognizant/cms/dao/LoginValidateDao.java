package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to validate whether the Supplier/Marketing Admin is being registered into the system when they login.


public class LoginValidateDao 
{
	public String loginValidateDaoAdmin(String userID) throws SQLException, ClassNotFoundException
	{			
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.adminValidateQuery);
		preparedStatement.setString(1,userID);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			String adminPassword = rs.getString("Admin_Password");
			connection.close(); 
			return adminPassword;
		}
		rs.close();
		connection.close(); 
		return null;

	}


	//This method is used to validate if the Supplier is being registered into the system.


	public String loginValidateDaoSupplier(String userID) throws SQLException, ClassNotFoundException
	{			
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.supplierValidateQuery);
		preparedStatement.setString(1,userID);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			String supplierPassword = rs.getString("Supplier_Password");
			connection.close(); 
			return supplierPassword;
		}
		rs.close();
		connection.close(); 
		return null;

	}

}
