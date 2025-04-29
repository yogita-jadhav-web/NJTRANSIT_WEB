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
TestObject Phn_Text = findTestObject('Page_Create Account  NJ Transit/label_Phone')

String pn_Text = WebUI.getText(Phn_Text)

println('labelText :' + pn_Text)

WebUI.verifyMatch(pn_Text, 'Phone *', false)

// Verify the placeholder value
TestObject Pn_placeholder = findTestObject('UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_Phone')

WebUI.verifyElementAttributeValue(Pn_placeholder, 'placeholder', 'Phone', 10)

//Enter 4 digit Phone number
fourdigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 4)

println('fourdigitnumbers : ' + fourdigitnumbers)

WebUI.setText(Pn_placeholder, fourdigitnumbers)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Phone Number is too short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Pn_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter more than 11 digit Phone number
Eledigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 11)

println('Eledigitnumbers : ' + Eledigitnumbers)

WebUI.setText(Pn_placeholder, Eledigitnumbers)

String actualText = WebUI.getAttribute(Pn_placeholder, 'value')

println('actualText :' + actualText)

// Verify that only 50 characters are allowed
assert actualText.length() == 10 : 'Field allows more than 10 characters'

WebUI.comment('Field allows maximum 10 characters')

WebUI.sendKeys(Pn_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Special characters validation:Enter 10 digit special characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 10)

println('special_characters : ' + special_characters)

WebUI.setText(Pn_placeholder, special_characters)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Invalid Phone Number'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter data and clear the first name field
WebUI.sendKeys(Pn_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Special characters validation:Enter less that 10 digit special characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 6)

println('special_characters : ' + special_characters)

WebUI.setText(Pn_placeholder, special_characters)

not_run: WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Phone Number is invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Phone Number is too short'), [:], FailureHandling.STOP_ON_FAILURE)

//Leave the phone number field blank
WebUI.sendKeys(Pn_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Phone Number is required'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter 10 digit Phone number
tendigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 10)

println('10 digit : ' + tendigitnumbers)

WebUI.setText(Pn_placeholder, tendigitnumbers)

String actualPhoneNumber = WebUI.getAttribute(Pn_placeholder, 'value')

assert actualPhoneNumber == tendigitnumbers : 'Phone number should be accepted and no validation should be displayed'

