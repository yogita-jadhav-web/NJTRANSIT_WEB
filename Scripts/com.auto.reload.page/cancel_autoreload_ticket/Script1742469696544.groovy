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

//ticket value
TestObject tkt_value = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_tkt_value')

tkt_value_text = WebUI.getText(tkt_value)

println('tkt_value Text :' + tkt_value_text)

WebUI.comment('Tickets value Text' + tkt_value_text)

try {
    if (tkt_value_text.equalsIgnoreCase('Yes')) {
        WebUI.callTestCase(findTestCase('com.auto.reload.page/click_on_Auto_Reload_Button'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('com.auto.reload.page/click_on_tickets_tab'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('com.auto.reload.page/click_on_Cancel_button'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_Yes_Button'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.callTestCase(findTestCase('com.auto.reload.page/Verify_Auto Reload cancellation successful'), [:], FailureHandling.STOP_ON_FAILURE)

        WebUI.comment('Auto reload cancellation successful.')
    } else {
        WebUI.comment('Auto Reload button NOT clicked because Tickets value is: ' + tkt_value_text)
    }
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.getMessage())

    WebUI.verifyEqual(true, false, FailureHandling.STOP_ON_FAILURE)
}