package com.cognizant.cms.model;

public class NewAdminRegisterFormTO {

	private static String userName;
	private static boolean submit;

	public static boolean isSubmit() {
		return submit;
	}

	public static void setSubmit(boolean submit) {
		NewAdminRegisterFormTO.submit = submit;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		NewAdminRegisterFormTO.userName = userName;
	}

	
}
