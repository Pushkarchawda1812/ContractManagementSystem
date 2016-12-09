package com.cognizant.cms.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Shikha
//This class validates the start date year entered by the user.


public class StartDateValidationBO 
{
	final static Logger logger = Logger.getLogger(EmailValidation.class);

	public boolean datevalidation(String startdate) throws ParseException
	{
		PropertyConfigurator.configure("log4j.properties");

		Calendar c=Calendar.getInstance();
		Calendar c1=Calendar.getInstance();

		int year=c.get(Calendar.YEAR);


		SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
		Date d1=sdf.parse(startdate);
		c1.setTime(d1);
		int startyear=c1.get(Calendar.YEAR)+1;


		if(startyear>=year)
		{
			logger.info("\n\n !!! Valid year !!!");
			return true;
		}
		else
		{
			logger.info("\n\n !!! Invalid year !!!");
			return false;
		}



	}



}
