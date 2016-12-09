package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to edit the Supplier Details by him/her after being registered into the system.


public class EditSupplierDetailDao 
{
	public void editSupplierPasswordDao(String password, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editPasswordSupplierQuery);
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully    !!!");

		connection.close(); 

	}


	//This method is used to edit email address.


	public void editSupplierEmailDao(String emailAddress, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editEmailSupplierQuery);
		preparedStatement.setString(1, emailAddress);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully    !!!");

		connection.close(); 

	}


	//This method is used to edit Contact Number.


	public void editSupplierContactDao(long contactNumber, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editContactSupplierQuery);
		preparedStatement.setLong(1, contactNumber);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully    !!!");

		connection.close(); 

	}


	//This method is used to edit Address.


	public void editSupplierAddressDao(String address, String userID) throws ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.editAddressSupplierQuery) ;
		preparedStatement.setString(1, address);
		preparedStatement.setString(2, userID);

		preparedStatement.executeUpdate();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   Data Edited Sucessfully    !!!");

		connection.close(); 

	}

}
