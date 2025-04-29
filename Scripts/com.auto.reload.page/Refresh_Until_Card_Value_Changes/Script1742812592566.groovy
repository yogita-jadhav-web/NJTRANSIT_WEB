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

TestObject cardvalue = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_cardvalue_amount')


// Get the initial value of the card
String initialValue = WebUI.getText(cardvalue)  // Replace with your TestObject

println "Initial Card Value: " + initialValue
WebUI.comment('Initial Card Value:' + initialValue)

WebUI.delay(30)
// Loop to refresh the page until value changes
while (true) {
	// Refresh the page
	WebUI.refresh()
	
	// Wait for the element to be visible
	WebUI.waitForElementVisible(cardvalue, 10)
	
	// Get the updated card value
	String updatedValue = WebUI.getText(cardvalue)

	
	// Break if the value has changed
	if (!updatedValue.equals(initialValue)) {
		
		println "Updated Card Value: " + updatedValue
		WebUI.comment('Updated Card Value:' + updatedValue)
		println "Value changed, breaking the loop."
		break
	}
	
	// Optional: Add a small wait to avoid excessive refresh
	WebUI.delay(30)
}