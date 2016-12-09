package com.cognizant.cms.constant;

public class QueryConstant 
{
	public static final String CREATECONTRACTQUERY = 
		"insert into Contract_Details values(?,?,?,to_date(?,'YYYY'),?,?||Contract_ID_Sequence.nextval,'Lock','Pending')";
    
	
	public static final String CONTRACTNAMEQUERY=
    	"select Start_date,Number_of_Years from Contract_Details where Contract_Name=? and Start_date=to_date(?,'YYYY') and Number_of_Years=?";
   
	
	public static final String NEXTPERIODQUERY=
    	"select Contract_Name,Contract_ID,Start_date,Number_of_Years from Contract_Details where Type_of_Contract='Next Period'";
   
	
	public static final String CURRENTPERIODQUERY=
    	"select Contract_Name,Contract_ID,Start_date,Number_of_Years from Contract_Details where Type_of_Contract='Current Period'";
    
	
	public static final String LASTPERIODQUERY=
    	"select Contract_Name,Contract_ID,Start_date,Number_of_Years from Contract_Details where Type_of_Contract='Last Period'";
    
	
	public static final String NEXTPERIODVIEW=
    	"select * from Contract_Details where Contract_ID=?";
    
	
	public static final String CURRENTPERIODVIEW=
    	"select * from Contract_Details where Contract_ID=?";
    
	
	public static final String LASTPERIODVIEW=
    	"select * from Contract_Details where Contract_ID=?";
    
	
	public static final String CONTRACTIDVALIDATION=
    	"select Contract_ID from Contract_Details where Contract_ID=?";
    
	
	public static final String EDITNUMBEROFYEARS=
    	"update Contract_Details set Number_of_Years=? where Contract_ID=?";
    
	
	public static final String EDITLOCKSTATUS=
    	"update Contract_Details set Lock_Status=? where Contract_ID=?";
   
	
	public static final String EDITCONTRACTSTATUS=
    	"update Contract_Details set Contract_Status=? where Contract_ID=?";
	
	public static final String CHECKCITYQUERY=
		"select city_id from cities where city_id=?";
	
	
	public static final String sequenceAdmin="select Admin_ID_sequence.currval from dual";
	
	
	public static final String sequenceSupplier="select supplier_ID_sequence.currval from dual";
	
	
	public static final String sequenceContract="select contract_ID_sequence.currval from dual";
	
	
	public static final String welcomeAdminNameDisplay=
		"select Admin_Name from Admin_Details where Admin_ID=?";
	
	
	public static final String welcomeSupplierNameDisplay=
		"select Supplier_Name from Supplier_Details where Supplier_ID=?";
	
	
	public static final String adminValidateQuery = 
		"select Admin_Password from Admin_Details where Admin_ID=?";
	
	
	public static final String supplierValidateQuery = 
		"select Supplier_Password from Supplier_Details where Supplier_ID=?";
	
	
	public static final String adminFormInsertQuery = 
		"insert into Admin_Details values(?||Admin_ID_Sequence.nextval,?,?,to_date(?,'YYYY-MM-DD'),?,?,?,?,?)";
	
	
	public static final String supplierFormInsertQuery = 
		"insert into Supplier_Details values(?||Supplier_ID_Sequence.nextval,?,?,to_date(?,'YYYY-MM-DD'),?,?,?,?,?)";
	
	
	public static final String countriesQuery = 
		"Select * from Countries";
	
	
	public static final String citiesQuery = 
		"Select City_ID, City_Name from Cities where Country_ID=?";
	
	
	public static final String editPasswordAdminQuery=
		"update Admin_Details set Admin_Password =? where Admin_ID=?";
	
	
	public static final String editEmailAdminQuery=
		"update Admin_Details set Admin_Email_Address =? where Admin_ID=?";
	
	public static final String editContactAdminQuery=
		"update Admin_Details set Admin_Contact_Number =? where Admin_ID=?";
	
	public static final String editAddressAdminQuery=
		"update Admin_Details set Admin_Address =? where Admin_ID=?";
	
	public static final String editPasswordSupplierQuery=
		"update Supplier_Details set Supplier_Password =? where Supplier_ID=?";
	
	public static final String editEmailSupplierQuery=
		"update Supplier_Details set Supplier_Email_Address =? where Supplier_ID=?";
	
	public static final String editContactSupplierQuery=
		"update Supplier_Details set Supplier_Contact_Number =? where Supplier_ID=?";
	
	public static final String editAddressSupplierQuery=
		"update Supplier_Details set Supplier_Address =? where Supplier_ID=?";
	
	public static final String selectingContract=
		"select Contract_ID,Contract_Name,Contract_Status,Type_of_Contract from Contract_Details";
	
	public static final String displayingContract=
		"select Contract_Details.Admin_ID,Contract_Details.Contract_Name,Contract_Details.Type_of_Contract,Contract_Details.Start_Date,Contract_Details.Number_of_Years,Contract_Details.Contract_ID,Contract_Details.Lock_Status,Contract_Details.Contract_Status,Admin_Details.Admin_Name from Contract_Details join Admin_Details on Contract_Details.Admin_ID=Admin_Details.Admin_ID where Contract_Details.Contract_ID=?";
	
	public static final String updateStatus=
		"update Contract_Details set Contract_Status='Pending Paper Contract Receipt Status' where Contract_ID=?";
	
	public static final String displayUpadtedContract=
		"select * from Contract_Details where Contract_ID=?";
	
	
	public static final String unlockingContract=
		"insert into Amenities_Approval values(?,?)";
	
	
	public static final String settingAmenityQuery=
		"insert into Amenities values(Amenities_ID_Sequence.nextval,?,?,?,?,'Pending',?,?,to_date(?,'YYYY-MM-DD'))";
	
	
	public static final String displayContractMA=
		"select Amenities_Approval.Supplier_ID, Amenities_Approval.Contract_ID,Contract_Details.Contract_Name from Amenities_Approval join Contract_Details on Amenities_Approval.Contract_ID=Contract_Details.Contract_ID";
	
	public static final String updateLock=
		"update Contract_Details set Lock_Status='Unlock' where Contract_ID=?";
	
	public static final String deleteUpdateLock=
		"delete from Amenities_Approval where Contract_ID=?";
	
	public static final String lockContractUpdateQuery = 
		"update Contract_Details set lock_status= ? where Contract_ID= ?";


	public static final String unlockContractUpdateQuery=
		"update contract_details set lock_status=? where Contract_ID= ?";


	public static final String amenityRequestStatusQuery=
		"select * from Amenities where amenity_Status='Pending'";


	public static final String adminApprovalViewQuery=
		"select * from Amenities ";


	public static final String adminUpdateAmenityViewQuery=
		"update amenities set amenity_status=?, Amenity_remarks=?, Amenity_Status_Date=to_date(?,'YYYYMMDD') where amenity_id=?";


	public static final String amenityDescriptionViewQuery=
		"select amenity_description from amenities where amenity_id= ?";

	public static final String acknowledgementScreenDaoQuery=
		"select * from amenities";

	public static final String unlockLockAmenityDaoQuery=
	"update amenities set amenity_lock_status= ? where amenity_id=?";

	public static final String editContractStatusAmenity=
	"update Contract_Details set Contract_Status=? where Contract_ID=?";

	public static final String editAmenityDisplay=
	"select * from Amenities where Contract_ID=?";

	public static final String editSelectedAmenity=
	"update Amenities set Amenity_Description=? where Amenity_ID=?";

	public static final String editContractLockAmenity=
	"update Contract_Details set Lock_Status=? where Contract_ID=?";
	
	

}
