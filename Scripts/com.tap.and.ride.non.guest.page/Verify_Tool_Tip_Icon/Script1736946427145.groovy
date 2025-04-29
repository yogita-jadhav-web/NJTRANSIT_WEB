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

String textMsg = WebUI.getText(findTestObject('Object Repository/Verify_Tool_Tip_Icon_Object_Repository/Page_Add Payment Card  NJ Transit/span_Register your card using Card Account'))

KeywordUtil.logInfo("textMsg: $textMsg")

println('textMsg : ' + textMsg)

WebUI.mouseOver(findTestObject('Object Repository/Verify_Tool_Tip_Icon_Object_Repository/Page_Add Payment Card  NJ Transit/svg_Too_Tip_Icon'))

TestObject dialog = findTestObject('Verify_Tool_Tip_Icon_Object_Repository/Page_Add Payment Card  NJ Transit/img__MuiBox-root css-vttnif')

boolean isDialogVisible = WebUI.waitForElementVisible(dialog, 0)

// Step 3: Validate the Dialog is Displayed
if (isDialogVisible) {
    WebUI.comment('The dialog appeared successfully.')

    println('The dialog appeared successfully.') // This will fail the test if the dialog is not visible
} else {
    WebUI.comment('The dialog did not appear.')

    WebUI.verifyElementVisible(dialog)
}

