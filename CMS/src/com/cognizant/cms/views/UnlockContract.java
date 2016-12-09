package com.cognizant.cms.views;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import com.cognizant.cms.dao.UnlockContractViewDao;
import com.cognizant.cms.process.UnlockContractViewProcess;

public class UnlockContract
{
   public void unlockContractView(String contractID)throws ClassNotFoundException, SQLException, IOException
   {
	   UnlockContractViewProcess unlockcontractviewbo=new UnlockContractViewProcess();
	   UnlockContractViewDao unlockcontractviewdao=new UnlockContractViewDao();
	   Scanner s=new Scanner(System.in);
	   
	   int number;
	   System.out.println("\n\n\t\t\t\t\t\t\t !!!   Before Submitting the Contract Please Unlock the Contract   !!!");
         do
	       {
		   System.out.println("	\n\n\t\t   To Unlock the Contract Enter 1");
		   System.out.print("\n\n\t\t   Enter the number : ");
		   number=s.nextInt();
		   s.nextLine();
	       
	       boolean b=unlockcontractviewbo.unlockContractValidate(number);
	       if(b==true)
	       {	   
	    	   unlockcontractviewdao.unlockContractViewDao(contractID);
	       }
	       else
	       {
	    	   System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Enter the Correct Number   !!!");
	       }
	   }while(number!=1);
	   System.out.println("\n\n\t\t\t\t\t\t\t !!!   Contract succesfully Unlocked   !!!");
   }

}
