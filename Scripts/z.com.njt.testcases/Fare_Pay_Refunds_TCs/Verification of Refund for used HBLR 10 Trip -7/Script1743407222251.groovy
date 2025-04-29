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

WebUI.callTestCase(findTestCase('com.login.page/Login_Into_NJT_LoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Unregistered_fare_pay_card'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_FP_Card_details_Purchase'), [:], FailureHandling.STOP_ON_FAILURE)

String beforeRefundCartValue = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/cardValue'))

String initialCardValue = beforeRefundCartValue.substring(1, beforeRefundCartValue.length())

String replacedinitialCardValue = initialCardValue.replaceAll('[^\\d.]', '')

double formatedCardValue = Double.parseDouble(replacedinitialCardValue)

println(formatedCardValue)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_BUY_TICKETS_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Light Rail'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/svg__MuiSvgIcon-root MuiSvgIcon-fontSizeMed_b3633d'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/li_Hudson Bergen Light Rail'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Select Tickets'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_HBLR'), 'HBLR')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Fare_r8'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/td_10 Trip Adult'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/td_10 Trip Adult'), '10 Trip Adult')

String totalAmount = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/totalAmount'))

String passTotalAmount = totalAmount.substring(1, totalAmount.length())

String replacedPassTotalAmount = passTotalAmount.replaceAll('[^\\d.]', '')

double formatedPassValue = Double.parseDouble(replacedPassTotalAmount)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Proceed To Checkout'))

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/addNewCardRadioButton'))

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

WebUI.comment('Test Verification is Completed to avoid the next Test case failure Initiating the Refund.....')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund Policy'), 'Refund Policy')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_No'), 'NO')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'), 'YES')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'))

WebUI.delay(60)

WebUI.closeBrowser()

