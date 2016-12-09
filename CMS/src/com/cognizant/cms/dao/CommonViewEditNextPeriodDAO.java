package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.process.CommonViewEditNextProcess;
import com.cognizant.cms.util.DbUtil;
import com.cognizant.cms.views.CreateContractView;
import com.cognizant.cms.views.ViewContractsView;


//author Shikha
//This class performs viewing and editing operations on the Contracts in Next Period Category.


public class CommonViewEditNextPeriodDAO 
{
	public void viewnextperiodcontractdao( String userID) throws SQLException, ClassNotFoundException, IOException, ParseException, InterruptedException
	{

		int i=0;

		@SuppressWarnings("unused")
		StringTokenizer stk;

		ViewContractsView vcv=new ViewContractsView();
		CreateContractView ccv=new CreateContractView();
		CommonViewEditNextProcess cvbo=new CommonViewEditNextProcess();
		ArrayList<String> arrname = new ArrayList<String>();
		ArrayList<String> arrid = new ArrayList<String>();
		ArrayList<StringTokenizer> arrstart = new ArrayList<StringTokenizer>();
		ArrayList<Integer> arryear=new ArrayList<Integer>();

		Connection connection =DbUtil.getConnection();

		Statement nextperiod=connection.createStatement();

		ResultSet rs;

		rs=nextperiod.executeQuery(QueryConstant.NEXTPERIODQUERY);
		if(rs.next())
		{
			rs=nextperiod.executeQuery(QueryConstant.NEXTPERIODQUERY);

			while(rs.next())
			{
				arrname.add(i,rs.getString(1));
				arrid.add(i,rs.getString(2));
				arrstart.add(i,stk=new StringTokenizer(rs.getString(3),"-"));
				arryear.add(i,rs.getInt(4));

				i++;

			}
		}
		else
		{
			int choice=0;
			System.out.println("\n\n\t\t   Create Contract");
			System.out.println("\n\n\t\t   Press 1 to create contract : ");
			Scanner sc=new Scanner(System.in);
			try{
				choice=sc.nextInt();}
			catch(Exception ex){
				System.out.println("\n\n\t\t\t\t\t\t !!!   Invalid Entry   !!!");
				vcv.contractview(userID);

			}
			if(choice==1)
			{
				ccv.ContractCreationProcess(userID);
			}
			else
			{
				vcv.contractview(userID);
			}
		}

		cvbo.contractview(userID, arrname, arrid, arrstart, arryear);
		rs.close();
		connection.close(); 
	}

	//This method checks whether the Contract ID entered by the user exists in the Database or not.


	public boolean contractidvoilation(String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		Connection connection =DbUtil.getConnection();
		ResultSet rs;
		PreparedStatement viewcontractid = connection.prepareStatement(QueryConstant.CONTRACTIDVALIDATION);
		viewcontractid.setString(1,Contractid);
		rs=viewcontractid.executeQuery();

		if(rs.next())
		{
			rs.close();
			connection.close(); 
			return true;	
		}
		else
		{
			rs.close();
			connection.close(); 
			return false;
		}

	}
}
