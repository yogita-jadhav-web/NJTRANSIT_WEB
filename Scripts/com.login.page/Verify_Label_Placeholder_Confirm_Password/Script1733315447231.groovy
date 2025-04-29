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

WebUI.verifyElementText(findTestObject('ForgotPassword_Object_Repository/Page_Reset Password  NJ Transit/span_Confirm Password'), 
    'Confirm Password')

WebUI.verifyElementVisible(findTestObject('ForgotPassword_Object_Repository/Page_Reset Password  NJ Transit/input_Confirm Password'), 
    FailureHandling.STOP_ON_FAILURE)

def ConfirmpasswordField = findTestObject('ForgotPassword_Object_Repository/Page_Reset Password  NJ Transit/input_Confirm Password')

// Step 3: Get the placeholder text
String placeholderText = WebUI.getAttribute(ConfirmpasswordField, 'placeholder')

// Step 4: Verify the placeholder text
String expectedText = 'Password 8-20 alpha numeric characters'

assert placeholderText == expectedText

println('placeholderText :' + placeholderText)

