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

WebUI.callTestCase(findTestCase('com.login.page/Launch_NJT_Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Enter_Valid_Email_Id_2'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Enter_Valid_Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotVisible(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/div_FARE-PAY card balance is low. Please re_b29829'), 
    5)

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

WebUI.verifyElementText(findTestObject('Fare_Card_Refund_Object_Repo/riverLineText'), 'River Line')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Fare_r8'))

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

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Refund Policy'), 'Refund Policy')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_Unused Ten-Trip tickets will be refund_28820b'), 
    'Unused Ten-Trip tickets will be refunded at the purchase price.')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_After refund, the ticket(s) will not b_2ef463'), 
    'After refund, the ticket(s) will not be available for use. Do you want to continue?')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/span_After refund, the ticket(s) will not b_2ef463'), 
    'After refund, the ticket(s) will not be available for use. Do you want to continue?')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_No'), 'NO')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'), 'YES')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Yes'))

String refundRequestText = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/reFundrequestText'))

WebUI.verifyElementText(findTestObject('Fare_Card_Refund_Object_Repo/reFundrequestText'), refundRequestText)

String referenceNumber = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/reference'))

println(referenceNumber)

String[] parts = referenceNumber.split(': ')

String textPart = parts[0]

String actualRefnumberPart = parts[1]

println(actualRefnumberPart)

dbConnection = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_MySQL_Web_DBConnection'(GlobalVariable.NJT_Web_DB_Url, 
    GlobalVariable.NJT_Web_DB_UserName, GlobalVariable.NJT_Web_DB_Password)

String query = ('select * from p_web_trx_refunds where ID = \'' + actualRefnumberPart) + '\' order by ID desc;'

fromDBReferenceNumber = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_Reference_ID_Details'(dbConnection, query)

WebUI.verifyEqual(actualRefnumberPart, fromDBReferenceNumber)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Refund Pending'), 'Refund Pending')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Refund Pending'))

refundStatusfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATUS_Details'(dbConnection, query)

println('Refund Status' + refundStatusfromDB)

WebUI.verifyEqual('INIT', refundStatusfromDB)

appTypefromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_APP_TYPE_Details'(dbConnection, query)

WebUI.verifyEqual('1', appTypefromDB)

usernamefromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_USER_ID_Details'(dbConnection, query)

WebUI.verifyEqual(GlobalVariable.EMAIL_2, usernamefromDB)

String refundDatefromUI = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/transactionHistoryRefundDate'))

refundDATEfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_DATE_Details'(dbConnection, query)

println('UI Date format is: ' + refundDatefromUI)

println('DB Date format is: ' + refundDATEfromDB)

SimpleDateFormat uiDateFormat = new SimpleDateFormat('MM/dd/yyyy HH:mm:ss')

SimpleDateFormat dbDateformat = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

// Parse both the UI and DB date strings into Date objects
Date uiRefundDate = uiDateFormat.parse(refundDatefromUI)

Date dbRefundDate = dbDateformat.parse(refundDATEfromDB)

// Compare the dates
WebUI.verifyEqual(uiRefundDate, dbRefundDate)

refundAmountfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_AMOUNT_Details'(dbConnection, query)

String pendingRefundAmount = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/transactionHistoryrefundAmount'))

String orginalPendingRefundAmount = pendingRefundAmount.substring(1, pendingRefundAmount.length())

double formatedoriginalPendingAmount = Double.parseDouble(orginalPendingRefundAmount)

int originalrefundAmountInCents = ((Math.round(formatedoriginalPendingAmount * 100)) as int)

// Print the result in cents
println('Refund amount in cents: ' + originalrefundAmountInCents)

WebUI.verifyEqual(originalrefundAmountInCents, refundAmountfromDB)

refundStatefromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATE_Details'(dbConnection, query)

WebUI.verifyEqual('7', refundStatefromDB)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Close'))

WebUI.delay(Integer.parseInt(GlobalVariable.RefundDelayTime))

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_TRX. History'))

WebUI.verifyElementPresent(findTestObject('Fare_Card_Refund_Object_Repo/refundCompletedLink'), 2)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/refundCompletedLink'))

String referenceNumber1 = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/transactionHistoryReferenceNumber'))

WebUI.verifyMatch(fromDBReferenceNumber, referenceNumber1, false)

String refundAmount = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/transactionHistoryrefundAmount'))

String actual_RefundAmount = refundAmount.substring(1, refundAmount.length())

String originalPassRefundAmount = actual_RefundAmount.replaceAll('[^\\d.]', '')

double formatedoriginalPassRefundAmount = Double.parseDouble(originalPassRefundAmount)

int refundPassAmountInCents = ((Math.round(formatedoriginalPassRefundAmount * 100)) as int)

// Print the result in cents
println('Refund amount in cents: ' + refundPassAmountInCents)

refundAmountfromDBafterSuccessful = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_AMOUNT_Details'(dbConnection, 
    query)

WebUI.verifyMatch(Integer.toString(refundPassAmountInCents), refundAmountfromDBafterSuccessful, false)

refundcompletedStatusfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATUS_Details'(dbConnection, 
    query)

println('Refund Status' + refundcompletedStatusfromDB)

WebUI.verifyEqual('COMPLETED', refundcompletedStatusfromDB)

WebUI.refresh()

WebUI.delay(2)

String afterRefundtotalCardValue = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/cardValue'))

String formatedTotalCardValue = afterRefundtotalCardValue.substring(1, afterRefundtotalCardValue.length())

double formatedFinalcardValue = Double.parseDouble(formatedTotalCardValue)

double totalPassandCardValue = formatedCardValue + formatedPassValue

println(totalPassandCardValue)

WebUI.verifyEqual(totalPassandCardValue, formatedFinalcardValue)

println('Test Pass Successfully....')

