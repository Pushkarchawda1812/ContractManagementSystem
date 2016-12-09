package com.cognizant.cms.model;

public class RegisterUserTO 
{
	private static String password;
	private static String reTypePassword;
	private static String dateOfBirth;
	private static String emailAddress;
	private static long contact;
	private static String address;
	private static String cityCode;
	private static String countryCode;
	
	public static String getCityCode() {
		return cityCode;
	}
	public static void setCityCode(String cityCode) {
		RegisterUserTO.cityCode = cityCode;
	}
	public static String getCountryCode() {
		return countryCode;
	}
	public static void setCountryCode(String countryCode) {
		RegisterUserTO.countryCode = countryCode;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		RegisterUserTO.password = password;
	}
	public static String getReTypePassword() {
		return reTypePassword;
	}
	public static void setReTypePassword(String reTypePassword) {
		RegisterUserTO.reTypePassword = reTypePassword;
	}
	public static String getDateOfBirth() {
		return dateOfBirth;
	}
	public static void setDateOfBirth(String dateOfBirth) {
		RegisterUserTO.dateOfBirth = dateOfBirth;
	}
	public static String getEmailAddress() {
		return emailAddress;
	}
	public static void setEmailAddress(String emailAddress) {
		RegisterUserTO.emailAddress = emailAddress;
	}
	public static long getContact() {
		return contact;
	}
	public static void setContact(long contact) {
		RegisterUserTO.contact = contact;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		RegisterUserTO.address = address;
	}

}
