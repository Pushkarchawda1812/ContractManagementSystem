package com.cognizant.cms.process;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.dao.EditNextDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.ContractTO;
import com.cognizant.cms.views.ViewContractsView;

//author Shikha
//This class allows the Admin to Edit a chosen Contract


public class EditContractPeriodProcess 
{

	//Displays the Contract Details before Editing.
	public void contractedit(String userID, ArrayList<String> arradminid,ArrayList<String> arrcname,ArrayList<String> arrtype,ArrayList<StringTokenizer> arrstart,ArrayList<Integer> arryear,ArrayList<String> arrid,ArrayList<String> arrlock,ArrayList<String> arrstatus,String Contractid) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		AllExceptionLogger ael= new AllExceptionLogger();

		int flag=0;
		int count=0;
		int year=0;
		String lock_status=null;
		String contractStatus=null;
		int lockChoice=0;
		int contractChoice=0;

		EditNextDAO end=new EditNextDAO();
		Scanner sc=new Scanner(System.in);
		ContractManagementSystemDispatcher cmd=new ContractManagementSystemDispatcher();
		ViewContractsView vcv=new ViewContractsView();
		ContractTO cto=new ContractTO();
		String answer="yes";
		System.out.println("\n________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n","Admin ID","Contract Name","Contract Type","Start Date","Number of Years","Contract ID","Lock Status","Contract Status");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		for(int i=0;i<arrid.size();i++)
		{
			System.out.format("\n %-10s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n",arradminid.get(i),arrcname.get(i),arrtype.get(i),arrstart.get(i).nextToken(),
					arryear.get(i),arrid.get(i),arrlock.get(i),arrstatus.get(i));


		}


		while(answer.equalsIgnoreCase("yes"))
		{


			System.out.println("\n\n\n\t\t   Select an Option to Edit");
			System.out.println("\n\t\t   1. Press 1 to edit Number of Years");
			System.out.println("\n\t\t   2. Press 2 to edit Lock Status");
			System.out.println("\n\t\t   3. Press 3 to edit Contract Status");
			System.out.print("\n\n\t\t   Enter a choice between 1-3 : ");


			int choice=0;
			try{
				choice=sc.nextInt();
				sc.nextLine();
			}
			catch(Exception ex)
			{
				String errorCms="\n\n\t\t\t\t\t\t\t !!!   Invalid Entry. Enter an Integer   !!!";
				System.out.println(errorCms);
				ael.allErrorLogger(errorCms);
				vcv.contractview(userID);


			}
			switch(choice)
			{
			case 1: do
			{
				flag=0;
				try
				{
					do
					{
						Scanner sc1 = new Scanner(System.in);                    
						System.out.print("\n\t\t   Enter Number of years : ");
						year=sc1.nextInt();
						count=1;
						cto.setNumber_of_Years(year);
					}while(year<=0);
				}
				catch(Exception ex)
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   Must be a Number   !!! ");
					flag=1;
				}
				finally
				{
					if(flag==0)
						count=1;
					else
						count=0;
				}

			}while(count==0);
			cto.setNumber_of_Years(year);
			end.editnumberofyears(year, cto, Contractid);
			System.out.println("\n\n\t\t   Edited data is : "+cto.getNumber_of_Years());
			break;

			case 2: do
			{
				System.out.println("\n\t\t   Enter new Lock Status : ");
				System.out.println("\n\t\t   1. Lock ");
				System.out.println("\n\t\t   2. UnLock ");
				System.out.print("\n\n\t\t   Enter Your Choice : ");
				lockChoice=sc.nextInt();
				sc.nextLine();
				switch(lockChoice)
				{
				case 1: lock_status="Lock";
				break;

				case 2: lock_status="UnLock";
				break;

				default: System.out.println("\n\n\t\t\t\t\t\t\t !!!   Enter 1 or 2 Only   !!!");
				}
			}while((lockChoice!=1)&&(lockChoice!=2));     
			cto.setLock_Status(lock_status);
			end.editlockstatus(lock_status, cto, Contractid);
			System.out.println("\n\n\t\t   Edited data is : "+cto.getLock_Status());
			break;


			case 3: do
			{
				System.out.println("\n\t\t   Enter new Contract Status");
				System.out.println("\n\t\t   1. Pending ");
				System.out.println("\n\t\t   2. Approved ");
				System.out.println("\n\t\t   3. Expired ");
				System.out.print("\n\n\t\t   Enter Your Choice : ");
				contractChoice=sc.nextInt();
				sc.nextLine();
				switch(contractChoice)
				{
				case 1: contractStatus="Pending";
				break;

				case 2: contractStatus="Approved";
				break;

				case 3: contractStatus="Expired";
				break;

				default: System.out.println("\n\t\t\t\t\t\t\t !!!   Enter Between 1-3 Only   !!!");
				}
			}while((contractChoice!=1)&&(contractChoice!=2)&&(contractChoice!=3));
			cto.setContract_Status(contractStatus);
			end.editcontractstatus(contractStatus, cto, Contractid);
			System.out.println("\n\n\t\t   Edited data is : "+cto.getContract_Status());
			break;

			default: System.out.print("\n\n\t\t\t\t\t\t\t !!!   Invalid Entry   !!!");
			vcv.contractview(userID);


			}
			do
			{
				do
				{
					System.out.print("\n\t\t   Do you wish to Edit More Data (yes/no) ? : ");
					answer=sc.nextLine();
				}while(answer.equalsIgnoreCase("yes")==false&&answer.equalsIgnoreCase("no")==false);
			}while(answer.equalsIgnoreCase("no")==false&&answer.equalsIgnoreCase("yes")==false);
		}

		if(answer.equalsIgnoreCase("no"))
		{
			cmd.dispatchActionCreateContract(userID);
		}
		/*	else
		{
			cmd.dispatchActionCreateContract(userID);
		}*/


	}


}

