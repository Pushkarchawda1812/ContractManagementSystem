package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.views.AdminLoginView;
import com.cognizant.cms.views.UnlockContractView;


//author Aditi Sharma
//This class is used by Marketing Admin to unlock the Contracts being sent by the Supplier for adding Amenities.


public class UnlockContractDao 
{
	public void unlockingContractDao(String userID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		Scanner sc= new Scanner(System.in);
		Connection connection =GetConnectionDao.getConnectionDao();
		PreparedStatement displayContractMA = connection.prepareStatement(QueryConstant.displayContractMA);
		AdminLoginView alv= new AdminLoginView();


		ResultSet rs =displayContractMA.executeQuery();

		System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");	
		System.out.println();
		System.out.format("                     %-30s %-25s %-20s\n","Supplier_ID","Contract_ID","Contract_Name");
		System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		if(rs.next())
		{
			rs =displayContractMA.executeQuery();
			while (rs.next())
			{
				String Supplier_ID=rs.getString("Supplier_ID");
				String Contract_ID=rs.getString("Contract_ID");
				String Contract_Name=rs.getString("Contract_Name");

				System.out.println();
				System.out.format("\n                     %-30s %-25s %-20s\n",Supplier_ID,Contract_ID,Contract_Name);
			}
		}
		else
		{
			System.out.println("\n\n\t\t\t\t\t\t\t !!!   No Contract Exist  !!! ");
			System.out.println("\n\n\t\t   Press Enter to go back ");
			sc.nextLine();
			alv.adminLoginView(userID);
		}
		rs.close();
		connection.close(); 
	}


	/*This method is used to Unlock a particular Contract selected by the Admin 
	  and then updating the database by deleting the particular Contracts being Unlocked by the Admin*/


	public void unlockSelectedContract(String contract_unlock, String userID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		UnlockContractView ucv= new UnlockContractView();

		Connection connection = GetConnectionDao.getConnectionDao();
		
		
		PreparedStatement updateContract_Lock = connection.prepareStatement(QueryConstant.updateLock);
		updateContract_Lock.setString(1,contract_unlock);

		PreparedStatement deleteUpdateContract_Lock = connection.prepareStatement(QueryConstant.deleteUpdateLock);
		deleteUpdateContract_Lock.setString(1,contract_unlock);

		try
		{
			ResultSet rsUpdate =updateContract_Lock.executeQuery();
			rsUpdate.next();
			ResultSet rsDelete =deleteUpdateContract_Lock.executeQuery();
			System.out.println("\n\t\t\t\t\t\t\t !!!   Contract Unlocked Successfully   !!!");
			rsUpdate.close();
			rsDelete.close();

		}
		catch(Exception ex)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Select a Valid Contract ID    !!!");
			ucv.unlockContractView(userID);
		}

		connection.close(); 



	}
}
