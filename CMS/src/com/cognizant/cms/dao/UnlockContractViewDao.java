package com.cognizant.cms.dao;
import java.sql.*;

import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


//author Ishan
//This class is used to update the Contract Lock Status of a particular Contract.


public class UnlockContractViewDao
{
	public void unlockContractViewDao(String contractID)throws ClassNotFoundException, SQLException
	{


		Connection connection=GetConnectionDao.getConnectionDao();

		PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.unlockContractUpdateQuery);
		preparedstatement.setString(1,"Unlock");
		preparedstatement.setString(2, contractID);
		preparedstatement.executeUpdate();

		connection.close(); 
	}
}