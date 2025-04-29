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

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/ProfileTAB'))

String userEmail = WebUI.getText(findTestObject('FarePay_Card_ObjectRepo/EmailTextfromProfileTAB'))

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/FarePayCard_TAB'))

String farePayCardNumber = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/FarePayCardNumberXpath'))

String actualCardNumber = farePayCardNumber.replaceAll('-', '')

println(actualCardNumber)

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Buy Tickets'), 0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Buy Tickets'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_Bus'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/svg__MuiSvgIcon-root MuiSvgIcon-fontSizeMed_b3633d'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/li_2-Jersey City - Journal Square - Secaucus'))

WebUI.delay(1)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/clickOnSelectTicketForBus'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/input_Fare_r9'))

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

WebUI.delay(2)

WebUI.executeJavaScript(('window.open(\'' + GlobalVariable.ADMIN_PORTAL_URL) + '\', \'_blank\')', [])

WebUI.switchToWindowIndex(1)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/input_Guest - FARE-PAY Card_emailId'), userEmail)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Search'))

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/ClickOnEmail_fromAdmin'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_FARE-PAY Card'))

WebUI.scrollToElement(findTestObject('Fare_Card_Admin_Object_Repo/button_Get Transactions History'), 0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Get Transactions History'))

WebUI.scrollToPosition(200, 400)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_TR'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/p_Create Note'), 'Create Note')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/p_Please provide the reason in the below co_e38858'), 
    'Please provide the reason in the below comments section')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/p_Your comments must be at least 5 characters'), 
    'Your comments must be at least 5 characters.')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/p_Note Refunded amount will be added to the_30a9bd'), 
    'Note: Refunded amount will be added to the card value')

WebUI.setText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/textarea_Testt'), 'Testt')

WebUI.verifyElementPresent(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Cancel'), 0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Save'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/div_Refund ticket successful'), 'Refund ticket successful')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/a_Refund Pending'), 'Refund Pending')

WebUI.delay(2)

String refundAmount = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/Admin_Amount'))

String refundDatefromUI = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/Admin_Trnx_DateandTime'))

formatedCorrectDatefromUI = refundDatefromUI.replace('|', '').replaceAll('\\s+', ' ').trim()

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/clickOnPendingRefund'))

refNumber = WebUI.getText(findTestObject('FarePay_Card_ObjectRepo/RefundRefNumber'))

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/ClosePopup'))

dbConnection = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_MySQL_Web_DBConnection'(GlobalVariable.NJT_Web_DB_Url, 
    GlobalVariable.NJT_Web_DB_UserName, GlobalVariable.NJT_Web_DB_Password)

String query = ('select * from p_web_trx_refunds where ID = \'' + refNumber) + '\' order by ID desc;'

refundStatusfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATUS_Details'(dbConnection, query)

println('Refund Status' + refundStatusfromDB)

WebUI.verifyEqual('INIT', refundStatusfromDB)

refundDATEfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_DATE_Details'(dbConnection, query)

println('UI Date format is: ' + formatedCorrectDatefromUI)

println('DB Date format is: ' + refundDATEfromDB)

SimpleDateFormat uiDateFormat = new SimpleDateFormat('MM/dd/yyyy HH:mm:ss')

SimpleDateFormat dbDateformat = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

// Parse both the UI and DB date strings into Date objects
Date uiRefundDate = uiDateFormat.parse(formatedCorrectDatefromUI)

Date dbRefundDate = dbDateformat.parse(refundDATEfromDB)

usernamefromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_USER_ID_Details'(dbConnection, query)

refundStatefromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATE_Details'(dbConnection, query)

WebUI.verifyEqual('2', refundStatefromDB)

WebUI.refresh()

WebUI.delay(Integer.parseInt(GlobalVariable.RefundDelayTime))

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/input_Guest - FARE-PAY Card_emailId'), userEmail)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Search'))

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/ClickOnEmail_fromAdmin'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_FARE-PAY Card'))

WebUI.scrollToElement(findTestObject('Fare_Card_Admin_Object_Repo/button_Get Transactions History'), 0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Admin_Object_Repo/button_Get Transactions History'))

WebUI.scrollToPosition(200, 400)

String trnStatus = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/Admin_Trnx_Status'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(trnStatus, 'Refund Completed')

WebUI.click(findTestObject('Fare_Card_Admin_Object_Repo/Admin_Trnx_Status'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetailsPopup'), 'Refund Details')

WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetails_Popup_Date'), FailureHandling.STOP_ON_FAILURE)

String fromUIRefenceNumber = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetails_Popup_ReferenceNum'), 
    FailureHandling.STOP_ON_FAILURE)

String refundAmountfromDefundDetails = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/refundAmountText'))

String actual_RefundAmount = refundAmountfromDefundDetails.substring(1, refundAmount.length())

String originalPassRefundAmount = actual_RefundAmount.replaceAll('[^\\d.]', '')

double formatedoriginalPassRefundAmount = Double.parseDouble(originalPassRefundAmount)

int refundPassAmountInCents = ((Math.round(formatedoriginalPassRefundAmount * 100)) as int)

// Print the result in cents
println('Refund amount in cents: ' + refundPassAmountInCents)

refundAmountfromDB1 = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_AMOUNT_Details'(dbConnection, query)

WebUI.verifyMatch(Integer.toString(refundPassAmountInCents), refundAmountfromDB1, false)

fromDBReferenceNumber = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_Reference_ID_Details'(dbConnection, query)

WebUI.verifyEqual(refNumber, fromDBReferenceNumber)

WebUI.closeBrowser()

