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

public class NJT_Web_Database {

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
	public String get_TRX_TYPE_from_DB(Connection con_obj) {

		String Trx_Type = null;
		try {

			con=con_obj;
			stmt = con.createStatement();
			String sql_query = "select TRX_TYPE,BOS_DATA from p_web_trx where app_type ='1' order by trx_date desc limit 1";

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL NJT WEB Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			Trx_Type = rs.getString(1);
			println('TRX_TYPE : '+Trx_Type )
		}
		return Trx_Type;
	}


	@Keyword
	public String get_BOS_data_from_DB(Connection con_obj) {

		con=con_obj;
		String bos_data = null;
		try {

			stmt = con.createStatement();
			String sql_query = "select TRX_TYPE,BOS_DATA from p_web_trx where app_type ='1' order by trx_date desc limit 1 ";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			bos_data = rs.getString(2);
			println('bos_data : '+bos_data )
		}

		return bos_data;
	}

	@Keyword
	public String get_additional_data_from_DB(Connection con_obj) {

		con=con_obj;
		String additional_data = null;
		try {

			stmt = con.createStatement();
			String sql_query = "select TRX_TYPE,ADDITIONAL_DATA from p_web_trx where app_type ='1' order by trx_date desc limit 1 ";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			additional_data = rs.getString(2);
			println('additional_data : '+additional_data )
		}

		return additional_data;
	}


	@Keyword
	public Map<String, String> get_g_autoreload_data_from_DB1111(Connection con_obj,String email_id) {

		con=con_obj;

		def autoreloadData = [:]
		try {

			stmt = con.createStatement();

			String sql_query="select BOS_ID,WALLET_ID,FARECARD,THRESHOLD_AMT,RELOAD_AMT,STATUS,USER_ID,CARD_NO from g_autoreload where user_ID= '"+email_id+"' order by created_date desc;";

			rs = stmt.executeQuery(sql_query);
			if (rs.next()) {
				autoreloadData['BOS_ID'] = rs.getString('BOS_ID')
				autoreloadData['WALLET_ID'] = rs.getString('WALLET_ID')
				autoreloadData['FARECARD'] = rs.getString('FARECARD')
				autoreloadData['THRESHOLD_AMT'] = rs.getString('THRESHOLD_AMT')
				autoreloadData['RELOAD_AMT'] = rs.getString('RELOAD_AMT')
				autoreloadData['STATUS'] = rs.getString('STATUS')
				autoreloadData['USER_ID'] = rs.getString('USER_ID')
				autoreloadData['CARD_NO'] = rs.getString('CARD_NO')
			}
		} catch (SQLException ex) {
			println("MYSQL Database Connection Failed!")
			ex.printStackTrace()
		} finally {
			if (con_obj != null) {
				con_obj.close()
			}
		}

		println("Final autoreloadData: " + autoreloadData)
		println("Data Type of autoreloadData: " + autoreloadData.getClass().getName())

		return autoreloadData
	}
}

