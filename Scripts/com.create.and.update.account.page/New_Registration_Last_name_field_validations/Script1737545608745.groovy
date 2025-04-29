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

//Verify the label contains "First Name *"
TestObject LastNameField = findTestObject('Page_Create Account  NJ Transit/label_Last Name')

String LN_Text = WebUI.getText(LastNameField)

println('labelText :' + LN_Text)

WebUI.verifyMatch(LN_Text, 'Last Name *', false)

// Verify the placeholder value
TestObject LN_placeholder = findTestObject('Object Repository/UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_Last Name')

WebUI.verifyElementAttributeValue(LN_placeholder, 'placeholder', 'Last Name', 10)

//Enter a single character in the first name field
alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 1)

println('alphabets : ' + alphabets)

WebUI.setText(LN_placeholder, alphabets)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Last Name is too short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(LN_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter special_characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 8)

println('special_characters : ' + special_characters)

WebUI.setText(LN_placeholder, special_characters)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Invalid Last Name'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter data and clear the first name field
WebUI.sendKeys(LN_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Last Name is required'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter 52 alphabets in the first name field
maxalphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 52)

println('maxalphabets : ' + maxalphabets)

WebUI.setText(LN_placeholder, maxalphabets)

String actualText = WebUI.getAttribute(LN_placeholder, 'value')

println('actualText :' + actualText)

// Verify that only 50 characters are allowed
assert actualText.length() == 50 : 'Field allows more than 50 characters'

