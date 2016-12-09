/** Class SettingAmentiesDao
 * Used for 
 * Author: Aditi Sharma
 */
package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cognizant.cms.bo.SystemDateBO;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.model.SettingAmenitiesTO;
import com.cognizant.cms.util.GetConnectionDao;


//author Aditi Sharma
//This class is used to add Amenities to the selected Contract.


public class SettingAmentiesDao 
{
	public void setAmenityDao(String contractID, String userID, String Amenity_Name,String Amenity_Description,String amenity_Lock, SettingAmenitiesTO sat) throws IOException, ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();
		SystemDateBO sd= new SystemDateBO();

		String systemDate=sd.systemDate();

		PreparedStatement addAmenity = connection.prepareStatement(QueryConstant.settingAmenityQuery);
		addAmenity.setString(1,contractID);
		addAmenity.setString(2,userID);
		addAmenity.setString(3,sat.getAmenity_Name());
		addAmenity.setString(4,sat.getAmenity_Description());
		addAmenity.setString(5,amenity_Lock);
		addAmenity.setString(6,"Please check and Approve");
		addAmenity.setString(7,systemDate);
		addAmenity.executeQuery();
	} 
}
