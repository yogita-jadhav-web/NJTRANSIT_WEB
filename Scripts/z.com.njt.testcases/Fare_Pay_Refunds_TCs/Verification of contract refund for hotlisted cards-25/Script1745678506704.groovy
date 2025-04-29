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

WebUI.executeJavaScript(('window.open(\'' + GlobalVariable.ADMIN_PORTAL_URL) + '\', \'_blank\')', [])

WebUI.switchToWindowIndex(1)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_UserName_Filed'), GlobalVariable.ADMIN_USERNAME)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_Password'), GlobalVariable.ADMIN_PASSWORD)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Admin_SignInBTN'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/Guest_FarePayCard_TAB'))

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/farePayCardNumberSearchField'), actualCardNumber)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/searchButton'))

WebUI.scrollToElement(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/hotlistFarePayCard'), 10)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/hotlistFarePayCard'))

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/hotListDropDown'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/hotListReason'))

String commentBoxText = CustomKeywords.'kw_web.kw_Random.generateRandomString'(10)

WebUI.setText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/commentBoxText'), commentBoxText)

WebUI.click(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/saveButton'))

WebUI.delay(1)

String succesfulHotlistText = WebUI.getText(findTestObject('Object Repository/Fare_Card_Refund_Object_Repo/succesfulHotListText'))

WebUI.verifyEqual(succesfulHotlistText, 'Hotlist Fare Card is successful')

WebUI.verifyElementText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/p_Hotlisted (Defective)'), 'Hotlisted (Defective)')

WebUI.switchToWindowIndex(0)

WebUI.refresh()

WebUI.scrollToElement(findTestObject('FarePay_Card_ObjectRepo/div_Buy Tickets'), 0)

WebUI.verifyElementNotClickable(findTestObject('FarePay_Card_ObjectRepo/button_TRX. History'))

WebUI.comment('Test Verification is Completed to Avoid Next Test case Failure again UnHotlist the Card.....')

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_De-Hotlist FARE-PAY Card'))

WebUI.setText(findTestObject('Object Repository/FarePay_Card_ObjectRepo/textarea_wertyui'), 'wertyui')

WebUI.click(findTestObject('Object Repository/FarePay_Card_ObjectRepo/button_Save'))

WebUI.closeBrowser()

