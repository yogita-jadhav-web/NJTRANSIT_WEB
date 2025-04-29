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

TestObject unregistered_card = findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/span_UnregisterCard')

WebUI.click(unregistered_card, FailureHandling.OPTIONAL)

msg_text = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_If you Unregister your FARE-PAY card, all your Auto Reload associated with it will be cancelled. Do you want to continueNoYes'))

WebUI.comment('msg_text :' + msg_text)

println('msg_text :' + msg_text)

try {
    if (WebUI.waitForElementVisible(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_No'), 10, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_No'))

        WebUI.comment('Unregister Card pop up should be closed')
    }
    
    if (WebUI.waitForElementVisible(unregistered_card, 10, FailureHandling.OPTIONAL)) {
        WebUI.click(unregistered_card, FailureHandling.OPTIONAL)

        WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Yes'), FailureHandling.OPTIONAL)

        WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Your_FARE_PAY_card_has_been_unregistered_successfully'), 
            [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(15)
    }
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.message)
}