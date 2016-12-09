
conn system/root;

create user cms identified by cms;

conn system/root;

grant create session to cms;

grant create table, create sequence, create procedure, create trigger to cms;

alter user cms quota unlimited on system;

create table Countries
			( Country_ID varchar2(20),
		      Country_Name varchar2(50) not null,
		      CONSTRAINT Country_ID_pk PRIMARY KEY (Country_ID)
	         );

create table Cities
		    ( City_ID varchar2(20),
  		      Country_ID varchar2(20) ,
		      City_Name varchar2(50) not null,
		      CONSTRAINT Cities_ID_pk PRIMARY KEY (City_ID),
		      CONSTRAINT fk_Country_ID foreign key(Country_ID) references Countries(Country_ID)
		    );

create table Admin_Details
			( Admin_ID varchar2(8), 
 			  Admin_Name varchar2(20) not null, 
 			  Admin_Password varchar2(20) not null, 
		      Admin_Date_of_Birth date not null, 
		      Admin_Email_Address varchar2(50) not null,
		      Admin_Contact_Number int not null, 
	     	  Admin_Address varchar2(100) not null, 
			  Admin_City_Code varchar2(20) , 
   			  Admin_Country_Code varchar2(20) ,
			  CONSTRAINT Admin_ID_pk PRIMARY KEY (Admin_ID),
		      CONSTRAINT fk_Admin_City foreign key(Admin_City_Code) references Cities(City_ID),
			  CONSTRAINT fk_Admin_COuntry foreign key (Admin_Country_Code) references Countries(Country_ID)
			 );

create table Supplier_Details
			( Supplier_ID varchar2(7),
 	          Supplier_Name varchar2(20) not null, 
 			  Supplier_Password varchar2(20) not null, 
			  Supplier_Date_of_Birth date not null, 
			  Supplier_Email_Address varchar2(50) not null,
			  Supplier_Contact_Number varchar2(20) not null, 
	     	  Supplier_Address varchar2(100) not null, 
			  Supplier_City_Code varchar2(20) , 
   			  Supplier_Country_Code varchar2(20) ,
			  CONSTRAINT Supplier_ID_pk PRIMARY KEY (Supplier_ID),
		      CONSTRAINT fk_Supplier_City foreign key(Supplier_City_Code) references Cities(City_ID),
			  CONSTRAINT fk_Supplier_COuntry foreign key(Supplier_Country_Code) references Countries(Country_ID)
			 );

create table Contract_Details
			( Admin_ID varchar2(8),
              Contract_Name varchar2(20) not null,
              Type_of_Contract varchar2(20) not null,
              Start_Date date not null,
              Number_of_Years int not null,
              Contract_ID varchar2(20),
              Lock_Status varchar2(10) not null,
              Contract_Status varchar2(50) not null,
			  CONSTRAINT Contract_ID_pk PRIMARY KEY (Contract_ID),
			  CONSTRAINT fk_Admin_ID_Contract foreign key(Admin_ID) references Admin_Details(Admin_ID)
             );

create table Amenities
			( Amenity_ID varchar2(20),
              Contract_ID varchar2(20),
              Supplier_ID varchar2(7),
              Amenity_Name varchar2(20) not null,
              Amenity_Description varchar2(500) not null,
              Amenity_Status varchar2(10) not null,
              Amenity_Lock varchar(10) null,
              Amenity_Remarks varchar(200)null,
              Amenity_Status_Date date null,
		      CONSTRAINT Amenity_ID_pk PRIMARY KEY (Amenity_ID),
		      CONSTRAINT fk_Supplier_Amentites foreign key(Supplier_ID) references Supplier_Details(Supplier_ID),
              CONSTRAINT fk_Contract_ID foreign key(Contract_ID) references Contract_Details(Contract_ID)
             );
             
create table Amenities_Dummy
			( Amenity_ID varchar2(20) not null,
              Contract_ID varchar2(20) not null,
              Amenity_Name varchar2(20) not null,
              Amenity_Description varchar2(500) not null,
              Amenity_Status varchar2(10) not null,
              Amenity_Remarks varchar(200)null,
              Amenity_Status_Date date null,
             );
             
create table Amenities_Approval
			( Supplier_ID varchar2(7),
			  Contract_ID varchar2(20)
             );

create sequence Admin_ID_Sequence
start with 100
increment by 1
minvalue 000
maxvalue 999 
cache 20
nocycle;

create sequence Supplier_ID_Sequence
start with 100
increment by 1
minvalue 000
maxvalue 999 
cache 20
nocycle;

create sequence Contract_ID_Sequence
start with 100
increment by 1
minvalue 000
maxvalue 999 
cache 20
nocycle;

create sequence Amenities_ID_Sequence
start with 100
increment by 1
minvalue 000
maxvalue 999 
cache 20
nocycle;