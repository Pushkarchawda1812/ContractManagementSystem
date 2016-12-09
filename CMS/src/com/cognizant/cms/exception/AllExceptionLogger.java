package com.cognizant.cms.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AllExceptionLogger 
{
	final static Logger logger = Logger.getLogger(AllExceptionLogger.class);
	
	
	public void allExceptionLogger(Exception ex)
	{
		
		PropertyConfigurator.configure("log4j.properties");
		logger.error("\n\n\n\t Sorry, something wrong! --- \n\n", ex);	
		
	}
	
	public void allErrorLogger(String errorCms)
	{
		
		PropertyConfigurator.configure("log4j.properties");
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + errorCms);
		}
 
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + errorCms);
		}
		
		logger.warn("This is warn : " + errorCms);
		logger.error("This is error : " + errorCms);
		logger.fatal("This is fatal : " + errorCms);
		
		
	}

}
