package com.cognizant.cms.process;

import com.cognizant.cms.model.ContractTO;


//author Shikha
//This class Creates a Unique ContractID for the Contract taking the Contract name and User name.


public class CreateContractValidationProcess 

{
	private String Contractid;
	public void createContractID(ContractTO cto)

	{


		StringBuffer sb=new StringBuffer();
		String s1=cto.getUserId().toUpperCase().substring(0,2);
		String s2=cto.getUserId().toUpperCase().substring(2,5);
		String s3=cto.getContract_Name().toUpperCase().substring(0,3);
		String s4=cto.getStart_Date();
		Contractid=sb.append(s1).append("_").append(s2).append("_").append(s3).append("_").append(s4).toString();

		cto.setContractID(Contractid);
	}

}
