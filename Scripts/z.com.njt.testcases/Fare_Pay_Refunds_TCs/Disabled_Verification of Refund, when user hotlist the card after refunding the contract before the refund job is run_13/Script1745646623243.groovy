import internal.GlobalVariable as GlobalVariable
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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('com.login.page/Login_Into_NJT_LoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Unregistered_fare_pay_card'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_FP_Card_details_Purchase'), [:], FailureHandling.STOP_ON_FAILURE)

String farePayCardNumber = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/FarePayCardNumberXpath'))

String actualCardNumber = farePayCardNumber.replaceAll('-', '')

println(actualCardNumber)

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

String referenceNumber = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/reference'))

println(referenceNumber)

String[] parts = referenceNumber.split(': ')

String textPart = parts[0]

String actualRefnumberPart = parts[1]

println(actualRefnumberPart)

WebUI.executeJavaScript(('window.open(\'' + GlobalVariable.ADMIN_PORTAL_URL) + '\', \'_blank\')', [])

WebUI.switchToWindowIndex(1)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.delay(2)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Guest_FarePayCard_TAB'))

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/farePayCardNumberSearchField'), actualCardNumber)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/searchButton'))

WebUI.scrollToElement(findTestObject('Fare_Card_Refund_Object_Repo/hotlistFarePayCard'), 10)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/hotlistFarePayCard'))

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/hotListDropDown'))

WebUI.delay(2)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/hotListReason'))

String commentBoxText = CustomKeywords.'kw_web.kw_Random.generateRandomString'(10)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/commentBoxText'), commentBoxText)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/saveButton'))

WebUI.delay(1)

String succesfulHotlistText = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/succesfulHotListText'))

WebUI.verifyEqual(succesfulHotlistText, 'Hotlist Fare Card is successful')

WebUI.switchToWindowIndex(0)

String hotListStatus = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/hotListStatusnCustomerPortal'))

WebUI.verifyEqual(hotListStatus, 'Defective')

WebUI.delay(60)

dbConnection = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_MySQL_Web_DBConnection'(GlobalVariable.NJT_Web_DB_Url, 
    GlobalVariable.NJT_Web_DB_UserName, GlobalVariable.NJT_Web_DB_Password)

String query = ('select * from p_web_trx_refunds where ID = \'' + actualRefnumberPart) + '\' order by ID desc;'

fromDBReferenceNumber = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_Reference_ID_Details'(dbConnection, query)

WebUI.verifyEqual(actualRefnumberPart, fromDBReferenceNumber)

refundStatusfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_STATUS_Details'(dbConnection, query)

println('Refund Status' + refundStatusfromDB)

WebUI.verifyEqual('REJECTED', refundStatusfromDB)

refundAmountfromDB = CustomKeywords.'com.web.db.NJT_Web_Database_Refunds.get_REFUND_AMOUNT_Details'(dbConnection, query)

WebUI.verifyEqual(refundAmountfromDB, 0)

WebUI.comment('Test Verification is Completed to Avoid Next Test case Failure again UnHotlist the Card.....')

WebUI.switchToWindowIndex(1)

WebUI.refresh()

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/Guest_FarePayCard_TAB'))

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/farePayCardNumberSearchField'), actualCardNumber)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/searchButton'))

WebUI.scrollToElement(findTestObject('Fare_Card_Refund_Object_Repo/unHotlistFareCard'), 10)

WebUI.setText(findTestObject('Fare_Card_Refund_Object_Repo/commentBoxText'), commentBoxText)

WebUI.click(findTestObject('Fare_Card_Refund_Object_Repo/saveButton'))

WebUI.delay(1)

String succesfulHotlistText = WebUI.getText(findTestObject('Fare_Card_Refund_Object_Repo/UnHotListText'))

WebUI.verifyEqual(succesfulHotlistText, 'De-Hotlist Fare card is successful')

WebUI.closeBrowser()

