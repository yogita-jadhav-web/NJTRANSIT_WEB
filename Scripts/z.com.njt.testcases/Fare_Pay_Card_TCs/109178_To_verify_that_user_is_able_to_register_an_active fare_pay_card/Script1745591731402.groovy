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

String farePayCardNumber = WebUI.getText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/FarePayCardNumberXpath'))

String actualCardNumber = farePayCardNumber.replaceAll('-', '')

println(actualCardNumber)

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Card Number'), 'Card Number')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Card Status'), 'Card Status')

not_run: WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Active Tickets'), 'Active Tickets')

not_run: WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Future Tickets'), 'Future Tickets')

WebUI.scrollToElement(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_TRX. History'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Card Value'), 'Card Value')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_Auto Reload'), 'Auto Reload')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_Buy Tickets'), 'BUY TICKETS')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_Auto Reload'), 'AUTO RELOAD')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_TRX. History'), 'TRX. HISTORY')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_Report LostStolen'), 'REPORT LOST/STOLEN')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/span_UNREGISTER CARD'), 'UNREGISTER CARD')

WebUI.verifyElementPresent(findTestObject('Object Repository/FarePay_Card_ObjectRepo/img_No_farecard_id'), 0)

WebUI.executeJavaScript(('window.open(\'' + GlobalVariable.ADMIN_PORTAL_URL) + '\', \'_blank\')', [])

WebUI.switchToWindowIndex(1)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/input_Guest - FARE-PAY Card_emailId'), GlobalVariable.Email)

WebUI.click(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_Search'))

WebUI.click(findTestObject('Object Repository/FarePay_Card_ObjectRepo/th_yogitajadhavmaildrop.cc'))

WebUI.click(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_FARE-PAY Card'))

String AdminfarePayCardNumber = WebUI.getText(findTestObject('FarePay_Card_ObjectRepo/adminFarePayCardNumber'))

String actualAdminfarePayCardNumber = AdminfarePayCardNumber.replaceAll('-', '')

println(actualAdminfarePayCardNumber)

WebUI.verifyEqual(actualAdminfarePayCardNumber, actualCardNumber)

println('Test Passed...')

WebUI.closeBrowser()

