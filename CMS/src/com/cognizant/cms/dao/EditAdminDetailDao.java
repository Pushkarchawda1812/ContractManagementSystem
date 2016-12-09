package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to edit the Admin Details by him/her after being registered into the system.

public class EditAdminDetailDao 
{
	public void editAdminPasswordDao(String password, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement selectUserPassword = connection.prepareStatement(QueryConstant.editPasswordAdminQuery);
		selectUserPassword.setString(1, password);
		selectUserPassword.setString(2, userID);

		selectUserPassword.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully   !!!");

		connection.close(); 

	}


	//This method is used to edit email address.


	public void editAdminEmailDao(String emailAddress, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editEmailAdminQuery);
		preparedStatement.setString(1, emailAddress);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully   !!!");

		connection.close(); 

	}


	//This method is used to edit Contact Number.


	public void editAdminContactDao(long contactNumber, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editContactAdminQuery);
		preparedStatement.setLong(1, contactNumber);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully   !!!");

		connection.close(); 

	}


	//This method is used to edit Address.


	public void editAdminAddressDao(String address, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editAddressAdminQuery) ;
		preparedStatement.setString(1, address);
		preparedStatement.setString(2, userID);


		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully    !!!");

		connection.close(); 

	}

}
