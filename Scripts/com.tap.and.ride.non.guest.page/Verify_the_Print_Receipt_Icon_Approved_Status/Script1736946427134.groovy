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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


String statusText = WebUI.getText(findTestObject('Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/div_Approved'))

KeywordUtil.logInfo("statusText: $statusText")

if (statusText.equalsIgnoreCase("Approved")) {
	println("Status is Approved")

	
	TestObject printIconElement = findTestObject('Page_Tap  Ride Dashboard  NJ Transit/button_NJT-Print_receiptBtn') 
	
	boolean isPrintIconPresent = WebUI.verifyElementPresent(printIconElement, 10, FailureHandling.CONTINUE_ON_FAILURE)

	
	if (isPrintIconPresent && WebUI.verifyElementClickable(printIconElement, FailureHandling.CONTINUE_ON_FAILURE)) {
		
		println("Print receipt Icon is present and clickable")
		WebUI.click(printIconElement)
		
	} else {
		println("Print receipt Icon is not clickable or not present")
	}
} else {
	println("Status is not Approved")
}