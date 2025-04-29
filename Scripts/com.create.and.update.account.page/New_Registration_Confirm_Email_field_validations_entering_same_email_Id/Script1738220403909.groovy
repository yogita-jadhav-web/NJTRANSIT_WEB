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

//Confirm Email field should be marked mandatory
TestObject Email_Text = findTestObject('Page_Create Account  NJ Transit/label_Confirm Email')

String EmailId_Text = WebUI.getText(Email_Text)

println('labelText :' + EmailId_Text)

WebUI.verifyMatch(EmailId_Text, 'Confirm Email *', false)

// Verify the placeholder value
TestObject Email_placeholder = findTestObject('UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_Confirm Email')

WebUI.verifyElementAttributeValue(Email_placeholder, 'placeholder', 'Confirm Email', 10)

WebUI.setText(Email_placeholder, GlobalVariable.Email)

TestObject msgxpath = findTestObject('Page_Create Account  NJ Transit/p_Email and Confirm Email must be same')

boolean isErrorMessagePresent = WebUI.verifyElementNotPresent(msgxpath, 3, FailureHandling.OPTIONAL)

// Log the result
if (isErrorMessagePresent) {
    println('Validation Passed: No error message displayed.')

    WebUI.comment('Validation Passed: No error message displayed.')
} else {
    println('Validation Failed: Error message is still visible.')
}
