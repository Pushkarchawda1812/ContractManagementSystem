package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import com.cognizant.cms.constant.MessageConstant;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.model.ContractTO;
import com.cognizant.cms.util.DbUtil;
import com.cognizant.cms.views.CreateContractView;


//author Shikha
//This class is used to create Contracts by Marketing Admin.


public class CreateContractDAO 
{
	public boolean CreateContract(String userID,ContractTO cto) throws SQLException, ClassNotFoundException, IOException, ParseException, InterruptedException
	{
		int seq=0;

		CreateContractView ccv=new CreateContractView();
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		Connection connection =DbUtil.getConnection();


		PreparedStatement st;
		ResultSet rs;


		st=connection.prepareStatement(QueryConstant.CONTRACTNAMEQUERY);
		st.setString(1,cto.getContract_Name());
		st.setString(2,cto.getStart_Date());
		st.setInt(3,cto.getNumber_of_Years());
		rs=st.executeQuery();
		if(rs.next())
		{

			System.out.println("\n\t\t\t\t\t\t\t !!!   This Contract Name for the given Time Period is not available   !!!");
			System.out.println("\n\n\n\n");
			ccv.ContractCreationProcess(userID);

		}

		else
		{
			PreparedStatement insertcontractdetails = connection.prepareStatement(QueryConstant.CREATECONTRACTQUERY);
			insertcontractdetails.setString(1,cto.getUserId());
			insertcontractdetails.setString(2,cto.getContract_Name());
			insertcontractdetails.setString(3,cto.getType_of_Contract());
			insertcontractdetails.setString(4,cto.getStart_Date());
			insertcontractdetails.setInt(5,cto.getNumber_of_Years());
			insertcontractdetails.setString(6,cto.getContractID());

			insertcontractdetails.executeUpdate();


			PreparedStatement preparedStatement1 = connection.prepareStatement(QueryConstant.sequenceContract);


			rs=preparedStatement1.executeQuery();

			if(rs.next())
			{

				seq=rs.getInt(1);

			}
		}


		System.out.println(MessageConstant.SUCCESSCONTRACTCREATION);
		System.out.println("\n\t\t\t\t\t\t!!!   Contract ID for the created contract is : "+cto.getContractID()+seq+ "   !!!");


		cmd.dispatchActionCreateContract(userID);
		rs.close();
		connection.close();
		return false; 


	}

}
