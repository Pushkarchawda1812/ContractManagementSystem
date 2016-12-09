package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import com.cognizant.cms.dao.AcknowledgementScreenDao;
import com.cognizant.cms.exception.AllExceptionLogger;

//author Ishan
// This class is used by Marketing Admin to check and edit the amenity status and provide remarks along with it.


public class AcknowledgementScreen
{
	public void printAcknowledgementScreen(String enterSupplierId) throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException
	{
		SupplierLoginView slv =new SupplierLoginView();
		AcknowledgementScreen acknowledgementscreen=new AcknowledgementScreen();
		AcknowledgementScreenDao acknowledgementscreendao=new AcknowledgementScreenDao();
		SupplierAcknowledgementScreen supplieracknowledgementscreen=new SupplierAcknowledgementScreen();
		AllExceptionLogger ael=new AllExceptionLogger();
		
		int enterChoice;
		Scanner s=new Scanner(System.in);
		try
		{
		do
		{
        int count=acknowledgementscreendao.acknowledgementScreenDao(enterSupplierId);
		if(count==0)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   No amenity is added by you   !!!");
		
		}
		
			System.out.println("\n\n\t\t   Please choose one of the following options");
			System.out.println("\n\t\t   1. Enter the Amenity ID to Check Amenity Status");
			System.out.println("\n\t\t   2. Go Back to Main Page");
			System.out.print("\n\t\t   Enter your choice : ");
			enterChoice=s.nextInt();
			s.nextLine();
			if(enterChoice==1)
			{
				supplieracknowledgementscreen.supplierAcknowledgementScreen(enterSupplierId); 
			}
			else if(enterChoice==2)
			{
				slv.supplierLoginView(enterSupplierId);
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!");
			}
		}while((enterChoice!=1)&&(enterChoice!=2));
	}
		catch(Exception ex6)
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   please enter correct choice   !!!");
			ael.allExceptionLogger(ex6);
			acknowledgementscreen.printAcknowledgementScreen(enterSupplierId);
			
		}
	}





}
