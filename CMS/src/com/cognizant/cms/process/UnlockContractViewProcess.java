package com.cognizant.cms.process;

import java.sql.SQLException;


//author Ishan

public class UnlockContractViewProcess {

	public boolean unlockContractValidate(int choice) throws ClassNotFoundException, SQLException
	{

		if(choice==1)
		{
			return true;
		}
		else
		{
			return false;

		}
	}

}
