package com.cognizant.cms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.cognizant.cms.constant.QueryConstant;
import com.cognizant.cms.process.NextPeriodProcess;
import com.cognizant.cms.util.DbUtil;


//author Shikha
//This class is used to display the details of the contract in Next Period Category.
public class ViewNextDAO 
{

	public void nextperiodviewdao(String Contractid) throws ClassNotFoundException, SQLException, IOException
	{
		String userID=null;

		Connection connection =DbUtil.getConnection();
		NextPeriodProcess nbo=new NextPeriodProcess();

		ResultSet rs;

		ArrayList<String> arradminid = new ArrayList<String>();
		ArrayList<String> arrcname = new ArrayList<String>();
		ArrayList<String> arrtype = new ArrayList<String>();
		ArrayList<StringTokenizer> arrstart = new ArrayList<StringTokenizer>();
		ArrayList<Integer> arryear = new ArrayList<Integer>();
		ArrayList<String> arrid = new ArrayList<String>();
		ArrayList<String> arrlock = new ArrayList<String>();
		ArrayList<String> arrstatus = new ArrayList<String>();


		int i=0;
		PreparedStatement viewnextperiod = connection.prepareStatement(QueryConstant.NEXTPERIODVIEW);
		viewnextperiod.setString(1,Contractid);
		rs=viewnextperiod.executeQuery();

		@SuppressWarnings("unused")
		StringTokenizer stk;


		while(rs.next())
		{
			userID=rs.getString(1);
			arradminid.add(i,userID);
			arrcname.add(i,rs.getString(2));
			arrtype.add(i,rs.getString(3));
			arrstart.add(i,stk=new StringTokenizer(rs.getString(4),"-"));
			arryear.add(i, rs.getInt(5));
			arrid.add(i,rs.getString(6));
			arrlock.add(i,rs.getString(7));
			arrstatus.add(i,rs.getString(8));
			i++;

			nbo.nextshow(userID, arradminid,arrcname,arrtype,arrstart,arryear,arrid,arrlock,arrstatus);

		}
		rs.close();
		connection.close(); 

	}




}
