package com.cognizant.cms.process;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.dao.ViewLastDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.ViewContractsView;

//author Shikha
//This class displays all the Contracts of the Last Period Category.


public class LastPeriodProcess 
{
	public void lastcontractview(String userID, ArrayList<String> arrname, ArrayList<String> arrid, ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		AllExceptionLogger ael= new AllExceptionLogger();
		ViewLastDAO vld=new ViewLastDAO();
		Scanner sc=new Scanner(System.in);
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();

		System.out.println("\n\n\t\t\t\t\t\t\t!!!    List of Contracts in this category are    !!!");
		System.out.println("\n___________________________________________________________________________________________________________________________________________________________________");
		System.out.format("                   %-60s %-60s\n","Contract Name(Start Year-End Year)","Contract ID");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");

		for(int i=0;i<arrid.size();i++)
		{
			String startdate=arrstart.get(i).nextToken();
			int enddate=Integer.parseInt(startdate.toString())+arryear.get(i);
			//System.out.println(arrname.get(i)+" ("+startdate+"-"+enddate+")");
			//System.out.println(arrid.get(i));
			System.out.format("\n                   %-60s %-60s\n",arrname.get(i)+" ("+startdate+"-"+enddate+")",arrid.get(i));

			//System.out.println("\n\n\n");

		}

		System.out.print("\n\n\t\t   Enter contract ID from the list : ");
		String contractid=sc.nextLine();

		Boolean b=vld.contractidvoilation(contractid);
		if(b==true)
		{
			System.out.println("\n\t\t   1. View Contract");

			System.out.println("\n\t\t   Enter Choice : ");
			int choice=0;
			try{
				choice=sc.nextInt();	
			}
			catch(Exception ex)
			{
				String errorCms="\n\n\t\t\t\t\t\t\t !!!  Invalid Entry Enter an Integer  !!!";
				System.out.println(errorCms);
				ael.allErrorLogger(errorCms);
				vcv.contractview(userID);
			}
			switch(choice)
			{
			case 1: vld.lastperiodviewdao(contractid);
			break;

			default:System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry Enter an Integer   !!!");
			cmd.dispatchActionCreateContract(userID);
			}
		}

		else
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Search Found No Relevant Results   !!!");
			Thread.sleep(200);
			cmd.dispatchActionCreateContract(userID);
		}
	}
	public void lastshow(String userID, ArrayList<String> arradminid,ArrayList<String> arrcname,ArrayList<String> arrtype,ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear,ArrayList<String> arrid,ArrayList<String> arrlock,ArrayList<String> arrstatus)
	{
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();
		AllExceptionLogger ael= new AllExceptionLogger();
		Scanner sc=new Scanner(System.in);

		System.out.println("\n___________________________________________________________________________________________________________________________________________________________________");
		System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n","Admin ID","Contract Name","Contract Type","Start Date","Number of Years","Contract ID","Lock Status","Contract Status");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		for(int i=0;i<arrid.size();i++)
		{
			System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n",arradminid.get(i),arrcname.get(i),arrtype.get(i),arrstart.get(i).nextToken(),
					arryear.get(i),arrid.get(i),arrlock.get(i),arrstatus.get(i));

		}
		System.out.println("\n\n\n\t\t   1. Enter to Select Another Contract Type");
		System.out.println("\n\t\t   2. Go Back to Previous Menu ");
		try
		{
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: vcv.contractview(userID);
			break;
			case 2: cmd.dispatchActionCreateContract(userID);
			break;
			default:System.out.println("\n\t\t\t\t\t\t\t !!!   Enter choice between 1 or 2   !!!");
			}

		}
		catch(Exception ex)
		{
			String errorCms="\n\n\t\t\t\t\t\t\t !!!  Invalid Entry. Enter an Integer  !!!";
			System.out.println(errorCms);
			ael.allErrorLogger(errorCms);
			ael.allExceptionLogger(ex);
		}
	}


}
