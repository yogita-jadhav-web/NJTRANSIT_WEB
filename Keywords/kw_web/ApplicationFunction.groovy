
package kw_web
import java.text.DateFormat
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectXpath
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import static org.assertj.core.api.InstanceOfAssertFactories.BYTE

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import com.kms.katalon.core.annotation.Keyword
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.xpath.XPathFunction

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ApplicationFunction {



	@Keyword
	public String get_past_date() {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, Math.negateExact(1) );
		date = calendar.getTime();
		// Now format the date and return


		return dateFormat.format(date);
	}

	@Keyword
	public String get_2days_past_date() {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, Math.negateExact(2) );
		date = calendar.getTime();
		// Now format the date and return


		return dateFormat.format(date);
	}

	@Keyword
	def keyword_ChangePhoto(String fileName) {

		Robot  robot = new Robot();


		File file = new File(fileName)
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath())
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Keyword
	public String getRandomSSN() {
		int ssd  = (int)(Math.random()*1000000000);
		return Integer.toString(ssd)
	}


	@Keyword
	public  String get_Ramdon_9Digit_Number() {
		Set<Long> uniqueNumbers = new HashSet<>();
		Random random = new kw_Random();

		while (uniqueNumbers.size() < 1) {
			long candidate = (long)(random.nextDouble() * 900000000L) + 100000000L;
			if (isValidNumber(candidate)) {
				uniqueNumbers.add(candidate);
			}
		}
		System.out.println((long) (random.nextDouble() * 900000000L) + 100000000L);
		return Long.toString( (long) (random.nextDouble() * 900000000L) + 100000000L);
	}

	@Keyword
	private  boolean isValidNumber(long number) {
		String numberString = String.valueOf(number);
		return !numberString.startsWith("000") &&
				!numberString.startsWith("999") &&
				!numberString.startsWith("666");
	}

	@Keyword
	public static String generate_Random_Alpha_Numeric_Number(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder(length);
		Random random = new kw_Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}

		return sb.toString();
	}

	//============================================================================================================

	//Date Functions Below

	//============================================================================================================



	@Keyword
	public String get_new_date_plus_days(int no_of_days) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, no_of_days); // Adding no of days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;
	}


	@Keyword
	public String get_current_date_dd() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		// c.add(Calendar.DATE, days); // Adding 5 days
		// c.add(Calendar.DAY_OF_WEEK_IN_MONTH, year); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(" Output = "+output);
		return output;
	}
	@Keyword
	public String get_yesterday_date_dd() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd")
		Calendar c = Calendar.getInstance()
		c.setTime(new Date()) // Using today's date
		c.add(Calendar.DATE, -1) // Subtract 1 day for yesterday's date
		String output = sdf.format(c.getTime())
		System.out.println("Yesterday's Date = " + output)
		return output
	}
	
	@Keyword
	public String get_tomorrow_date_dd() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd")
		Calendar c = Calendar.getInstance()
		c.setTime(new Date()) // Using today's date
		c.add(Calendar.DATE, 1) // Add 1 day for tomorrow's date
		String output = sdf.format(c.getTime())
		System.out.println("Tomorrow's Date = " + output)
		return output
	}
	@Keyword
	def static void click_currentday_on_Date_Picker() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		// c.add(Calendar.DATE, days); // Adding 5 days
		// c.add(Calendar.DAY_OF_WEEK_IN_MONTH, year); // Adding 5 days
		String day = sdf.format(c.getTime());

		String build_dateXpath = "//table[@class='pika-table']/tbody//td[@data-day='"+day+"']"

		//1 parent frame
		String framexpath1 = "//iframe[@id='FullPageWebResource']"
		TestObject testobj_frame1 = new TestObject()
		testobj_frame1.addProperty("xpath",ConditionType.EQUALS, framexpath1)

		WebUI.switchToFrame(testobj_frame1, 2)


		//2 Child frame
		String framexpath2 = "//iframe[@id='embeddedCanvasApp']"
		TestObject testobj_frame2 = new TestObject()
		testobj_frame2.addProperty("xpath",ConditionType.EQUALS, framexpath2)

		WebUI.switchToFrame(testobj_frame2, 2)

		//3 Child frame
		String framexpath3 = "//iframe[@id='fullscreen-app-host']"
		TestObject testobj_frame3 = new TestObject()
		testobj_frame3.addProperty("xpath",ConditionType.EQUALS, framexpath3)

		WebUI.switchToFrame(testobj_frame3, 2)


		TestObject testobj = new TestObject()
		testobj.addProperty("xpath",ConditionType.EQUALS, build_dateXpath)
		WebUI.enhancedClick(testobj)

		//clicking on the datepicker ok button
		String datePicker_ok_Button = "//button[@class='appmagic-datepicker-ok-button']"
		TestObject testobj_okButton = new TestObject()
		testobj_okButton.addProperty("xpath",ConditionType.EQUALS, datePicker_ok_Button)
		WebUI.enhancedClick(testobj_okButton)

		WebUI.switchToDefaultContent()

		WebUI.enableSmartWait()
	}


	@Keyword
	public String get_new_date_plus_years(int no_of_years) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, no_of_years); // Adding no of years
		String output = sdf.format(c.getTime());
		System.out.println(" Post Year : " +output);
		return output;
	}

	@Keyword
	public String get_current_Month() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date

		String output = sdf.format(c.getTime());
		System.out.println("Current Month : " +output );
		return output;
	}

	@Keyword
	public String get_current_Year() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date

		String output = sdf.format(c.getTime());
		System.out.println("Current year : " +output );
		return output;
	}
	@Keyword
	public String get_past_Year() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, -1);
		String output = sdf.format(c.getTime());
		System.out.println("Current year : " +output );
		return output;
	}

	@Keyword
	def static void click_pastyear_on_Date_Picker() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, -2);
		String pastyear = sdf.format(c.getTime());
		System.out.println("Current pastyear : " +pastyear );

		String yearXpath = "//*[@type = 'button' and (text() = '"+pastyear+"')]"

		TestObject testobj = new TestObject()
		testobj.addProperty("xpath",ConditionType.EQUALS, yearXpath)
		WebUI.enhancedClick(testobj)
	}
}
