package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.constant.QueryConstant;


//author Ishan
//This class is used to update the Lock Status of a particular Contract.


public class LockContractViewDao
{
	public int lockContractViewDao(String contractID)throws SQLException, ClassNotFoundException
	{ 

		int result;
		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection

		PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.lockContractUpdateQuery);        // create prepare Statemnet
		preparedstatement.setString(1, "Lock");               // set input parameter 1
		preparedstatement.setString(2, contractID);            // set input parameter 2
		result=preparedstatement.executeUpdate();                // execute update statement
		connection.close(); 
		System.out.println(result);
		return result;
	}
}
