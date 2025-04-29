import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

//Verify the label 
TestObject Country_Label = findTestObject('Page_Create Account  NJ Transit/label_Country')

String country_Text = WebUI.getText(Country_Label)

println('labelText :' + country_Text)

WebUI.verifyMatch(country_Text, 'Country *', false)

// Verify the placeholder value
TestObject coutry_code = findTestObject('Page_Create Account  NJ Transit/input_Country')

WebUI.sendKeys(coutry_code, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.verifyElementAttributeValue(coutry_code, 'placeholder', 'Search Country Name', 10)

//dropdown
WebUI.click(findTestObject('Page_Create Account  NJ Transit/div_'), FailureHandling.STOP_ON_FAILURE)

List<WebElement> country_options = WebUI.findWebElements(findTestObject('Page_Create Account  NJ Transit/li_Country_option'), 
    30)

int randomIndex = new Random().nextInt(country_options.size())

println('Country code should be :' + randomIndex)

WebElement randomOption = country_options.get(randomIndex)

randomOption.click()

WebUI.sendKeys(coutry_code, Keys.chord(Keys.TAB))

String selected_Option = WebUI.getAttribute(coutry_code, 'value')

WebUI.comment('Selected Option: ' + selected_Option)

println('Selected Option: ' + selected_Option)

