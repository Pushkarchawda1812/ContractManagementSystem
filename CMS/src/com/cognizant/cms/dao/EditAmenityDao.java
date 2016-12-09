package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;


public class EditAmenityDao
{
	public void editAmenityMA(String Contract_ID) throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Connection connection =GetConnectionDao.getConnectionDao();
		
		PreparedStatement editAmenity = connection.prepareStatement(QueryConstant.editAmenityDisplay);
		
		editAmenity.setString(1, Contract_ID);
		editAmenity.executeQuery();
	}
	
	public void editSelectedAmenityDao(String Amenity_ID, String newAmenity_Description) throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		Connection connection =GetConnectionDao.getConnectionDao();
		
		PreparedStatement editingAmenity = connection.prepareStatement(QueryConstant.editSelectedAmenity);
		
		editingAmenity.setString(1, newAmenity_Description);
		editingAmenity.setString(2, Amenity_ID );
		
		editingAmenity.executeQuery();
	}
}