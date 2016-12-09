package com.cognizant.cms.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//author Pushkar
//This class checks whether the Date of Birth Entered by the User is in the valid format i.e YYYY-MM-DD format.


public class DateofBirthValidation 
{
	final static Logger logger = Logger.getLogger(DateofBirthValidation.class);

	public boolean dateofbirthvalidation(String dob) throws ParseException 
	{
		SystemDateBO sd= new SystemDateBO();
		PropertyConfigurator.configure("log4j.properties");
		String systemDate=sd.systemCurrentDate();
		StringTokenizer st= new StringTokenizer(dob ,"-");
		StringTokenizer stSystemDate= new StringTokenizer(systemDate ,"-");
		String year=st.nextToken();
		String month=st.nextToken();
		String day=st.nextToken();
		String yearSystem=stSystemDate.nextToken();
		String monthSystem=stSystemDate.nextToken();
		String daySystem=stSystemDate.nextToken();

		if(dob.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}"))
		{

			int yearCurrent=Integer.parseInt(year);
			int monthCurrent=Integer.parseInt(month);
			int dayCurrent=Integer.parseInt(day);
			int yearSystemDate=Integer.parseInt(yearSystem);
			int monthSystemDate=Integer.parseInt(monthSystem);
			int daySystemDate=Integer.parseInt(daySystem);

			if(yearCurrent<yearSystemDate)
			{

				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				try
				{
					@SuppressWarnings("unused")
					Date d=sdf.parse(dob);

				}
				catch(ParseException e)
				{
					logger.info("\n\n !!! Invalid Date Of Birth !!! ");
					return false;
				}

				logger.info("\n\n !!! Valid Date Of Birth !!! ");
				return true;
			}
			else if(yearCurrent==yearSystemDate)
			{
				if(monthCurrent<=monthSystemDate)
				{
					if(dayCurrent<daySystemDate)
					{
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						sdf.setLenient(false);
						@SuppressWarnings("unused")
						Date d=sdf.parse(dob);
						logger.info("\n\n !!! Valid Date Of Birth !!! ");
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
			{
				return false;
			}


		}
		else
		{
			logger.info("\n\n !!! Invalid Date Of Birth !!! ");
			return false;

		}

	}

}
