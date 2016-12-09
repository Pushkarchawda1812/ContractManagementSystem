package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.model.ContractTO;
import com.cognizant.cms.process.EditContractPeriodProcess;
import com.cognizant.cms.util.DbUtil;


//author Shikha
//This class is used for editing the details of the Contract for the Next Period Category.


public class EditNextDAO 
{

	public void nextperiodeditdao(String userID ,String Contractid) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		Connection connection =DbUtil.getConnection();
		ResultSet rs;
		ArrayList<String> arradminid = new ArrayList<String>();
		ArrayList<String> arrcname = new ArrayList<String>();
		ArrayList<String> arrtype = new ArrayList<String>();
		ArrayList<StringTokenizer> arrstart = new ArrayList<StringTokenizer>();
		ArrayList<Integer> arryear = new ArrayList<Integer>();
		ArrayList<String> arrid = new ArrayList<String>();
		ArrayList<String> arrlock = new ArrayList<String>();
		ArrayList<String> arrstatus = new ArrayList<String>();
		EditContractPeriodProcess enbo=new EditContractPeriodProcess();


		int i=0;
		PreparedStatement viewnextperiod = connection.prepareStatement(QueryConstant.NEXTPERIODVIEW);
		viewnextperiod.setString(1,Contractid);
		rs=viewnextperiod.executeQuery();

		@SuppressWarnings("unused")
		StringTokenizer stk;

		while(rs.next())
		{
			arradminid.add(i,rs.getString(1));
			arrcname.add(i,rs.getString(2));
			arrtype.add(i,rs.getString(3));
			arrstart.add(i,stk=new StringTokenizer(rs.getString(4),"-"));
			arryear.add(i, rs.getInt(5));
			arrid.add(i,rs.getString(6));
			arrlock.add(i,rs.getString(7));
			arrstatus.add(i,rs.getString(8));
			i++;
		}
		enbo.contractedit( userID, arradminid, arrcname, arrtype, arrstart, arryear, arrid, arrlock, arrstatus, Contractid);
		rs.close();
		connection.close(); 

	}


	//This method is used to edit the Number of Years in a Contract.


	public void editnumberofyears(int year,ContractTO cto,String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection =DbUtil.getConnection();
		PreparedStatement editnumberofyear=connection.prepareStatement(QueryConstant.EDITNUMBEROFYEARS);
		editnumberofyear.setInt(1, cto.getNumber_of_Years());
		editnumberofyear.setString(2, Contractid);
		editnumberofyear.executeQuery();

		connection.close(); 


	}


	//This method is used to edit the Lock Status of the Contract.


	public void editlockstatus(String lock,ContractTO cto,String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection =DbUtil.getConnection();
		PreparedStatement editlockstatus=connection.prepareStatement(QueryConstant.EDITLOCKSTATUS);
		editlockstatus.setString(1, cto.getLock_Status());
		editlockstatus.setString(2, Contractid);
		editlockstatus.executeQuery();

		connection.close(); 

	}


	//This method is used to edit the Contract Status of the Contract.


	public void editcontractstatus(String contractstatus,ContractTO cto,String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection =DbUtil.getConnection();
		PreparedStatement editcontractstatus=connection.prepareStatement(QueryConstant.EDITCONTRACTSTATUS);
		editcontractstatus.setString(1, cto.getContract_Status());
		editcontractstatus.setString(2, Contractid);
		editcontractstatus.executeQuery();

		connection.close(); 

	}


}
