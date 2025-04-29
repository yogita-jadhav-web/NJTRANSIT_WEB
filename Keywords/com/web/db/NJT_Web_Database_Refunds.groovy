package com.web.db

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertEquals

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.regex.*;
import org.testng.Assert

public class NJT_Web_Database_Refunds {

	public Connection con = null;
	public  Statement stmt = null;
	public  ResultSet rs =null;

	@Keyword
	public Connection get_MySQL_Web_DBConnection(String NJT_Web_DB_Url,String NJT_Web_DB_UserName,String NJT_Web_DB_Password) {
		String env = 'QA';
		String conn_url = null;

		if(con==null) {
			//	Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");


			try {
				//jdbc:mysql://10.150.10.221:13310/njtwebqa
				//njtwebretail_qa
				//ZaQ234567!
				con=DriverManager.getConnection(NJT_Web_DB_Url,NJT_Web_DB_UserName,NJT_Web_DB_Password);
				println('con :'+ con)
				if(con!=null) {
					println(" MYSQL NJT WEB Database Connection Successfull")
				}
				else {
					println(" MYSQL NJT WEB Database Connection Failed !........")
				}
			} catch (SQLException ex) {
				println(" MYSQL NJT WEB Database Connection Failed !........")
				ex.printStackTrace();
			}


			return con;
		}
	}



	@Keyword
	public String get_REFUND_DATE_Details(Connection con_obj,String query) {
		String refund_Date = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			refund_Date = rs.getString("REFUND_DATE");
			println(refund_Date)
		}
		return refund_Date;
	}

	@Keyword
	public String get_Reference_ID_Details(Connection con_obj,String query) {
		String reference_Id = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			reference_Id = rs.getString("ID");
			println(reference_Id)
		}
		return reference_Id;
	}

	@Keyword
	public String get_USER_ID_Details(Connection con_obj,String query) {
		String user_Id = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			user_Id = rs.getString("USER_ID");
			println(user_Id)
		}
		return user_Id;
	}

	@Keyword
	public String get_REFUND_STATUS_Details(Connection con_obj,String query) {
		String refund_Status = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			refund_Status = rs.getString("REFUND_STATUS");
			println(refund_Status)
		}
		return refund_Status;
	}

	@Keyword
	public String get_APP_TYPE_Details(Connection con_obj,String query) {
		String appType = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			appType = rs.getString("APP_TYPE");
			println(appType)
		}
		return appType;
	}

	@Keyword
	public String get_REFUND_AMOUNT_Details(Connection con_obj,String query) {
		String appType = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			appType = rs.getString("REFUND_AMT");
			println(appType)
		}
		return appType;
	}

	@Keyword
	public String get_REFUND_STATE_Details(Connection con_obj,String query) {
		String appType = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = query;

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			appType = rs.getString("REFUND_STATE");
			println(appType)
		}
		return appType;
	}
	
	
}

