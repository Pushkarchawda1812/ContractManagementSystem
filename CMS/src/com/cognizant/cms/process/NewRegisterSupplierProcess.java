package com.cognizant.cms.process;

import java.sql.SQLException;
import com.cognizant.cms.dao.SupplierFormDetailsDao;
import com.cognizant.cms.model.NewSupplierRegisterFormTO;

//author Pushkar
//This class creates a Username for a user who registers as a Supplier.


public class NewRegisterSupplierProcess 
{
	public void newRegisterSupplierBo(String supplierGenerateID, NewSupplierRegisterFormTO nsr) throws ClassNotFoundException, SQLException
	{
		SupplierFormDetailsDao sfdd= new SupplierFormDetailsDao();

		char toConvert[] = supplierGenerateID.toUpperCase().toCharArray();
		StringBuffer sb= new StringBuffer();

		sb.append("S");
		sb.append(toConvert[0]);
		sb.append(toConvert[1]);
		sb.append(toConvert[2]);


		supplierGenerateID = sb.toString();

		sfdd.supplierFormDetailsDao(supplierGenerateID,nsr);

	}
}
