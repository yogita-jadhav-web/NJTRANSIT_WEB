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

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_BUY_TICKETS_Button'), [:], FailureHandling.STOP_ON_FAILURE)

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

String beforeRefundCartValue = WebUI.getText(findTestObject('Fare_Card_Admin_Object_Repo/Admin_cardValueAmount'))

String initialCardValue = beforeRefundCartValue.substring(1, beforeRefundCartValue.length())

String replacedinitialCardValue = initialCardValue.replaceAll('[^\\d.]', '')

double formatedCardValue = Double.parseDouble(replacedinitialCardValue)

println(formatedCardValue)

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

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/clickOnPendingRefund'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetailsPopup'), 'Refund Details')

WebUI.verifyElementPresent(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetails_Popup_Date'), 0)

WebUI.verifyElementPresent(findTestObject('Fare_Card_Admin_Object_Repo/RefundDetails_Popup_ReferenceNum'), 0)

WebUI.verifyElementPresent(findTestObject('Fare_Card_Admin_Object_Repo/refundAmountText'), 0)

WebUI.click(findTestObject('FarePay_Card_ObjectRepo/ClosePopup'))

WebUI.comment('Test Verification is Completed Wainting for the successful Refund ')

WebUI.delay(Integer.parseInt(GlobalVariable.RefundDelayTime))

WebUI.closeBrowser()

