package com.cognizant.cms.process;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.dao.CommonViewEditNextPeriodDAO;
import com.cognizant.cms.dao.ViewNextDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.ViewContractsView;


public class NextPeriodProcess 
{
	public void contractview(String userID, ArrayList<String> arrname, ArrayList<String> arrid, ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		ViewNextDAO vcd=new ViewNextDAO();
		CommonViewEditNextPeriodDAO cvdo=new CommonViewEditNextPeriodDAO();
		Scanner sc=new Scanner(System.in);
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();
		
		
		System.out.print("\n\n\t\t   Enter contract ID from the list : ");
		String contractid=sc.nextLine();
		
		Boolean b=cvdo.contractidvoilation(contractid);
		if(b==true)
		{
		System.out.println("\n\t\t   1. View Contract");
		System.out.println("\n\t\t   2. Edit Contract");
		System.out.print("\n\n\t\t   Enter Choice between 1-2 : ");
		
		int choice=0;
		try{
			choice=sc.nextInt();	
		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter an Integer   !!!");
			vcv.contractview(userID);
			
			
		}
		switch(choice)
		{
		case 1: vcd.nextperiodviewdao(contractid);
				break;
		case 2: 
				break;
		default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Invalid Entry.   !!!");
			vcv.contractview(userID);
		}
		}
		else
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Search Found No Relevant Results   !!!");
			cmd.dispatchActionCreateContract(userID);
			
		}
	}
	public void nextshow(String userID, ArrayList<String> arradminid,ArrayList<String> arrcname,ArrayList<String> arrtype,ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear,ArrayList<String> arrid,ArrayList<String> arrlock,ArrayList<String> arrstatus)
	{
		
		Scanner sc=new Scanner(System.in);
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();
		AllExceptionLogger ael= new AllExceptionLogger();
		
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
		System.out.print("\n\n\t\t   Enter Your Choice : ");
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
			ael.allExceptionLogger(ex);
		}
	}
}
