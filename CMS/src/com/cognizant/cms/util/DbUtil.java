package com.cognizant.cms.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//author Shikha
//This class creates the connection with database.

public class DbUtil {




	public static Connection getConnection() throws ClassNotFoundException, SQLException,IOException
	{

		{
			Connection connection;
			Properties prop = new Properties();
			prop.load(new FileInputStream("db.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);

			return connection;

		}

	}


}