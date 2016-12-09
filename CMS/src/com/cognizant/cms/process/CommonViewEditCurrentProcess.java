package com.cognizant.cms.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.dao.CommonViewEditNextPeriodDAO;
import com.cognizant.cms.dao.EditNextDAO;
import com.cognizant.cms.dao.ViewNextDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.MarketingAdminFirstView;
import com.cognizant.cms.views.SettingAmenitiesView;
import com.cognizant.cms.views.TermAndConditionView;
import com.cognizant.cms.views.ViewContractsView;


//author Shikha
//This Class performs operation common to both viewing and editing contracts of Current Period Category.


public class CommonViewEditCurrentProcess extends TermAndConditionView
{
	String contractid=null;
	int x=0;

	ViewNextDAO vnd=new ViewNextDAO();
	EditNextDAO end=new EditNextDAO();
	SettingAmenitiesView sav= new SettingAmenitiesView();
	CommonViewEditNextPeriodDAO cvdo=new CommonViewEditNextPeriodDAO();
	ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
	ViewContractsView vcv=new ViewContractsView();
	MarketingAdminFirstView mafv=new MarketingAdminFirstView();

	//This method shows all the contracts of Current Period Category with Startdate,Enddate and ContractID.
	public void contractview(String userID, ArrayList<String> arrname, ArrayList<String> arrid, ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{

		Scanner sc=new Scanner(System.in);

		System.out.println("\n\n\t\t\t\t\t\t\t!!!    List of Contracts in this category are    !!!");
		System.out.println("\n___________________________________________________________________________________________________________________________________________________________________");
		System.out.format("                   %-60s %-60s\n","Contract Name(Start Year-End Year)","Contract ID");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");

		for(int i=0;i<arrid.size();i++)
		{
			String startdate=arrstart.get(i).nextToken();
			int enddate=Integer.parseInt(startdate.toString())+arryear.get(i);

			System.out.format("\n                   %-60s %-60s\n",arrname.get(i)+" ("+startdate+"-"+enddate+")",arrid.get(i));



		}
		System.out.print("\n\n\t\t   Enter contract ID from the list : ");
		contractid=sc.nextLine();

		Boolean b=cvdo.contractidvoilation(contractid);
		if(b==true)
		{
			System.out.println("\n\t\t   1. View Contract");
			System.out.println("\n\t\t   2. Edit Contract");
			System.out.print("\n\n\t\t   Enter Choice between 1-2 : ");
			int choice=0;
			try
			{
				choice=sc.nextInt();	
			}
			catch(Exception ex)
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter an Integer   !!!");
				vcv.contractview(userID);
			}
			switch(choice)
			{
			case 1: vnd.nextperiodviewdao(contractid);
			break;
			case 2: termAndConditionView(userID, null);
			break;
			default:System.out.println("\n\t\t\t\t\t\t\t !!!   Invalid Entry   !!!");
			System.out.println("\n\t\t   Enter an Integer : ");
			vcv.contractview(userID);
			}
		}

		else
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Search Found No Relevant Results   !!!");
			Thread.sleep(200);
			cmd.dispatchActionCreateContract(userID);
		}
	}
	//This method displays all the details of the selected Contract on the basis of ContractID.
	public void show(String contractID, String userID, ArrayList<String> arradminid,ArrayList<String> arrcname,ArrayList<String> arrtype,ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear,ArrayList<String> arrid,ArrayList<String> arrlock,ArrayList<String> arrstatus)
	{
		Scanner sc= new Scanner(System.in);
		AllExceptionLogger ael=new AllExceptionLogger();

		System.out.println("\n___________________________________________________________________________________________________________________________________________________________________");
		System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n","Admin ID","Contract Name","Contract Type","Start Date","Number of Years","Contract ID","Lock Status","Contract Status");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");

		for(int i=0;i<arrid.size();i++)
		{
			System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n",arradminid.get(i),arrcname.get(i),arrtype.get(i),arrstart.get(i).nextToken(),
					arryear.get(i),arrid.get(i),arrlock.get(i),arrstatus.get(i));

		}

		System.out.println("\n\n\n\t\t   1. Enter to select another contract type");
		System.out.println("\n\t\t   2. Go back to previous menu ");
		try
		{
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: vcv.contractview(userID);
			break;
			case 2: cmd.dispatchActionCreateContract( userID);
			break;
			default:System.out.println("\n\n\t\t\t\t\t\t\t !!!   Enter choice between 1 or 2   !!!");
			}

		}
		catch(Exception ex)
		{
			String errorCms="\n\t\t\t\t\t\t\t !!!   Oops!! Something Wrong While Editing Contract ";
			System.out.println(errorCms);
			ael.allErrorLogger(errorCms);
			ael.allExceptionLogger(ex);
		}


	}
	//This method displays Terms and Conditions before giving the Editing Rights of the Contract to the Admin.
	@Override
	public void termAndConditionView(String userID, String contractID) 
	{

		AllExceptionLogger ael= new AllExceptionLogger();
		String  fileName="Amenity.txt";      
		String line = null;
		try
		{
			FileReader fileReader = 
				new FileReader(fileName);   
			BufferedReader bufferedReader = 
				new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			} 
			bufferedReader.close();
			termAndConditionEditView(userID, contractID);
		}
		catch(Exception ex)
		{
			ael.allExceptionLogger(ex);
		}

	}



	@Override
	public void termAndConditionEditView(String userID, String contractID) 
	{
		int x=0;

		AllExceptionLogger ael= new AllExceptionLogger();
		Scanner sc= new Scanner(System.in);
		System.out.println("\n\n\t\t   1.ACCEPT");
		System.out.println("\n\t\t   2.DENY");
		do
		{
			System.out.print("\n\n\t\t   Enter Choice : ");
			x=sc.nextInt();
			sc.nextLine();
			if(x==1)
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   Access Granted   !!!");
				try {
					end.nextperiodeditdao(userID, contractid);
				} catch (Exception e) {
					System.out.println("\n\t\t\t\t\t\t\t !!!   Something Went Wrong   !!!");
					ael.allExceptionLogger(e);
				} 
			}
			else if(x==2)
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   No changes can be made   !!!");

				try
				{
					vcv.contractview(userID);
				}
				catch(Exception ex)
				{
					ael.allExceptionLogger(ex);
				}
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   Please Press 1 or 2 only   !!!");
			}
		}while((x!=1)&&(x!=2));

	}

}
