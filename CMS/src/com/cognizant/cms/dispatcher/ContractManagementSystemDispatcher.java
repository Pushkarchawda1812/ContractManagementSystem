package com.cognizant.cms.dispatcher;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.views.AcknowledgementScreen;
import com.cognizant.cms.views.AdminLoginView;
import com.cognizant.cms.views.AmenityRequestStatus;
import com.cognizant.cms.views.CreateContractView;
import com.cognizant.cms.views.FrontPageView;
import com.cognizant.cms.views.LockContractView;
import com.cognizant.cms.views.LoginView;
import com.cognizant.cms.views.MarketingAdminFirstView;
import com.cognizant.cms.views.NewAdminRegisterForm;
import com.cognizant.cms.views.NewSupplierRegisterForm;
import com.cognizant.cms.views.UnlockContract;
import com.cognizant.cms.views.ViewContractsView;


public class ContractManagementSystemDispatcher 
{
	public void dispatchAction() throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException 
	{
		
		FrontPageView fpv=new FrontPageView();
		LoginView lv=new LoginView();
		NewAdminRegisterForm narf= new NewAdminRegisterForm();
		AllExceptionLogger ael= new AllExceptionLogger();
		NewSupplierRegisterForm nsrf= new NewSupplierRegisterForm();
		
	    System.out.println("\n____________________________________________________________________________________________________________________________________________________________________________________________________________________________");
	    System.out.println();
		System.out.println("\t\t\t\t\t\t\t     WELCOME TO CONTRACT MANAGEMENT SYSTEM ");
		System.out.println("______________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		
		try
		{
			int choice=fpv.frontPageView();
			switch(choice)
			{
			case 1: lv.loginView();
					break;
				
			case 2: narf.newAdminRegisterForm();
					break;
				
			case 3: nsrf.newSupplierRegisterForm();
					break;
					
			case 4: Thread.sleep(200);
					System.out.println("\n\n\n\t\t\t\t\t\t\t\t!!! HAVE A GOOD DAY !!! ");
			 		Thread.sleep(1000);
					System.exit(0);
					
			default:fpv.frontPageView();
			
			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t Enter number between 1 to 4 ");
			ael.allExceptionLogger(ex);
		}
		
		
	}
	
	public void dispatchActionCreateContract( String userID) throws IOException, ClassNotFoundException, SQLException, ParseException, InterruptedException 
	{
		
		MarketingAdminFirstView mafv=new MarketingAdminFirstView();
		AdminLoginView  alv= new AdminLoginView();
		AllExceptionLogger ael= new AllExceptionLogger();
		CreateContractView ccv=new CreateContractView();
		ViewContractsView vcv=new ViewContractsView();
		ContractManagementSystemDispatcher cmsd= new ContractManagementSystemDispatcher();
		
		int choice=0;
		
		try
		{
			choice=mafv.MAfrontPageView(userID);
			switch(choice)
			{
				case 1: ccv.ContractCreationProcess( userID);
						break;
				
				case 2: vcv.contractview(userID);
						break;
					
				case 3: alv.adminLoginView( userID);
					
				default:System.out.println("\n\n\t\t\t Wrong Choice Entered. Enter Your Choice(1-3)");
				mafv.MAfrontPageView(userID);

			}
		}
		catch(Exception ex)
		{
			System.out.println("\n\n\t\t\t\t Enter number between 1 to 4 ");
			ael.allExceptionLogger(ex);
			cmsd.dispatchActionCreateContract(userID);
		}
		
		
	}
	
	public void dispatchLock(String contractID) throws IOException, ClassNotFoundException, SQLException 
	{
		
           LockContractView lockcontractview=new LockContractView();
           lockcontractview.getLockContract(contractID);
	}
	public void dispatchUnlock(String contractID) throws IOException, ClassNotFoundException, SQLException 
	{
	
           UnlockContract unlockcontractview=new UnlockContract();
           unlockcontractview.unlockContractView(contractID);
                 
	}	
	public void dispatchAmenityRequestStatus(String userID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException 
	{
		AmenityRequestStatus amenityrequeststatus=new AmenityRequestStatus();
		amenityrequeststatus.amenityRequestStatus(userID);
         
                 
	}	
	public void dispatchAcknowledgementScreen(String userID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException 
	{
		AcknowledgementScreen acknowledgementscreen=new AcknowledgementScreen();
		acknowledgementscreen.printAcknowledgementScreen(userID);
                 
	}
}
