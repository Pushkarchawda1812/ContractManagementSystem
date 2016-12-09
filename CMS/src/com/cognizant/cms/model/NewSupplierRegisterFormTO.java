package com.cognizant.cms.model;

public class NewSupplierRegisterFormTO 
{
	private static String SupplierName;
	private static boolean submit;
	
	public static boolean isSubmit() {
		return submit;
	}

	public static void setSubmit(boolean submit) {
		NewSupplierRegisterFormTO.submit = submit;
	}

	public static String getSupplierName() {
		return SupplierName;
	}

	public static void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	
}
