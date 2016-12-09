package com.cognizant.cms.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//author Shikha
//This class creates the connection with database via db properties file.


public class GetConnectionDao {


	public static Connection getConnectionDao() throws ClassNotFoundException, SQLException 
	{
		Connection connection;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","cmsf","cmsf");
		return connection;

	}

}
