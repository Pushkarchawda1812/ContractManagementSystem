package com.cognizant.cms.dao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;
public class AcknowledgementScreenDao
{
    public int acknowledgementScreenDao(String supplierId)throws SQLException, ClassNotFoundException
    {
    	Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection
    	
    	PreparedStatement preparedstatement=connection.prepareStatement(QueryConstant.acknowledgementScreenDaoQuery);
    	ResultSet resultset=preparedstatement.executeQuery();
        System.out.println();
        System.out.println("___________________________________________________________________________________________________________________________________________________________________");
        System.out.println();
        System.out.format("                           %-40s %-50s %-40s\n","Amenity ID","Contract ID","Amenity Name");
        System.out.println("___________________________________________________________________________________________________________________________________________________________________");
        int count=0;
        while(resultset.next())
        {
        	if(resultset.getString("supplier_id").equals(supplierId))
        	{
        		count=1;
        	System.out.println();
	        System.out.format("\n                           %-40s %-50s %-40s\n",resultset.getString("amenity_id"),resultset.getString("contract_id"),resultset.getString("amenity_name"));
	      	System.out.println();
	      	System.out.println();
        }}
        resultset.close();
        connection.close(); 
        return count;       
}
   
}