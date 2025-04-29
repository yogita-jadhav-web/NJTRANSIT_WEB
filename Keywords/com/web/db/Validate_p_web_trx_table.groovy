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

public class Validate_p_web_trx_table {

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
	public Map<String, String> get_p_web_trx_from_DB(Connection con_obj) {

		con=con_obj;

		def p_trx_Data = [:]
		try {

			stmt = con.createStatement();

			String sql_query = "select * from p_web_trx where app_type ='1' order by trx_date desc limit 1 ";
			rs = stmt.executeQuery(sql_query);
			if (rs.next()) {
				p_trx_Data['TRX_TYPE'] = rs.getString('TRX_TYPE')
				p_trx_Data['TRX_DATE'] = rs.getString('TRX_DATE')
				p_trx_Data['TRX_AMT'] = rs.getString('TRX_AMT')
				p_trx_Data['FARE_CARD_ID'] = rs.getString('FARE_CARD_ID')
			
			}
		} catch (SQLException ex) {
			println("MYSQL Database Connection Failed!")
			ex.printStackTrace()
		} finally {
			if (con_obj != null) {
				con_obj.close()
			}
		}

		println("Final autoreloadData: " + p_trx_Data)
		println("Data Type of autoreloadData: " + p_trx_Data.getClass().getName())

		return p_trx_Data
	}
}

