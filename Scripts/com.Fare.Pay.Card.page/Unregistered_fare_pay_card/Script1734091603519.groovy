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

TestObject UNREGISTER_CARD = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_UnregisterCard')

try {
    if (WebUI.waitForElementVisible(UNREGISTER_CARD, 10, FailureHandling.OPTIONAL)) {
        WebUI.comment('UNREGISTER_CARD is visible')

        WebUI.click(UNREGISTER_CARD, FailureHandling.OPTIONAL)

        WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Yes'), FailureHandling.OPTIONAL)

        WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Your_FARE_PAY_card_has_been_unregistered_successfully'), 
            [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(12)
    } else {
        WebUI.comment('UNREGISTER_CARD is not visible')
    }
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.message)

    WebUI.verifyEqual(true, false, FailureHandling.STOP_ON_FAILURE)
} 

