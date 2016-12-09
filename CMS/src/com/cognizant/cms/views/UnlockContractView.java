package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.dao.UnlockContractDao;

//author Aditi Sharma
//This class shows all the contracts waiting for unlocking approval of the Admin.

public class UnlockContractView
{
	public void unlockContractView(String userID)throws IOException, ClassNotFoundException, SQLException, InterruptedException, ParseException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");

		System.out.println("\n\t\t\t\t\t\t\t   List of Contracts waiting for Unlock Approval   ");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");

		UnlockContractDao ucd=new UnlockContractDao();
		ucd.unlockingContractDao(userID);

		System.out.print("\n\n\t\t   Enter the Contract ID you want to Unlock : ");
		String contract_unlock=sc.nextLine();
		ucd.unlockSelectedContract(contract_unlock,userID);
	}
}
