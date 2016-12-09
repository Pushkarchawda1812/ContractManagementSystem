package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.model.AcknowledgeContractStatusTO;
import com.cognizant.cms.util.GetConnectionDao;

//author Ishan
//This class is used to by Marketing Admin to update Amenity Status, Status Date along with giving remarks.


public class AdminUpdateAmenityViewDao 
{
	public void adminupdateAmenityViewDao(String getAmenityStatus,String getRemarks,String getDate,String amenityId)throws SQLException, ClassNotFoundException
	{

		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection

		PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.adminUpdateAmenityViewQuery);
		preparedstatement.setString(1,getAmenityStatus);
		preparedstatement.setString(2,getRemarks);
		preparedstatement.setString(3,getDate);
		preparedstatement.setString(4,amenityId);
		preparedstatement.executeUpdate();


		connection.close(); 


	}

	public void editcontractstatus(String contractStatus) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection=GetConnectionDao.getConnectionDao();
		PreparedStatement editcontractstatus=connection.prepareStatement(QueryConstant.editContractStatusAmenity);
		editcontractstatus.setString(1,contractStatus);
		editcontractstatus.setString(2,AcknowledgeContractStatusTO.getContractID());

		editcontractstatus.executeQuery();

		connection.close(); 

	}
	public void editcontractLock(String contractLock) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection=GetConnectionDao.getConnectionDao();
		PreparedStatement editcontractstatus=connection.prepareStatement(QueryConstant.editContractLockAmenity);
		editcontractstatus.setString(1,contractLock);
		editcontractstatus.setString(2,AcknowledgeContractStatusTO.getContractID());

		editcontractstatus.executeQuery();

		connection.close(); 

	}
}
