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

TestObject cancelButton = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Cancel')


// Validate if the buttons are disabled using "disabled" attribute
WebUI.scrollToElement(cancelButton, 0)

// Check if the Continue button is enabled
boolean isButtonEnabled = WebUI.verifyElementClickable(cancelButton, FailureHandling.OPTIONAL)

if (isButtonEnabled) {
	
	WebUI.comment('Cancel button is enabled.')
	println('Cancel button is enabled and clicked.')
} else {
	
	String buttonDisabled = WebUI.getAttribute(cancelButton, 'disabled')
	WebUI.comment('Disabled attribute value: ' + buttonDisabled)
	WebUI.comment('Cancel button is disabled.')
	println('Cancel button is disabled.')
}

// Check if the Modify button is enabled
TestObject ModifyButton = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_Modify')

 isButtonEnabled = WebUI.verifyElementClickable(ModifyButton, FailureHandling.OPTIONAL)

if (isButtonEnabled) {
	
	WebUI.comment('Modify button is enabled and clicked.')
	println('Modify button is enabled')
} else {
	
	String buttonDisabled = WebUI.getAttribute(ModifyButton, 'disabled')
	WebUI.comment('Disabled attribute value: ' + buttonDisabled)
	WebUI.comment('Modify button is disabled.')
	println('Modify button is disabled.')
}