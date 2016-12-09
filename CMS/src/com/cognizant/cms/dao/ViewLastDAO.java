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
import com.cognizant.cms.process.LastPeriodProcess;
import com.cognizant.cms.util.DbUtil;
import com.cognizant.cms.views.CreateContractView;
import com.cognizant.cms.views.ViewContractsView;


//author Shikha
//This class is used to display Contracts of the Last Period.


public class ViewLastDAO 
{
	public void viewlastperiodcontractdao(String userID) throws SQLException, ClassNotFoundException, IOException, ParseException, InterruptedException
	{
		int i=0;
		
		@SuppressWarnings("unused")
		StringTokenizer stk;
		
		ViewContractsView vcv=new ViewContractsView();
		
		@SuppressWarnings("unused")
		CreateContractView ccv=new CreateContractView();
		
		LastPeriodProcess lbo=new LastPeriodProcess();
		ArrayList<String> arrname = new ArrayList<String>();
		ArrayList<String> arrid = new ArrayList<String>();
		ArrayList<StringTokenizer> arrstart = new ArrayList<StringTokenizer>();
		ArrayList<Integer> arryear=new ArrayList<Integer>();
		Connection connection =DbUtil.getConnection();
		Statement lastperiod=connection.createStatement();
		ResultSet rs;
		
		rs=lastperiod.executeQuery(QueryConstant.LASTPERIODQUERY);
		if(rs.next())
		{
			rs=lastperiod.executeQuery(QueryConstant.LASTPERIODQUERY);
			 
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
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   No Contract exist to View   !!!");
			System.out.print("\n\n\t\t   Press 1 to go back : ");
			Scanner sc=new Scanner(System.in);
			try{
				
			choice=sc.nextInt();}
			catch(Exception ex){
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Invalid Entry   !!!");
				vcv.contractview( userID);
				
			}
			if(choice==1)
			{
				vcv.contractview(userID);
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Wrong Choice   !!!");
			}
		}
		rs.close();
		connection.close(); 
		lbo.lastcontractview(userID, arrname,arrid,arrstart,arryear);
	
	}
	
	
	//
	
	
	public void lastperiodviewdao(String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		String userID=null;
		
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
		
		
		int i=0;
		LastPeriodProcess lbo=new LastPeriodProcess();
		PreparedStatement viewlastperiod = connection.prepareStatement(QueryConstant.LASTPERIODVIEW);
		viewlastperiod.setString(1,Contractid);
		rs=viewlastperiod.executeQuery();
		
		@SuppressWarnings("unused")
		StringTokenizer stk;
		
		while(rs.next())
		{
			userID=rs.getString(1);
			arradminid.add(i,userID);
			arrcname.add(i,rs.getString(2));
			arrtype.add(i,rs.getString(3));
			arrstart.add(i,stk=new StringTokenizer(rs.getString(4),"-"));
			arryear.add(i, rs.getInt(5));
			arrid.add(i,rs.getString(6));
			arrlock.add(i,rs.getString(7));
			arrstatus.add(i,rs.getString(8));
			i++;
			
			
			lbo.lastshow(userID, arradminid, arrcname, arrtype, arrstart, arryear, arrid, arrlock, arrstatus);

		}
		rs.close();
		connection.close(); 
		
	}
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
