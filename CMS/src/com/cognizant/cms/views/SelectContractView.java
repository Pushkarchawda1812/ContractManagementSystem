package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dao.SelectContractDao;

//author Aditi Sharma
//This class is used to view all the contracts by a Supplier when he logs in.


public class SelectContractView 
{
	public void selectContractView(String userID) throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		Scanner sc=new Scanner(System.in);

		SelectContractDao scd=new SelectContractDao();

		System.out.println("\n\n\t\t\t\t\t\t\t !!!   You are viewing all the Contracts now   !!!");
		System.out.println();

		scd.selectContractListDao();

		System.out.print("\n\n\t\t   Enter the contract ID you want to edit : ");
		String ContractID=sc.nextLine();

		scd.selectedContractDao( userID, ContractID);



	}
}
