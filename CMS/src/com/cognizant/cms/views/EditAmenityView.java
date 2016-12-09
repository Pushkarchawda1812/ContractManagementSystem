package com.cognizant.cms.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.cognizant.cms.dao.EditAmenityDao;

//author
//This class is for chosing the Amenity you want to edit.

public class EditAmenityView 
{
	public static void editSelectedAmenity() throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		EditAmenityDao eao= new EditAmenityDao();

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the Amenity ID you want to edit");
		String Amenity_ID=sc.nextLine();

		System.out.println("Enter the new Amenity Description");
		String newAmenity_Description=sc.nextLine();

		eao.editSelectedAmenityDao(Amenity_ID,newAmenity_Description);
	}
}
