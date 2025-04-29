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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory


TestObject input_MSP=findTestObject('Page_Profile  NJ Transit/input_Manage Saved Payments')
// Loop until all cards are deleted
while (WebUI.verifyElementPresent(input_MSP, 5, FailureHandling.OPTIONAL)) {
   
    WebUI.click(findTestObject('Page_Profile  NJ Transit/input_Manage Saved Payments'))
    
	// Click the delete button
	WebUI.click(findTestObject('Page_Profile  NJ Transit/button_Delete'))

	// Confirm the deletion
	WebUI.click(findTestObject('Page_Profile  NJ Transit/button_Yes'))

	if (WebUI.verifyElementPresent(findTestObject('Page_Profile  NJ Transit/div_Payment Card Deleted Successfully'),
		5, FailureHandling.OPTIONAL)) {
		// Log the success message
		String Msg_text = WebUI.getText(findTestObject('Page_Profile  NJ Transit/div_Payment Card Deleted Successfully'))

		WebUI.comment('Message: ' + Msg_text)

		println('Message: ' + Msg_text)

		WebUI.delay(10)
		}
}

// Verify no cards remain
boolean isCardListEmpty = WebUI.verifyElementNotPresent(findTestObject('Page_Profile NJ Transit/input_Manage Saved Payments'), 5, FailureHandling.OPTIONAL)

if (isCardListEmpty) {
    println("All saved cards have been deleted.")
	WebUI.comment('All saved cards have been deleted.')
} 