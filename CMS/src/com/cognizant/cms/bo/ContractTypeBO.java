package com.cognizant.cms.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Shikha
//This class assigns ContractType to the Contract on the basis of Start Date Entered by the User.


public class ContractTypeBO 
{
	final Logger logger = Logger.getLogger(ContractTypeBO.class);

	public int contracttype(String startdate) throws ParseException
	{

		PropertyConfigurator.configure("log4j.properties");
		Calendar c1=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
		Date d1=sdf.parse(startdate);
		c1.setTime(d1);
		int startyear=c1.get(Calendar.YEAR)+1;

		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);

		int i=0;
		if(startyear==year)
		{
			i=1;

		}
		else if(startyear>year)
		{
			i=2;
		}
		else if(startyear<year)
		{
			i=3;
		}
		return i;
	}

}
