package com.cognizant.cms.bo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//This class takes the system Date.
public class SystemDateBO {

	/**
	 * generate system date in YYYYMMdd format
	 */
	public String systemDate() {
		Date d;
		SimpleDateFormat sdf= new SimpleDateFormat("YYYYMMdd");

		Calendar c=Calendar.getInstance();
		d=c.getTime();
		String date=sdf.format(d);
		return date;

	}
	/**
	 * generate system date in YYYY-MM-dd format
	 */
	
	public String systemCurrentDate() {
		Date d;
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");

		Calendar c=Calendar.getInstance();
		d=c.getTime();
		String date=sdf.format(d);
		return date;

	}

}
