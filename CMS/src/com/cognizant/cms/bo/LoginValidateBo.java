package com.cognizant.cms.bo;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cognizant.cms.dao.LoginValidateDao;

public class LoginValidateBo 
{
	final static Logger logger = Logger.getLogger(LoginValidateBo.class);


	public boolean loginValidate(String userID, String password) throws ClassNotFoundException, SQLException
	{
		PropertyConfigurator.configure("log4j.properties");

		String dataBasePassword = null;

		LoginValidateDao lvd=new LoginValidateDao();

		char firstLetter[]=userID.toCharArray();

		if(firstLetter[0]=='M')
		{
			dataBasePassword=lvd.loginValidateDaoAdmin(userID);	
		}
		if(firstLetter[0]=='S')
		{
			dataBasePassword=lvd.loginValidateDaoSupplier(userID);
		}


		if(dataBasePassword.equals(password))
		{
			logger.info("\n\n !!! Login Successfully !!! ");
			return true;
		}
		else
		{
			logger.info("\n\n !!! Login UnSuccessfully, UserID or Password is Invalid!!! ");
			return false;
		}

	}

	public boolean passwordValidate(String userID, String oldPassword) throws ClassNotFoundException, SQLException
	{
		PropertyConfigurator.configure("log4j.properties");

		String dataBasePassword = null;

		LoginValidateDao lvd=new LoginValidateDao();


		char firstLetter[]=userID.toCharArray();

		if(firstLetter[0]=='M')
		{
			dataBasePassword=lvd.loginValidateDaoAdmin(userID);	
		}
		if(firstLetter[0]=='S')
		{
			dataBasePassword=lvd.loginValidateDaoSupplier(userID);
		}


		if(dataBasePassword.equals(oldPassword))
		{
			logger.info("\n\n !!! Password Verified !!! ");
			return true;
		}
		else
		{
			logger.info("\n\n !!! Password is Invalid!!! ");
			return false;
		}
	}

}

