package com.cognizant.cms.process;

import java.sql.SQLException;
import com.cognizant.cms.dao.AdminFormDetailsDao;
import com.cognizant.cms.model.NewAdminRegisterFormTO;

//author Pushkar
//This class creates a Username for a user who registers as a Marketing Admin.


public class NewRegisterFormProcess 
{
	public void newRegisterFormBo(String adminGenerateID, NewAdminRegisterFormTO nr) throws ClassNotFoundException, SQLException
	{
		AdminFormDetailsDao afdd= new AdminFormDetailsDao();

		char toConvert[] = adminGenerateID.toUpperCase().toCharArray();
		StringBuffer sb= new StringBuffer();

		sb.append("MA");
		sb.append(toConvert[0]);
		sb.append(toConvert[1]);
		sb.append(toConvert[2]);

		adminGenerateID = sb.toString();

		afdd.adminFormDetailsDao(adminGenerateID,nr);

	}

}
