package com.cognizant.cms.views;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.bo.ContractTypeBO;
import com.cognizant.cms.bo.StartDateValidationBO;
import com.cognizant.cms.dao.CreateContractDAO;
import com.cognizant.cms.dao.ViewNextDAO;
import com.cognizant.cms.dispatcher.ContractManagementSystemDispatcher;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.ContractTO;
import com.cognizant.cms.process.CreateContractValidationProcess;

//author Shikha
/**
 * CreateContractView serves as a view which can be called from the dispatcher to invoke
 * the Create Contract Process by Marketing Admin.
 */


public class CreateContractView extends TermAndConditionView
{
	int x=0;
	String contract=null;

	ContractTO cto=new ContractTO();
	StartDateValidationBO sdv=new StartDateValidationBO();
	CreateContractValidationProcess ccv=new CreateContractValidationProcess();
	CreateContractDAO ccd=new CreateContractDAO();
	ContractTypeBO ct=new ContractTypeBO();
	ViewNextDAO vcd=new ViewNextDAO();
	ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();


	public void ContractCreationProcess( String userID) throws ClassNotFoundException, SQLException, IOException, ParseException, InterruptedException
	{
		int count=0;
		int Year=0;
		int flag=0;

		Scanner sc=new Scanner(System.in);
		String Contractname=null;
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		System.out.println("\n\t\t\t\t\t\t\t\t ||| CREATE CONTRACT SCREEN  |||");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");


		System.out.print("\n\t\t   Enter User ID : ");
		cto.setUserId(userID);
		System.out.println(userID);

		System.out.print("\n\t\t   Enter Contract Name (Must be minimum 5 characters) : ");
		Contractname=sc.nextLine();
		while(Contractname.length()<5)
		{
			System.out.println("\n\n\t\t\t\t\t\t !!!   Entered Name Must be minimum 5 characters   !!! ");
			System.out.print("\n\n\t\t   Enter Contract Name (Must be minimum 5 characters) : ");
			Contractname=sc.nextLine();

		}
		cto.setContract_Name(Contractname);

		System.out.print("\n\t\t   Enter Start Date(yyyy) : ");
		String Startdate=sc.nextLine();	
		while(sdv.datevalidation(Startdate)==false)
		{
			System.out.println("\n\n\t\t\t\t\t\t !!!   Entered date should be either current date or next years date   !!! ");

			System.out.print("\n\t\t   Enter Start Date(yyyy) : ");
			Startdate=sc.nextLine();	
		}
		cto.setStart_Date(Startdate);


		int type=ct.contracttype(Startdate);
		cto.setType_of_Contract(type);

		do
		{
			flag=0;
			try
			{
				do
				{
				Scanner sc1 = new Scanner(System.in);                    
				System.out.print("\n\t\t   Enter Number of years : ");
				Year=sc1.nextInt();
				count=1;
				cto.setNumber_of_Years(Year);
				}while(Year<=0);
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

		ccv.createContractID(cto);

		System.out.print("\n\n\t\t   Enter 1 to Submit : ");
		int choice=sc.nextInt();
		sc.nextLine();
		while(choice!=1)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   Wrong Key Pressed.Please Press 1 to Submit   !!! ");
			choice=sc.nextInt();
			sc.nextLine();
		}

		termAndConditionView(userID, contract);

	}

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
				System.out.println("\n\n\t\t\t\t\t\t\t\t !!!   Access Granted   !!!");
				try {
					ccd.CreateContract(userID, cto);
				} catch (Exception ex) 
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   Something Went Wrong   !!!");
					ael.allExceptionLogger(ex);
				} 
			}
			else if(x==2)
			{
				System.out.println("\n\t\t\t\t\t\t\t !!!   No changes can be made   !!!");	        	
				try
				{
					cmsd.dispatchActionCreateContract(userID);
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


