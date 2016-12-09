package com.cognizant.cms.bo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Pushkar
//This Class calculates the age of the user while registration on the basis of Date of Birth Entered.


public class AgeCalculationBO 
{
	final static Logger logger = Logger.getLogger(AgeCalculationBO.class);


	public int yearCalculation(String s2) throws ParseException
	{
		PropertyConfigurator.configure("log4j.properties");

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		Date d1=new Date();
		Date d2=sdf.parse(s2);
		c.setTime(d1);
		int m1=c.get(Calendar.MONTH);
		int y1=c.get(Calendar.YEAR);
		c.setTime(d2);
		int m2=c.get(Calendar.MONTH);
		int y2=c.get(Calendar.YEAR);
		int calculation=(y1-y2)*12+(m1-m2);
		int year=calculation/12;
		logger.info("\n Age is : "+year);
		return year;
	}
}