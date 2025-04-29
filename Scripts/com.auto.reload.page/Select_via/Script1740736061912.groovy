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


TestObject selectvia=findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Select Via')

try {
	if (WebUI.waitForElementVisible(selectvia, 10, FailureHandling.OPTIONAL)) {
		WebUI.comment('select via is visible')

		WebUI.click(selectvia)
		WebUI.click(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_Hoboken-NWK'))
		
	} else {
		WebUI.comment('select via is not visible')
	}
}
catch (Exception e) {
	WebUI.comment('Error occurred: ' + e.message)

	WebUI.verifyEqual(true, false, FailureHandling.STOP_ON_FAILURE)
}

