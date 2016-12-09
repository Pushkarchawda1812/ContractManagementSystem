package com.cognizant.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.cognizant.cms.dispatcher.*;
import com.cognizant.cms.exception.AllExceptionLogger;

public class ContractManagementSystemController {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
	
	public static void main(String[] args)  
	{	
		ContractManagementSystemDispatcher cmsd=new ContractManagementSystemDispatcher();
		AllExceptionLogger ael= new AllExceptionLogger();
		Scanner sc=new Scanner(System.in);
		
		boolean action=true;
		if(action)
		{
			try 
			{				
				cmsd.dispatchAction();
			} 
			catch (Exception ex) 
			{
				System.out.println("\n\n\t\t\t\tOpps !! Something went Wrong.... ");			
				ael.allExceptionLogger(ex);
				System.out.println("\n\n\t\t\t\t 1. Enter to Start Again...");
				System.out.println("\n\n\t\t\t\t 2. Exit");
				try
				{
					System.out.print("\n\t\t\t\t Enter your choice : ");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1: cmsd.dispatchAction();
							break;
							
					case 2: System.exit(0);
							break;
							
					default:System.out.println("\n\n\t\t\t\t Please Enter 1 or 2 Only...");
					}
				}
				catch(Exception ex1)
				{
					System.out.println("\n\n\t\t\t\tOpps !! Something went Wrong.... ");			
					ael.allExceptionLogger(ex1);
					System.out.println("\n\n\t\t\t\t 1. Enter to Start Again...");
					System.out.println("\n\n\t\t\t\t 2. Exit");
					try
					{
						System.out.print("\n\t\t\t\t Enter your choice : ");
						int choice=sc.nextInt();
						switch(choice)
						{
						case 1: cmsd.dispatchAction();
								break;
								
						case 2: System.exit(0);
								break;
								
						default:System.out.println("\n\n\t\t\t\t Please Enter 1 or 2 Only...");
						}
					}
					catch(Exception ex2)
					{
						System.out.println("\n\n\t\t\t\t Opps !! Something went Wrong....the Program will Exit Now ");			
						ael.allExceptionLogger(ex2);
						System.out.println("\n\n\t\t\t\t 1. Enter to Start Again...");
						System.out.println("\n\n\t\t\t\t 2. Exit");
					}
				}
			} 
		}
	}

}
