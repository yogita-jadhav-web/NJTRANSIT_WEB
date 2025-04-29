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


TestObject successMessageElement = findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/div_Value added to the card Successfully')
String expectedMessage = 'Value added to the card Successfully'

// Fetch the actual message text from the page
String actualMessage = WebUI.getText(successMessageElement, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Message text: ' + actualMessage)

// Validate if the message matches the expected text
if (actualMessage.equals(expectedMessage)) {
	WebUI.comment('The expected message was displayed: ' + expectedMessage)
	println('The expected message was displayed: ' + expectedMessage)
} else {
	WebUI.comment('Different message displayed: ' + actualMessage)
	println('Different message displayed: ' + actualMessage)
	// Optionally, you can add further validations or actions based on the different message
	WebUI.verifyElementText(successMessageElement, expectedMessage, FailureHandling.STOP_ON_FAILURE)
}

//WebUI.verifyElementText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/div_Value added to the card Successfully'),
//	'Value added to the card Successfully.')
//
//Message = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/div_Value added to the card Successfully'))
//
//WebUI.comment('Message :' +Message)
//println('Message :'+Message)

