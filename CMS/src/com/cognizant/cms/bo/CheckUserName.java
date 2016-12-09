package com.cognizant.cms.bo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Pushkar
//This Class validates the username entered by the user while registering in the application.


public class CheckUserName 
{
	final static Logger logger = Logger.getLogger(CheckUserName.class);
	public boolean checkUserName(String Name)
	{
		PropertyConfigurator.configure("log4j.properties");


		int flagInt=0, flagSpecial=0;
		char check[]=Name.toCharArray();
		for(int i=0;i<check.length;i++)
		{
			if(check[i]>=48&&check[i]<=57)
			{
				flagInt=1;
			}
			if(check[i]=='!'||check[i]=='@'||check[i]=='#'||check[i]=='$'||check[i]=='%'||check[i]=='^'||check[i]=='&'||check[i]=='*')
			{
				flagSpecial=1;
			}
		}
		if(flagInt==1||flagSpecial==1)
		{
			logger.info("\n\n\n\t !! User Name Can be Alphabate Only !!! --- \n\n");
			return true;

		}
		logger.info("\n\n\n\t !! User Name is Valid !!! --- \n\n");
		return false;

	}

}
