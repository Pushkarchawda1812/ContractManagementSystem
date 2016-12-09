package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dao.CommonViewEditCurrentPeriodDAO;
import com.cognizant.cms.dao.CommonViewEditNextPeriodDAO;
import com.cognizant.cms.dao.ViewLastDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;

//author Shikha
//This class asks the user to select the category of contracts he wants to view.


public class ViewContractsView 
{

	public void contractview(String userID) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		Scanner sc=new Scanner(System.in);

		CommonViewEditNextPeriodDAO vcdo=new CommonViewEditNextPeriodDAO();
		CommonViewEditCurrentPeriodDAO cvedo=new CommonViewEditCurrentPeriodDAO();
		ViewLastDAO vld=new ViewLastDAO();
		ContractManagementSystemDispatcher cmsd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();

		System.out.println("\n\n\t\t   Contracts Present in the system are:");
		System.out.println("\n\n\t\t   1. Next Period Contracts (Start Year Date is of Future.)");	
		System.out.println("\n\t\t   2. Current Period Contracts (Start Year Date is of Present.) ");
		System.out.println("\n\t\t   3. Last Period Contracts (Start Year Date is of Past.)");
		System.out.println("\n\t\t   4. Go back to Previous Menu");
		System.out.print("\n\n\t\t      Enter Choice between 1-3 : ");
		int choice=0;
		try
		{
			choice=sc.nextInt();
		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter a valid choice   !!!");
			vcv.contractview(userID);
		}

		switch(choice)
		{
		case 1: vcdo.viewnextperiodcontractdao(userID);
				break;
		case 2: cvedo.viewcurrentperiodcontractdao(userID);
				break;
		case 3: vld.viewlastperiodcontractdao( userID);
				break;
		case 4: cmsd.dispatchActionCreateContract(userID);
				break;
		default:System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter a valid choice   !!!");
				System.out.println("\n\t\t   Enter Choice between 1-3 : ");
				vcv.contractview(userID);

		}
	}



}



