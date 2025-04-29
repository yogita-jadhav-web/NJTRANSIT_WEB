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

TestObject infoIcon = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/svg_InfoIcon')

WebUI.mouseOver(infoIcon)

TestObject dialog = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/p_FARE-PAY card balance is low. Please reload the amount')

boolean isDialogVisible = WebUI.waitForElementVisible(dialog, 0)

// Step 3: Validate the Dialog is Displayed
if (isDialogVisible) {
	Msg=WebUI.getText(dialog)
    WebUI.comment('The dialog appeared successfully with text : '+Msg)
	
    println('The dialog appeared successfully with text :'+ Msg)
} else {
    WebUI.comment('The dialog did not appear.')

    WebUI.verifyElementVisible(dialog)
}



