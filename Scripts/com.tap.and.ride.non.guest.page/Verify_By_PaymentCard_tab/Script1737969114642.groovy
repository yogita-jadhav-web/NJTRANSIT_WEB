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

TestObject bypaymentcard = findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/button_By Payment Card')

WebUI.verifyElementAttributeValue(bypaymentcard, 'aria-selected', 'true', 10)

WebUI.comment('By default by payment card option should be selected')

WebUI.callTestCase(findTestCase('com.auto.reload.page/Denotes_Required_Field'), [:], FailureHandling.STOP_ON_FAILURE)

msg = WebUI.getText(findTestObject('Object Repository/TapAndRide_Object_Repository/Verify_By_payment_Card_Object_Repository/Page_Add Payment Card  NJ Transit/span_Please enter your credit card information below'))

WebUI.comment('msg :' + msg)

TestObject cardNo_label = findTestObject('Page_Add Payment Card  NJ Transit/label_Card Number')

String cc_Text = WebUI.getText(cardNo_label)

println('labelText :' + cc_Text)

WebUI.verifyMatch(cc_Text, 'Card Number *', false)

WebUI.callTestCase(findTestCase('com.tap.and.ride.guest.page/validate_all_cards_logo'), [:], FailureHandling.STOP_ON_FAILURE)

TestObject InputccNo = findTestObject('Object Repository/TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/input_Card Number')

// Get the maxlength attribute value
String maxLength = WebUI.getAttribute(InputccNo, 'maxlength')
println('maxLength :' + maxLength)

// Verify if maxlength is 16
//assert maxLength == '16' : 'Max length is not 16, actual: ' + maxLength
WebUI.verifyElementAttributeValue(InputccNo, 'maxlength', '16', 10)
println('maxLength card number :' + maxLength)

WebUI.verifyElementText(findTestObject('Object Repository/TapAndRide_Object_Repository/Verify_By_payment_Card_Object_Repository/Page_Add Payment Card  NJ Transit/span_Exp. Month'), 
    'Exp. Month')

WebUI.verifyElementText(findTestObject('Object Repository/TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/span_Exp. Year'), 
    'Exp. Year')

