package com.cognizant.cms.views;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.cognizant.cms.bo.AgeCalculationBO;
import com.cognizant.cms.bo.DateofBirthValidation;
import com.cognizant.cms.bo.EmailValidation;
import com.cognizant.cms.dao.CitiesDao;
import com.cognizant.cms.dao.CountriesDao;
import com.cognizant.cms.exception.AllExceptionLogger;
import com.cognizant.cms.model.RegisterUserTO;

//author Pushkar
//This class is inherited by AdminRegisterview and SupplierRegisterview.

public class RegisterUser 
{
	public int registerUser() throws ClassNotFoundException, SQLException, ParseException
	{
		Scanner sc=new Scanner(System.in);
		int count=0;
		String cityCode=null;
		AllExceptionLogger ael=new AllExceptionLogger();
		DateofBirthValidation dbv= new DateofBirthValidation();
		AgeCalculationBO acbo=new AgeCalculationBO();
		EmailValidation ev= new EmailValidation();
		CitiesDao cid= new CitiesDao();
		CountriesDao cd= new CountriesDao();



		System.out.print("\n\t\t   *Enter Password : ");
		String password=sc.nextLine();
		while(password.length()<6)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Length of Password Should be Greater than 6   !!! ");
			System.out.print("\n\t\t   *Enter Password : ");
			password=sc.nextLine();		
		}
		RegisterUserTO.setPassword(password);

		System.out.print("\n\t\t   *Re-type Password : ");
		String reTypePassword=sc.nextLine();		
		while(RegisterUserTO.getPassword().equals(reTypePassword)==false)
		{
			System.out.println("\n\t\t\t\t\t\t\t !!!   Password Don't Match   !!!");
			System.out.print("\n\t\t   *Re-type Password : ");
			reTypePassword=sc.nextLine();

		}
		RegisterUserTO.setReTypePassword(reTypePassword);
		System.out.print("\n\t\t   *Enter Date of Birth (YYYY-MM-DD): ");
		String dateOfBirth="1";
		dateOfBirth=sc.nextLine();
		while(!dbv.dateofbirthvalidation(dateOfBirth))
		{
			System.out.print("\n\n\t\t\t\t\t\t\t !!!   Please Enter Valid Date of Birth   !!! ");
			System.out.print("\n\n\t\t   *Enter Date of Birth (YYYY-MM-DD): ");
			dateOfBirth=sc.nextLine();
		}
		RegisterUserTO.setDateOfBirth(dateOfBirth);
		System.out.print("\n\t\t   *Enter Email Address : ");
		String emailAddress=sc.nextLine();
		while(ev.emailvalidation(emailAddress)==false)
		{
			System.out.print("\n\n\t\t\t\t\t\t\t !!!   Please Enter Valid Email Address   !!! ");
			System.out.print("\n\n\t\t   *Enter Email Address : ");
			emailAddress=sc.nextLine();
		}
		RegisterUserTO.setEmailAddress(emailAddress);
		try
		{
			System.out.print("\n\t\t   *Enter Contact Number : ");
			long contact=sc.nextLong();
			long contactCopy=contact;
			sc.nextLine();

			do
			{
				count=0;
				while(contactCopy!=0)
				{
					contactCopy=contactCopy/10;
					count++;
				}

				if(count<10||count>10)
				{
					System.out.println("\n\t\t\t\t\t\t\t !!!   Contact must be of 10 character   !!! ");
					System.out.print("\n\t\t   *Enter Valid Contact Number : ");
					contact=sc.nextLong();
					sc.nextLine();
					RegisterUserTO.setContact(contact);
				}
				else
				{
					RegisterUserTO.setContact(contact);
				}}while(count!=10 && contact<=0);
		}
		catch(Exception ex3)
		{
			ael.allExceptionLogger(ex3);
			System.out.println("\n\t\t\t\t\t\t\t !!!   Contact must be of 10 character   !!! ");
			//System.out.println("\n\n\t\t\t\t\t\t\t !!!   Please Again Enter All Details   !!!" );

		}

		System.out.print("\n\t\t   *Enter Address : ");
		String address=sc.nextLine();
		RegisterUserTO.setAddress(address);	

		cd.countriesDao();
		do
		{
			System.out.print("\n\n\t\t   *Select Country ID : ");
			String countryCode=sc.nextLine();
			RegisterUserTO.setCountryCode(countryCode.toUpperCase());		
		}while(cid.citiesDao(RegisterUserTO.getCountryCode())==false);

		//cid.citiesDao(RegisterUserTO.getCountryCode());

		do
		{
			System.out.print("\n\n\t\t   *Select City ID : ");
			cityCode=sc.nextLine();
			RegisterUserTO.setCityCode(cityCode.toUpperCase());
		}while(cid.citiesCheckDao(cityCode)==false);

		int age=acbo.yearCalculation(dateOfBirth);

		return age;

	}
}
