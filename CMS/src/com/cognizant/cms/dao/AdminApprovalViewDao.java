package com.cognizant.cms.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cognizant.cms.model.AcknowledgeContractStatusTO;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.constant.QueryConstant;

public class AdminApprovalViewDao 
{
	public boolean adminApprovalViewDao(String selectedId)throws SQLException, ClassNotFoundException
    {
		
		Connection connection=GetConnectionDao.getConnectionDao();                 //to establish connection
    	Statement statement=connection.createStatement();
    	ResultSet resultset=statement.executeQuery(QueryConstant.adminApprovalViewQuery);
    	
    	System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________");	
        
        System.out.println();
        System.out.format(" %-20s %-20s %-20s %-30s %-20s %-20s %-20s\n","Amenity ID","Contract ID","Amenity Name","Amenity Description","Supplier ID","Amenity Status","Remarks");
        System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
    	int count=0;
        while(resultset.next()) 
    	{
    		count=0;
    		if((resultset.getString("amenity_id")).equals(selectedId))
    		{
    			count=1;
    			 AcknowledgeContractStatusTO.setContractID(resultset.getString(2));
    		        
    		      	System.out.format("\n  %-20s %-20s %-20s %-30s %-20s %-20s %-20s\n",resultset.getString("amenity_id"),resultset.getString("contract_id")
    		        			 ,resultset.getString("amenity_name"),resultset.getString("amenity_description"),resultset.getString("supplier_id")
    		        			 ,resultset.getString("amenity_status") ,resultset.getString("Amenity_Remarks"));
    		      	System.out.println();
    		      	System.out.println();
    		      	break;
    		}
    		
    	}
    	if(count==1)
    	{
    		resultset.close();
    		connection.close(); 
    		return true;
    	}
    	else
    	{
    		resultset.close();
    		connection.close(); 
    		return false;
    	}
    }
}
