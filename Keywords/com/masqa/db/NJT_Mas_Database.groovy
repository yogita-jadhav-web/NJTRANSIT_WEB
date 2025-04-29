package com.masqa.db

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
import org.jsoup.Jsoup


public class NJT_Mas_Database {

	public Connection con = null;
	public  Statement stmt = null;
	public  ResultSet rs =null;

	@Keyword
	public Connection get_MySQL_Mas_DBConnection(String NJT_Mas_DB_Url,String NJT_Mas_DB_UserName,String NJT_Mas_DB_Password) {
		String env = 'QA';
		String conn_url = null;

		if(con==null) {
			//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");


			try {
				//con=DriverManager.getConnection("jdbc:mysql://localhost:43306/masqa","qauser","QaU5e6cl0ud");
				con=DriverManager.getConnection(NJT_Mas_DB_Url,NJT_Mas_DB_UserName,NJT_Mas_DB_Password);

				if(con!=null) {
					println(" MYSQL NJT WEB Database Connection Successfull")
				}
				else {
					println(" MYSQL NJT WEB Database Connection Failed !........")
				}
			} catch (SQLException ex) {
				assert false : "Database connection failed! Error: " + ex.getMessage()
				println("MYSQL NJT WEB Database Connection Failed ! Error: " + ex.getMessage())
				ex.printStackTrace();
			}


			return con;
		}
	}

	
	@Keyword
	public Connection get_Mas_DBConnection(String NJT_Mas_DB_Url, String NJT_Mas_DB_UserName, String NJT_Mas_DB_Password) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			println("Attempting to connect to database: " + NJT_Mas_DB_Url);
			
			con = DriverManager.getConnection(NJT_Mas_DB_Url, NJT_Mas_DB_UserName, NJT_Mas_DB_Password);
	
			if (con != null) {
				println("✅ MYSQL NJT WEB Database Connection Successful!");
			} else {
				println("❌ MYSQL NJT WEB Database Connection Failed!");
			}
		} catch (ClassNotFoundException e) {
			println("❌ JDBC Driver not found! Error: " + e.getMessage());
		} catch (SQLException ex) {
			println("❌ Database connection failed! Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return con;
	}
	



	@Keyword
	public String get_OTP_from_DB(Connection db_conn_obj, String email_id) {


		println('email_id 11111 :'+email_id)
		long otp = 0;
		String mesg_body = null;
		try {
			// first get the db connection hence calling the below method
			con = db_conn_obj;

			stmt = con.createStatement();
			String sql_query = "select * from masqa.p_email_message where RECIPIENTS = '"+email_id+"' order by CREATED_DATE desc LIMIT 1";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");
			println('sql_query :'+sql_query)
			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			//	mesg_body = rs.getString(3);
			mesg_body=rs.getString('MESSAGE_BODY')
			//	println('1.OTP : '+ )
			//System.out.println(" Mesg Body : "+mesg_body)
		}

		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = pattern.matcher(mesg_body);

		// Extract integers
		List<Integer> n = new ArrayList<>();
		while (matcher.find()) {
			n.add(Integer.parseInt(matcher.group()));
		}

		System.out.println("Size : "+n.size());
		otp = n.get(1);
		System.out.println(" OTP extracted from HTML : " +otp);

		String Opt1 = String.valueOf(otp);

		if(Opt1.length()!=6) {
			Opt1 = "0"+Opt1;
		}
		return Opt1;
	}

	@Keyword
	public String get_Valid_OTP_from_DB(Connection db_conn_obj, String email_id) {

		// first get the db connection hence calling the below method
		con = db_conn_obj;
		println('email_id 11111 :'+email_id)
		long otp = 0;
		String mesg_body = null;
		try {
			// first get the db connection hence calling the below method


			stmt = con.createStatement();
			String sql_query = "select MESSAGE_BODY from masqa.p_email_message where RECIPIENTS = '"+email_id+"' order by CREATED_DATE desc limit 1";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			mesg_body = rs.getString(1);
			//	println('1.OTP : '+ )
			//System.out.println(" Mesg Body : "+mesg_body)
		}

		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = pattern.matcher(mesg_body);

		// Extract integers
		List<Integer> n = new ArrayList<>();
		while (matcher.find()) {
			n.add(Integer.parseInt(matcher.group()));
		}

		System.out.println("Size : "+n.size());
		otp = n.get(1);
		System.out.println(" OTP extracted from HTML : " +otp);

		String Opt1 = String.valueOf(otp);

		if(Opt1.length()!=6) {
			Opt1 = "0"+Opt1;
		}
		return Opt1;
	}

	@Keyword
	public String get_Expired_OTP_from_DB(Connection db_conn_obj, String email_id) {

		con = db_conn_obj;
		println('email_id 11111 :'+email_id)
		long otp = 0;
		String mesg_body = null;
		try {
			// first get the db connection hence calling the below method

			stmt = con.createStatement();
			String sql_query = "select MESSAGE_BODY from masqa.p_email_message where RECIPIENTS = '"+email_id+"' order by CREATED_DATE desc";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		int i = 1;
		while(rs.next()) {

			println('rs.row =' +rs.row);
			if(i==2) {
				println('i =' +i)
				mesg_body = rs.getString(1);
				println('hello ')
				break;
			}
			i++;

			//println('1.OTP : '+ )
			//System.out.println(" Mesg Body : "+mesg_body)
		}

		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = pattern.matcher(mesg_body);

		// Extract integers
		List<Integer> n = new ArrayList<>();
		while (matcher.find()) {
			n.add(Integer.parseInt(matcher.group()));
		}

		System.out.println("Size : "+n.size());
		otp = n.get(1);
		System.out.println(" OTP extracted from HTML : " +otp);

		String Opt1 = String.valueOf(otp);

		if(Opt1.length()!=6) {
			Opt1 = "0"+Opt1;
			println('OTP :'+Opt1)
		}
		return Opt1;
	}

	@Keyword
	public String get_message_body_from_DB(Connection db_conn_obj, String email_id) {


		// first get the db connection hence calling the below method
		con = db_conn_obj;
		println('email_id :'+email_id)
		long otp = 0;
		String mesg_body = null;
		String subject = null;


		try {
			// first get the db connection hence calling the below method


			stmt = con.createStatement();
			String sql_query = "select MESSAGE_BODY,SUBJECT from masqa.p_email_message where RECIPIENTS = '"+email_id+"' order by CREATED_DATE desc limit 1";
			//		 ResultSet rs=stmt.executeQuery("select * from masqa.p_email_message where RECIPIENTS = 'autotest86@maildrop.cc' order by SEND_DATE desc");

			rs = stmt.executeQuery(sql_query);
			println('sql_query :'+sql_query)
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {
			mesg_body = rs.getString(1);
			subject = rs.getString(2);
		}

		return mesg_body;
	}

	@Keyword
	public String verify_text_present_in_subject(Connection db_conn_obj, String email_id) {


		// first get the db connection hence calling the below method
		con = db_conn_obj;
		println('email_id :'+email_id)
		long otp = 0;
		String subject = null;


		try {

			stmt = con.createStatement();
			String sql_query = "select MESSAGE_BODY,SUBJECT from masqa.p_email_message where RECIPIENTS = '"+email_id+"' order by CREATED_DATE desc limit 1";

			rs = stmt.executeQuery(sql_query);
		} catch (SQLException ex) {
			println(" MYSQL Database Connection Failed !........")
			ex.printStackTrace();
		}
		while(rs.next()) {

			subject = rs.getString(2);
			System.out.println("subject: "+subject)
		}


		return subject;
	}
}



