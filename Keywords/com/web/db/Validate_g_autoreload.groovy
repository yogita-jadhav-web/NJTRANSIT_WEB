package com.web.db

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

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
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import com.web.db.NJT_Web_Database
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Validate_g_autoreload {
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
	public Map<String, String> get_g_autoreload_data_from_DB(Connection con_obj,String email_id) {

		con=con_obj;

		def g_autoreloadData = [:]
		try {

			stmt = con.createStatement();

			String sql_query="select BOS_ID,WALLET_ID,FARECARD,THRESHOLD_AMT,RELOAD_AMT,STATUS,USER_ID,CARD_NO from g_autoreload where user_ID= '"+email_id+"' order by created_date desc";

			rs = stmt.executeQuery(sql_query);
			if (rs.next()) {
				g_autoreloadData['BOS_ID'] = rs.getString('BOS_ID')
				g_autoreloadData['WALLET_ID'] = rs.getString('WALLET_ID')
				g_autoreloadData['FARECARD'] = rs.getString('FARECARD')
				g_autoreloadData['THRESHOLD_AMT'] = rs.getString('THRESHOLD_AMT')
				g_autoreloadData['RELOAD_AMT'] = rs.getString('RELOAD_AMT')
				g_autoreloadData['STATUS'] = rs.getString('STATUS')
				g_autoreloadData['USER_ID'] = rs.getString('USER_ID')
				g_autoreloadData['CARD_NO'] = rs.getString('CARD_NO')
			}
		} catch (SQLException ex) {
			println("MYSQL Database Connection Failed!")
			ex.printStackTrace()
		} finally {
			if (con_obj != null) {
				con_obj.close()
			}
		}

		println("Final autoreloadData: " + g_autoreloadData)
		println("Data Type of autoreloadData: " + g_autoreloadData.getClass().getName())

		return g_autoreloadData
	}
}
