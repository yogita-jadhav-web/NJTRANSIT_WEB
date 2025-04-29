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

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_TrxHistory_Button'), [:], FailureHandling.STOP_ON_FAILURE)

TestObject refundButton = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Refund')

if (WebUI.verifyElementPresent(refundButton, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.comment('The Refund button is displayed.')

    WebUI.click(refundButton)

    WebUI.click(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_Yes'))

    Refund_msg = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/div_Your refund request has been successful_f91977'))

    WebUI.comment('Refund_msg :' + Refund_msg)

    println('Refund_msg :' + Refund_msg)

    WebUI.delay(10)
} else {
    WebUI.comment('The Refund button is NOT displayed.')

    println('Refund button is not displayed.')
}

CustomKeywords.'com.puttyconnection.Start_putty.closePuTTY'()

