package com.cognizant.cms.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Shikha 
 */
/**
 * Class ContractTO- Used for storing the Contract details
 */

public class ContractTO 
{
	
	private int Enddate;
	
	

	/**Holds the Unique UserId of the User */
	private String UserId;
	
	/**Contract Name to be given by the User */
	private String Contract_Name;
	
	/**Type of the contract to be given by the User */
	private String Type_of_Contract;
	
	/**Start Date for the Contract */
	private String Start_Date;
	
	/**End Date for the Contract */
	private String Lock_Status;
	
	/**Number of years for the Contract */
	private int Number_of_Years;
	
	/**Status of the Contract */
	private String Contract_Status;
	
	/** System Generated Contract ID */
	private String ContractID;

	/**
	 * Displays the User ID.
	 */
	public String getUserId() 
	{
		return UserId;
	}
	
	
	/**
	 * Enters the new User ID.
	 */
	public void setUserId(String userId) 
	{
		UserId = userId;
	}
	
	
	
	/**
	 * Displays the Contract Name.
	 */
	public String getContract_Name() 
	{
		return Contract_Name;
	}
	
	/**
	 * Enters the new Contract Name.
	 */
	public void setContract_Name(String contract_Name) 
	{
		Contract_Name = contract_Name;
	}
	
	/**
	 * Displays the Contract Type.
	 */
	public String getType_of_Contract() 
	{
		return Type_of_Contract;
	}
	
	/**
	 * Enters the Contract Type.
	 */

	public void setType_of_Contract(int choice) 
	{
		if(choice==1)
		{
		Type_of_Contract="Current Period";
		
		}
		else if(choice==2)
		{
			Type_of_Contract="Next Period";
		}
		else if(choice==3)
		{
			Type_of_Contract="Last Period";
		}
		
		
	}

	/**
	 * Displays the Start Date.
	 */
	public String getStart_Date() 
	{
		return Start_Date;
	}
	
	/**
	 * Enters the Start Date.
	 */
	public void setStart_Date(String start_Date) 
	{
		Start_Date = start_Date;
	}
	
	/**
	 * Displays the Contract End Date.
	 */

	public String getLock_Status() 
	{
		return Lock_Status;
	}
	
	/**
	 * Enters the Contract End Date.
	 */
    public void setLock_Status(String lock_status) 
	{
		Lock_Status = lock_status;
	}
    
    /**
	 * Displays the Contract Time period.
	 */
    public int getNumber_of_Years() 
    {
		return Number_of_Years;
	}
    
    /**
	 * Enters the Contract Time period.
	 */
    public void setNumber_of_Years(int number_of_Years) {
		Number_of_Years = number_of_Years;
	}
    
    
    /**
	 * Displays the Contract current status.
	 */
	public String getContract_Status() {
		return Contract_Status;
	}
	
	
	 /**
	 * Enters the Contract Time period.
	 */
     public void setContract_Status(String contract_Status) {
		Contract_Status = contract_Status;
	}

    /**Displays the Contract Id. */
	public String getContractID() {
		return ContractID;
	}


	public void setContractID(String contractID) {
		ContractID = contractID;
	}
	
	public int getEnddate() {
		return Enddate;
	}


	public void setEnddate(String Startdate,int Number_of_Years) throws ParseException {
        Calendar c1=Calendar.getInstance();
		
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
        Date d1=sdf.parse(Startdate);
        c1.setTime(d1);
        int startyear=c1.get(Calendar.YEAR)+1;
        
        Enddate=startyear+Number_of_Years;
        
        
	}

	
	
	
	

}
