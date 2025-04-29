package kw_web
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.InstanceOfAssertFactories.BOOLEAN
import org.openqa.selenium.ScriptTimeoutException
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;
import java.util.TimeZone;
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import org.openqa.selenium.Keys as Keys
import javax.xml.xpath.XPathFunction
import com.github.javafaker.Faker
import java.util.concurrent.TimeUnit

class web {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	//Scroll to bottom of the page
	@Keyword
	public void scrollToPageBottom() {
		WebDriver driver = DriverFactory.getWebDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//click on the message popup cancel button if present


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
		c.add(Calendar.YEAR, 1); // Adding 2 years more
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



	//Delete the existing Credit cards present in Manage Saved Payments section
	@Keyword
	public void delete_existing_Credit_Cards_From_Manged_Saved_Payments_section(TestObject existing_CC_RadioBtn_xpath) {
		try {
			//	TestObject myTestObject = findTestObject(existing_CC_RadioBtn_xpath)

			String xpath = getXPath(existing_CC_RadioBtn_xpath)
			println("List XPath: " + xpath)
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to identify the element")
		}
	}

	@Keyword
	def String getXPath(TestObject testObject) {
		TestObjectProperty xpathProperty = testObject.findPropertyValue('xpath')
		return xpathProperty != null ? xpathProperty: null
	}

	//check the element radio buton of new add card is present on ui and return boolean value
	@Keyword
	public  boolean check_visa_image_is_present_On_UI() {
		boolean flag =false;

		//String radio_btn_addnewcard_xpath =  "//input[@value='newCard' and @type='radio']"
		String radio_btn_addnewcard_xpath =  "//img[@class='MuiBox-root css-12z0wuy']"

		TestObject radio_btn_addnewcard= new TestObject();
		radio_btn_addnewcard.addProperty("xpath",ConditionType.EQUALS, radio_btn_addnewcard_xpath)

		List<WebElement> l1 = WebUI.findWebElements(radio_btn_addnewcard,5);

		println('List size : '+l1.size())

		WebUI.delay(3)

		if(l1.size()!=0) {
			flag = true;
			println('111 Flag : '+flag)
			println('Existing cards not Added and Available')
		}
		else {

			flag =false;
			println('222 Flag : '+flag)
			println('Existing acards added and are avaialble')
		}

		return flag;
	}

	@Keyword
	public void click_on_the_profile_page_Popup_cancel_Button(TestObject popup_cancel_Button) {
		List<WebElement> list_popup_cancel_Btn = WebUI.findWebElements(popup_cancel_Button,5);

		if(list_popup_cancel_Btn.size()!=0) {
			list_popup_cancel_Btn.get(0).click();
		}
	}

	@Keyword
	public String generate_Random_FirstName() {
		Faker faker = new Faker();
		String name = faker.name().fullName();
		String firstName = faker.name().firstName();

		return firstName
	}

	@Keyword
	public String generate_Random_LastName() {
		Faker faker = new Faker();
		String name = faker.name().fullName();
		String lastName = faker.name().lastName();

		return lastName
	}

	@Keyword
	public String generate_Random_EmailId(String fName) {

		String Email_id = fName +"@maildrop.cc";
		return Email_id
	}

	/**
	 * Custom Keyword to clear text from an input field using Ctrl+A and Backspace
	 * @param element The WebElement of the input field
	 */
	@Keyword
	def clearText(TestObject testObject) {

		WebElement element = WebUiBuiltInKeywords.findWebElement(testObject);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE)
		KeywordUtil.logInfo("cleared the text")
		WebUI.sendKeys(findTestObject(testObject), Keys.chord(
				Keys.CONTROL, 'a') + Keys.BACK_SPACE)
	}


	@Keyword
	def clickUsingJS(TestObject to) {
		WebDriver webDriver = DriverFactory.getWebDriver();
		try {
			WebElement webElement = WebUIAbstractKeyword.findWebElement(to)

			webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS)
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			Thread thread = new Thread(){
						public void run(){
							executor.executeScript("arguments[0].click();", webElement)
						}
					}
			thread.start();
		} catch (ScriptTimeoutException e) {
		} finally {
			webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS)
		}
	}


	@Keyword
	def validatePopupMessage(TestObject popupObject, String expectedMessage) {
		try {
			// Wait for the pop-up to appear
			boolean isPopupVisible = WebUI.waitForElementVisible(popupObject, 10)

			if (isPopupVisible) {
				// Get the actual message text from the pop-up
				String actualMessage = WebUI.getText(popupObject)

				// Log the actual message
				WebUI.comment("Actual Pop-Up Message: " + actualMessage)
				println('actualMessage :'+actualMessage)
				// Validate the message
				if (actualMessage.equals(expectedMessage)) {
					WebUI.comment("Pop-up validation passed: " + actualMessage)
				} else {
					KeywordUtil.markFailed("Unexpected pop-up message. Expected: '" + expectedMessage + "', but found: '" + actualMessage + "'")
					println('actualMessage :'+expectedMessage)
					}
			} else {
				KeywordUtil.markFailed("Pop-up not visible within the timeout period.")
				
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Error handling pop-up: " + e.getMessage())
		}
	}
}