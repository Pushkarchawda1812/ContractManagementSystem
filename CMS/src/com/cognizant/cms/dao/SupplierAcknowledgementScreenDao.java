package com.cognizant.cms.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.controller.ContractManagementSystemController;
import com.cognizant.cms.model.AcknowledgeContractStatusTO;
import com.cognizant.cms.util.GetConnectionDao;


//author Ishan
//This class is used to display the details of the Amenities.


public class SupplierAcknowledgementScreenDao
{


	public int supplierAcknowledgementScreenDao(String amenityId)throws SQLException, ClassNotFoundException, ParseException
	{

		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection

		PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.acknowledgementScreenDaoQuery);
		ResultSet resultset=preparedstatement.executeQuery();
		System.out.println();
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		System.out.format("\n        %-20s %-30s %-30s %-30s %-20s\n","Amenity Id","Amenity Name","Amenity Status","Feedback","Status Updated Date");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		int count=0;
		while(resultset.next())
		{
			if(resultset.getString("amenity_id").equals(amenityId))
			{
				count=1;
				AcknowledgeContractStatusTO.setContractID(resultset.getString(2));
				System.out.println();
				ContractManagementSystemController.sdf.setLenient(false);
				//System.out.format("\n        %-20s %-30s %-30s %-30s %-20s\n",resultset.getString("amenity_id"),resultset.getString("amenity_name"),resultset.getString("amenity_status"),resultset.getString("Amenity_remarks"),ContractManagementSystemController.sdf.format(resultset.getDate("Amenity_status_date")));
				System.out.format("\n        %-20s %-30s %-30s %-30s %-20s\n",resultset.getString("amenity_id"),resultset.getString("amenity_name"),resultset.getString("amenity_status"),resultset.getString("Amenity_remarks"),resultset.getDate("Amenity_status_date"));
				System.out.println();
				System.out.println();
				break;
			}
		}
		resultset.close();
		connection.close(); 
		return count;       
	}
}


