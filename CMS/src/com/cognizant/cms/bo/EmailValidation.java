package com.cognizant.cms.bo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Pushkar
//This class validates the email entered by the user while Registering.


public class EmailValidation 
{
	final static Logger logger = Logger.getLogger(EmailValidation.class);

	public boolean emailvalidation(String email) 
	{
		PropertyConfigurator.configure("log4j.properties");
		boolean flag = false;
		boolean flagcom = false;
		char valid[] = email.toLowerCase().toCharArray();
		for (int i = 0; i < valid.length; i++) 
		{
			if (valid[i] == '@') 
			{
				flag = true;
			}
			if ((valid[i] == '.') && (valid[i + 1] == 'c')
					&& (valid[i + 2] == 'o') && (valid[i + 3] == 'm')) 
			{
				flagcom = true;
			}
		}
		if (flag == true && flagcom == true) 
		{
			logger.info("\n\n !!! Valid Email.... !!! ");
			return true;
		}
		logger.info("\n\n !!! Invalid Email.... !!! ");
		return false;
	}
}
