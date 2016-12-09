package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.util.GetConnectionDao;
import com.cognizant.cms.views.SettingAmenitiesView;
import com.cognizant.cms.views.SupplierLoginView;


//author Aditi Sharma
//This class is used to display all the Contracts present in the system and selecting a particular Contract for adding Amenities.


public class SelectContractDao
{
	public void selectContractListDao() throws IOException, ClassNotFoundException, SQLException
	{
		Connection connection =GetConnectionDao.getConnectionDao();
		PreparedStatement selectContract = connection.prepareStatement(QueryConstant.selectingContract);

		ResultSet rs =selectContract.executeQuery();

		System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");	
		System.out.println();
		System.out.format("                   %-30s %-25s %-60s %-40s\n","Contract_ID","Contract_Name","Contract_Status","Type_of_Contract");
		System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");

		while (rs.next())
		{
			String Contract_ID=rs.getString("Contract_ID");
			String Contract_Name=rs.getString("Contract_Name");
			String Contract_Status=rs.getString("Contract_Status");
			String Type_of_Contract=rs.getString("Type_of_Contract");

			System.out.println();
			System.out.format("\n                   %-30s %-25s %-60s %-40s\n",Contract_ID,Contract_Name,Contract_Status,Type_of_Contract);
		}
		rs.close();
		connection.close();
	}


	//This method is used to select a Contract before adding Amenities.


	public void selectedContractDao( String userID, String contractID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		Scanner sc=new Scanner(System.in);
		AllExceptionLogger ael= new AllExceptionLogger();
		SupplierLoginView slv= new SupplierLoginView();
		SettingAmenitiesView sav=new SettingAmenitiesView();

		Connection connection = GetConnectionDao.getConnectionDao();

		SelectContractDao scd=new SelectContractDao();

		PreparedStatement contractSelected = connection.prepareStatement(QueryConstant.displayingContract);	
		contractSelected.setString(1,contractID);

		PreparedStatement updateStatus = connection.prepareStatement(QueryConstant.updateStatus);
		updateStatus.setString(1,contractID);


		PreparedStatement updatedStatus = connection.prepareStatement(QueryConstant.displayUpadtedContract);
		updatedStatus.setString(1, contractID);

		ResultSet rs =contractSelected.executeQuery();

		while(rs.next())
		{
			if(rs.getString("Contract_Status").equalsIgnoreCase("Pending") && (rs.getString("Type_of_Contract").equalsIgnoreCase("Current Period") || rs.getString("Type_of_Contract").equalsIgnoreCase("Next Period")))
			{
				if(rs.getString("Lock_Status").equalsIgnoreCase("Lock"))
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Unlock the Contract before editing   !!!");
					System.out.print("\n\n\t\t   Press 1 to unlock the Contract : ");
					int unlock=sc.nextInt();
					sc.nextLine();

					switch(unlock)
					{
					case 1: PreparedStatement unlockContract = connection.prepareStatement(QueryConstant.unlockingContract);			
					unlockContract.setString(1, userID);
					unlockContract.setString(2, contractID);

					@SuppressWarnings("unused")
					ResultSet uc=unlockContract.executeQuery();

					System.out.println("\n\n\t\t\t\t\t\t\t !!!   Your request is sent for unlocking   !!!");
					System.out.println("\n\t\t\t\t\t\t\t !!!   Wait till Market Admin Unlock it   !!!");
					slv.supplierLoginView(userID);
					break;

					default: System.out.println("\n\t\t\t\t\t\t\t !!!   Wrong Input   !!!"); 
					scd.selectedContractDao( userID, contractID);
					break;
					}	
				}

				else
				{

					@SuppressWarnings("unused")
					ResultSet rs1 =updateStatus.executeQuery();
					ResultSet rs2 =updatedStatus.executeQuery();

					while(rs2.next())
					{
						String Admin_ID=rs2.getString("Admin_ID");
						String Admin_Name=rs.getString("Admin_Name");
						String Contract_Name=rs2.getString("Contract_Name");
						String Type_of_Contract=rs2.getString("Type_of_Contract");
						String Start_Date=rs2.getString("Start_Date");
						int Number_of_Years=rs2.getInt("Number_of_Years");
						String Contract_ID=rs2.getString("Contract_ID");
						String Lock_Status=rs2.getString("Lock_Status");
						String Contract_Status=rs2.getString("Contract_Status");

						StringTokenizer st=new StringTokenizer(Start_Date,"-");
						String year=st.nextToken();

						int n1=Integer.parseInt(year);

						int final_year=n1+Number_of_Years;
						String.valueOf(final_year);

						StringBuffer sb=new StringBuffer();
						sb.append(year).append("-").append(final_year);


						System.out.println("\n\n__________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
						System.out.println();
						System.out.format(" %-10s %-15s %-15s %-20s %-20s %-20s %-20s %-15s %-40s %-40s\n","Admin_ID","Admin_Name","Contract_Name","Type_of_Contract","Start_Date","Number_of_Years","Contract_ID","Lock_Status","Contract_Status","End_Date");
						System.out.println();
						System.out.println();
						System.out.format(" %-10s %-15s %-15s %-20s %-20s %-20s %-20s %-15s %-40s %-40s\n",Admin_ID,Admin_Name,Contract_Name,Type_of_Contract,rs2.getDate("Start_Date"),Number_of_Years,Contract_ID,Lock_Status,Contract_Status,sb);
						System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________________________________");

						rs2.close();
						sav.setAmenity(userID,contractID);
					}
				}
			}

			else
			{
				System.out.print("\n\t\t   Contracts with Pending Status and are of Current Period/Next Period can only be edited.");
				System.out.print("\n\n\t\t   1. Enter to edit any other Contract ");
				System.out.print("\n\n\t\t   2. Enter to go back to previous menu");				
				System.out.print("\n\n\t\t      Enter your Choice : ");
				try
				{
					int choice=sc.nextInt();
					sc.nextLine();
					if(choice==1)
					{
						scd.selectContractListDao();
						System.out.println();
						System.out.print("\n\t\t   Enter the contract name you want to edit : ");
						contractID=sc.nextLine();
						scd.selectedContractDao(userID ,contractID);		
					}

					else
					{
						slv.supplierLoginView(userID); 
					}	
				}
				catch(Exception ex)
				{
					System.out.println("\n\n\t\t\t\t\t\t\t !!!   You have made a Wrong Choice   !!!");
					System.out.println("\n\t\t\t\t\t\t\t !!!   please select the contract again   !!!");

					ael.allExceptionLogger(ex);

				}

			}
		}

		rs =contractSelected.executeQuery();

		if(!rs.next())
		{
			System.out.print("\n\n\t\t   Enter the correct name : ");
			contractID=sc.nextLine();
			scd.selectedContractDao(userID, contractID);
		}

		connection.close(); 
	}
}
