package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.model.NewSupplierRegisterFormTO;
import com.cognizant.cms.model.RegisterUserTO;
import com.cognizant.cms.util.GetConnectionDao;


//author Pushkar
//This class is used to register the details of the Supplier into the system.


public class SupplierFormDetailsDao 
{
	public void supplierFormDetailsDao(String supplierGenerateID,NewSupplierRegisterFormTO nsr) throws SQLException, ClassNotFoundException
	{	
		int seq=0;	

		Connection connection =GetConnectionDao.getConnectionDao();

		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.supplierFormInsertQuery);
		preparedStatement.setString(1,supplierGenerateID);
		preparedStatement.setString(2,NewSupplierRegisterFormTO.getSupplierName());
		preparedStatement.setString(3,RegisterUserTO.getPassword());
		preparedStatement.setString(4,RegisterUserTO.getDateOfBirth());
		preparedStatement.setString(5,RegisterUserTO.getEmailAddress());
		preparedStatement.setLong(6,RegisterUserTO.getContact());
		preparedStatement.setString(7,RegisterUserTO.getAddress());
		preparedStatement.setString(8,RegisterUserTO.getCityCode());
		preparedStatement.setString(9,RegisterUserTO.getCountryCode());

		preparedStatement.executeUpdate();

		PreparedStatement preparedStatement1 = connection.prepareStatement(QueryConstant.sequenceSupplier);


		ResultSet rs=preparedStatement1.executeQuery();

		if(rs.next())
		{

			seq=rs.getInt(1);

		}
		rs.close();
		System.out.println("\n\n\t\t\t\t\t\t\t !!!   YOU HAVE SUCESFULLY REGISTERED   !!!");
		System.out.println("\n\t\t   USER ID : "+supplierGenerateID+seq);

		connection.close(); 

	}

}
