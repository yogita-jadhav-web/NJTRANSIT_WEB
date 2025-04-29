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
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.callTestCase(findTestCase('com.login.page/Login_Into_NJT_LoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Unregistered_fare_pay_card'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_FP_Card_details_Purchase'), [:], FailureHandling.STOP_ON_FAILURE)

String beforeRefundCartValue = WebUI.getText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/cardValue'))

String initialCardValue = beforeRefundCartValue.substring(1, beforeRefundCartValue.length())

String replacedinitialCardValue = initialCardValue.replaceAll('[^\\d.]', '')

double formatedCardValue = Double.parseDouble(replacedinitialCardValue)

println(formatedCardValue)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_BUY_TICKETS_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__origin'), 
    'Hackettstown')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Hackettstown'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__destination'), 
    'leb')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Lebanon'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__destination'), 
    'Lebanon')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/clickOnVIA'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/viaHoboken-NWK_Station'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Select Tickets'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/HobokenWeeklyRadioBTN'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Checkout'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/addNewCardRadioButton'))

String randomString = CustomKeywords.'kw_web.kw_Random.generateRandomString'(5)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_concat(Cardholder, , s Name)_ccHolderName'), 
    randomString)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Card Number_ccDigits'), GlobalVariable.Visa_CC)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/expYear'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/li_2032'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_CVV_cvv'), GlobalVariable.CC_Cvv)

String randomZipCode = CustomKeywords.'kw_web.kw_Random.generateRandomNDigitNumber'(5)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Zip Code_zip'), randomZipCode)

WebUI.verifyElementClickable(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Pay'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Pay'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/div_Purchase successful. Please check your _2650cc'), 
    'Purchase successful. Please check your transaction history for more information on your tickets, and check your email for the transaction receipt.')

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_TRX. History'), 10)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_TRX. History'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/th_ActionStatus'), 'Action/Status')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund'), 'Refund')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund Policy'), 'Refund Policy')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_No'), 'NO')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'), 'YES')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'))

WebUI.refresh()

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_BUY_TICKETS_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__origin'), 
    'Hackettstown')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Hackettstown'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__destination'), 
    'leb')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Lebanon'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__destination'), 
    'Lebanon')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/clickOnVIA'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/viaHoboken-NWK_Station'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Select Tickets'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/HobokenWeeklyRadioBTN'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Checkout'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/addNewCardRadioButton'))

String randomString1 = CustomKeywords.'kw_web.kw_Random.generateRandomString'(5)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_concat(Cardholder, , s Name)_ccHolderName'), 
    randomString1)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Card Number_ccDigits'), GlobalVariable.Visa_CC)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/expYear'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/li_2032'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_CVV_cvv'), GlobalVariable.CC_Cvv)

String randomZipCode1 = CustomKeywords.'kw_web.kw_Random.generateRandomNDigitNumber'(5)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Zip Code_zip'), randomZipCode1)

WebUI.verifyElementClickable(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Pay'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Pay'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/div_You are only allowed to purchase one ti_64dc6d'), 
    'You are only allowed to purchase one ticket per validity period.')

WebUI.closeBrowser()

