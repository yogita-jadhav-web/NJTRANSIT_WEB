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

public class Validate_p_web_trx_refunds {
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
	public Map<String, String> get_p_web_trx_refund_data_from_DB(Connection con_obj,String email_id) {

		con=con_obj;

		def p_web_trx_refund_Data = [:]
		try {

			stmt = con.createStatement();

			String sql_query="select * from p_web_trx_refunds where user_id = '"+email_id+"' order by ID desc";
			rs = stmt.executeQuery(sql_query);

			if (rs.next()) {
				p_web_trx_refund_Data['ID'] = rs.getString('ID')
				p_web_trx_refund_Data['APP_TYPE'] = rs.getString('APP_TYPE')
				p_web_trx_refund_Data['REFUND_DATE'] = rs.getString('REFUND_DATE')
				p_web_trx_refund_Data['USER_ID'] = rs.getString('USER_ID')
				p_web_trx_refund_Data['REFUND_AMT'] = rs.getString('REFUND_AMT')
				p_web_trx_refund_Data['REFUND_STATUS'] = rs.getString('REFUND_STATUS')
				p_web_trx_refund_Data['REFUND_STATE'] = rs.getString('REFUND_STATE')
				p_web_trx_refund_Data['COMMENTS'] = rs.getString('COMMENTS')
				p_web_trx_refund_Data['WALLET_ID'] = rs.getString('WALLET_ID')
			}
		} catch (SQLException ex) {
			println("MYSQL Database Connection Failed!")
			ex.printStackTrace()
		} finally {
			if (con_obj != null) {
				con_obj.close()
			}
		}

		println("Final p_web_trx_refund_Data: " + p_web_trx_refund_Data)
		println("Data Type of p_web_trx_refund_Data: " + p_web_trx_refund_Data.getClass().getName())

		return p_web_trx_refund_Data
	}


	@Keyword
	public String get_refund_additional_data_from_DB(Connection con_obj,String email_id) {

		con=con_obj;
		String additional_data = null;
		try {

			stmt = con.createStatement();

			String sql_query="select * from p_web_trx_refunds where user_id = '"+email_id+"' order by ID desc";

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			additional_data = rs.getString('ADDITIONAL_DATA');
			println('additional_data : '+additional_data )
		}

		return additional_data;
	}
}
