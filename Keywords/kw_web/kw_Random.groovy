package kw_web

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import java.text.SimpleDateFormat
import internal.GlobalVariable
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils
import java.util.*;
import java.util.Random;


public class kw_Random {

	@Keyword
	public static kw_random_Pasword() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		int RandomNum =  10 +(int)(Math.random() * 99);
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		String FirstName = "auto";
		String Random_Password = FirstName + RandomNum;

		return Random_Password
	}

	@Keyword
	public static long generateRandomNDigitNumber(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of digits must be greater than 0.");
		}

		Random random = new Random();
		int minValue = (int) Math.pow(10, n - 1);
		int maxValue = (int) Math.pow(10, n) - 1;
		return (int) (Math.random() *(maxValue - minValue + 1)) + minValue;
	}

	@Keyword
	public static String RandomNDigitNumber(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of digits must be greater than 0.");
		}

		Random random = new Random();
		StringBuilder number = new StringBuilder();

		// Ensure the first digit is non-zero
		number.append(random.nextInt(9) + 1); // First digit (1-9)

		// Append the remaining digits (0-9)
		for (int i = 1; i < n; i++) {
			number.append(random.nextInt(10));
		}

		return number.toString();
	}



	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	@Keyword
	private static String generateRandomString(int length) {
		//	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
		Random random = new Random()
		StringBuilder sb = new StringBuilder()
		for (int i = 0; i < length; i++) {
			sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())))
		}
		return sb.toString()
	}

	@Keyword
	public static String getRandomFirstName() {
		return generateRandomString(6) // 6-character random first name
	}

	@Keyword
	public static String getRandomLastName() {
		return generateRandomString(8) // 8-character random last name
	}

	@Keyword
	public static String getRandomEmail() {
		return generateRandomString(6).toLowerCase() + new Random().nextInt(9999) + "@example.com"
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
	public String get_post_Year() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date

		String output = sdf.format(c.getTime());
		System.out.println("Current Month : " +output );
		return output;
	}
	//click and select the month from month dropdown from profile page
	@Keyword
	public void click_and_select_month_from_Month_Dropdown(TestObject mon_dropdownObject) {
		//first click on the Month Dropdown
		WebUI.enhancedClick(mon_dropdownObject)
		WebUI.delay(1)

		//click on the date option from the dropdown
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		// c.add(Calendar.DATE, days); // Adding 5 days
		// c.add(Calendar.DAY_OF_WEEK_IN_MONTH, year); // Adding 5 days
		String date = sdf.format(c.getTime());
		println('date : '+date)

		String mont_option_xpath =  "//ul[@role='listbox']//li[@data-value='"+date+"']"
		TestObject month_option_Object= new TestObject();
		month_option_Object.addProperty("xpath",ConditionType.EQUALS, mont_option_xpath)

		WebUI.click(month_option_Object)
		//enter and tabout from month dropdwon
		//WebUI.sendKeys(mon_dropdownObject,  Keys.chord(Keys.ENTER))
		//WebUI.sendKeys(year_option_Object,  Keys.chord(Keys.ENTER))
		WebUI.sendKeys(mon_dropdownObject,  Keys.chord(Keys.TAB))
	}

	//click and select the year from year dropdown from profile page
	@Keyword
	public void click_and_select_year_from_Year_Dropdown(TestObject year_dropdownObject) {
		//first click on the year Dropdown
		WebUI.enhancedClick(year_dropdownObject)
		WebUI.delay(1)

		//click on the date option from the dropdown
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.YEAR, 2); // Adding 2 years more
		String year = sdf.format(c.getTime());
		println('Year : ' +year)

		String year_option_xpath =  "//ul[@role='listbox']//li[@data-value='"+year+"']"
		TestObject year_option_Object= new TestObject();
		year_option_Object.addProperty("xpath",ConditionType.EQUALS, year_option_xpath)

		WebUI.click(year_option_Object)
		//Enter and tabout from year dropdwon
		//WebUI.sendKeys(year_option_Object,  Keys.chord(Keys.ENTER))
		WebUI.sendKeys(year_dropdownObject,  Keys.chord(Keys.TAB))
	}


	@Keyword
	public String get_Past_date_from_current_Date() {

		//click on the date option from the dropdown
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, -1); // Adding 2 years more
		String pastDate = sdf.format(c.getTime())

		// Print the past day
		println('Past DATE : ' + pastDate)
		return pastDate;
	}

	@Keyword
	public String get_Post_date_from_current_Date() {

		//click on the date option from the dropdown
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 1); // Adding 2 years more
		String postDate = sdf.format(c.getTime())

		// Print the past day
		println('Post DATE : ' + postDate)
		return postDate;
	}

	@Keyword
	String generateRandomInput(String inputType, int n ) {

		switch (inputType.toLowerCase()) {
			case 'alphabets':
				return RandomStringUtils.randomAlphabetic(n)
			case 'special characters':
				return RandomStringUtils.random(n, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'spaces':
				return " ".repeat(n)
			case 'decimal':
				return RandomStringUtils.randomNumeric(n - 2) + '.' + RandomStringUtils.randomNumeric(2) // Decimal format
			case 'numbers':
				return RandomStringUtils.randomNumeric(n)
			case 'number and alphabets':
				int numCount = n / 2
				return RandomStringUtils.randomNumeric(numCount) + RandomStringUtils.randomAlphabetic(n - numCount)
			case 'number and special characters':
				int numPart = n / 2
				return RandomStringUtils.randomNumeric(numPart) + RandomStringUtils.random(n - numPart, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'alphabet and special characters':
				int alphaPart = n / 2
				return RandomStringUtils.randomAlphabetic(alphaPart) + RandomStringUtils.random(n - alphaPart, '!@#$%^&*()_+[]{}|;:,.<>?/')
			case 'number with spaces':
				String number = RandomStringUtils.randomNumeric(n - 2)
				return number.substring(0, 2) + " " + number.substring(1)
			

			default:
				throw new IllegalArgumentException("Unsupported input type: " + inputType)
		}
	}

	@Keyword
	public String get_current_Month_Date() {

		// Use MM/dd format
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd")
		Calendar c = Calendar.getInstance()
		c.setTime(new Date())

		String currentMonthDate = sdf.format(c.getTime())

		// Print the post date
		println('currentMonthDate : ' + currentMonthDate)
		return currentMonthDate
	}

	@Keyword
	public String get_Todays_Day_Name() {

		// Create a SimpleDateFormat instance to get the day name
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE")

		// Get the current date
		Calendar c = Calendar.getInstance()
		c.setTime(new Date()) // Using today's date

		String dayName = sdf.format(c.getTime())

		// Print today's day name
		println('Todays Day: ' + dayName)

		return dayName
	}
}