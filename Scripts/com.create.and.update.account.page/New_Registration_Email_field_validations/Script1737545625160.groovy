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
TestObject Email_Text = findTestObject('Page_Create Account  NJ Transit/label_Email')

String EmailId_Text = WebUI.getText(Email_Text)

println('labelText :' + EmailId_Text)

WebUI.verifyMatch(EmailId_Text, 'Email *', false)

// Verify the placeholder value
TestObject Email_placeholder = findTestObject('Object Repository/UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_Email')

WebUI.verifyElementAttributeValue(Email_placeholder, 'placeholder', 'Email', 10)

//Enter a single character in the first name field
alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 1)

println('alphabets : ' + alphabets)

WebUI.setText(Email_placeholder, alphabets)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Email is too short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Email_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter a numbers in the first name field
numbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 10)

println('numbers : ' + numbers)

WebUI.setText(Email_placeholder, numbers)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Invalid Email'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Email_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter special_characters
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 8)

println('special_characters : ' + special_characters)

WebUI.setText(Email_placeholder, special_characters)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Invalid Email'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter data and clear the first name field
WebUI.sendKeys(Email_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Email is required'), [:], FailureHandling.STOP_ON_FAILURE)

