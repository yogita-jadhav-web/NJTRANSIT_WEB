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

WebUI.callTestCase(findTestCase('com.profile.page/Delete_Credit_Card_From_Manage_Saved_Payments'), [:], FailureHandling.OPTIONAL)

String script = 'window.scrollTo(0, -200);'

WebUI.executeJavaScript(script, null)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_on_fare_pay_card_tab'), [:], FailureHandling.STOP_ON_FAILURE)

String beforeRefundCartValue = WebUI.getText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/cardValue'))

String initialCardValue = beforeRefundCartValue.substring(1, beforeRefundCartValue.length())

String replacedinitialCardValue = initialCardValue.replaceAll('[^\\d.]', '')

double formatedCardValue = Double.parseDouble(replacedinitialCardValue)

println(formatedCardValue)

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Auto Reload'), 
    0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Auto Reload'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/ticketsTab'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/selectTicket'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/railOption'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__origin'), 
    'Allendale')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Allendale_1'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/input__destination'), 
    'Alle')

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Allenhurst'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/ClickOnViaOnAutoReload'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/li_Hoboken-NWK'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Continue'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/Rail_MothlyRadioButton'))

//String totalAmount = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/totalAmount'))
//
//String passTotalAmount = totalAmount.substring(1, totalAmount.length())
//
//String replacedPassTotalAmount = passTotalAmount.replaceAll('[^\\d.]', '')
//
//double formatedPassValue = Double.parseDouble(replacedPassTotalAmount)
WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/addNewCardRadioButton'))

WebUI.callTestCase(findTestCase('com.profile.page/Enter_Credit_Card_Details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_VISA_CC_Details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_Card_nickname_VISA'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/ClickOnConfimButton'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/div_NJ TRANSIT will automatically reload a _c300bc'), 
    'NJ TRANSIT will automatically reload a monthly pass to your FARE-PAY card account by last day of every month.')

WebUI.delay(Integer.parseInt(GlobalVariable.RefundDelayTime))

WebUI.refresh()

WebUI.delay(30)

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Tickets'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Tickets'), 
    'Tickets:')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Yes'), 
    'Yes')

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_TRX. History'), 
    0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_TRX. History'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Refund'))

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Refund Policy'), 
    'Refund Policy')

WebUI.verifyElementPresent(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/svg_Refund Policy_MuiSvgIcon-root MuiSvgIco_73a321'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_Prior to the first business day of the_8354d8'), 
    'Prior to the first business day of the calendar month/week you will receive a full refund. After the start of the month/week, if the refund is requested immediately following the purchase, the full amount charged for the monthly/weekly pass will be refunded. For all other refunds, the cost of two one-way tickets will be deducted from the refund amount for each business day you had the pass.')

WebUI.verifyElementText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/span_After refund, the ticket(s) will not b_2ef463'), 
    'After refund, the ticket(s) will not be available for use. Do you want to continue?')

WebUI.verifyElementPresent(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_No'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Yes'), 
    0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Yes'))

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

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/button_TRX. History'), 0)

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

String actualformatedTotalCardValue = formatedTotalCardValue.replaceAll('[^\\d.]', '')

double formatedFinalcardValue = Double.parseDouble(actualformatedTotalCardValue)

double totalPassandCardValue = formatedCardValue + formatedoriginalPassRefundAmount

println(totalPassandCardValue)

WebUI.verifyEqual(totalPassandCardValue, formatedFinalcardValue)

println('Test Passed Successfully....')

WebUI.refresh()

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Auto Reload'), 
    0)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Fare_Card_Refund_Object_Repo/button_Auto Reload'))

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/ticketsTab'))

WebUI.scrollToElement(findTestObject('Fare_Card_Refund_Object_Repo/AutoReloadCancelButton'), 0)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/AutoReloadCancelButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/CancelAutoReloadYesBTN'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

