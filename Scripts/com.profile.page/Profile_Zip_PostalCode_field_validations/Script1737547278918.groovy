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

//Verify the label 
TestObject zip_label = findTestObject('Page_Create Account  NJ Transit/label_ZipPostal Code')

String zip_text = WebUI.getText(zip_label)

println('labelText :' + zip_label)

WebUI.verifyMatch(zip_text, 'Zip/Postal Code *', false)

// Verify the placeholder value
TestObject zip_input = findTestObject('UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_ZipPostalCode')

WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.verifyElementAttributeValue(zip_input, 'placeholder', 'Zip/Postal Code', 10)

//Enter 4 digit Zip/Postal code
fourdigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 4)

println('fourdigitnumbers : ' + fourdigitnumbers)

WebUI.setText(zip_input, fourdigitnumbers)

WebUI.callTestCase(findTestCase('com.profile.page/verify_Invalid zip code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter more than 11 digit Zip/Postal code
Eledigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 15)

println('Eledigitnumbers : ' + Eledigitnumbers)

WebUI.callTestCase(findTestCase('com.profile.page/verify_Please enter a valid zip code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Special characters validation:Enter 6 digit special characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 5)

println('special_characters : ' + special_characters)

WebUI.setText(zip_input, special_characters)

WebUI.callTestCase(findTestCase('com.profile.page/verify_Invalid zip code'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter data and clear the first name field
WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Special characters validation:Enter less that 10 digit special characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 3)

println('special_characters : ' + special_characters)

WebUI.setText(zip_input, special_characters)

WebUI.callTestCase(findTestCase('com.profile.page/verify_Please enter a valid zip code'), [:], FailureHandling.STOP_ON_FAILURE)

//Leave the  Zip/Postal code field blank
WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.profile.page/verify_Please enter a valid zip code'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter 6 digit Zip/Postal code
fivedigitzip = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 5)

println('5 digit : ' + fivedigitzip)

WebUI.setText(zip_input, fivedigitzip)

String actualzipcode = WebUI.getAttribute(zip_input, 'value')

assert actualzipcode == fivedigitzip : 'Enter 5 digit Zip/Postal code should be accepted and no validation should be displayed'

println('actualzipcode: ' + actualzipcode)

