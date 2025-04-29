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

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_receiptBtn'), 
    0)

WebUI.click(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/button_NJT-Print_receiptBtn'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/span_NJ Transit Receipt'), 'NJ Transit Receipt')

WebUI.verifyElementText(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/p_Payment Information'), 'Payment Information')

String Receipt_Number = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_Receipt Number'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Receipt_Number: $Receipt_Number")

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_Receipt Number'))

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_CardNumber'))
String CardNumber = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_CardNumber'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("CardNumber: $CardNumber")

WebUI.verifyElementText(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/p_Transaction Data'), 'Transaction Data')

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_97771'))
//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_TransactionDate'))
String Transaction_Id = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_97771'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Transaction_Id: $Transaction_Id")

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_CardAccId'))

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_TransactionDate'))
String CardAccId = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_CardAccId'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("CardAccId: $CardAccId")

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_TransactionDate'))
String TransactionDate = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_TransactionDate'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("TransactionDate: $TransactionDate")

String Transaction_Amount = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/span_8.50'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Transaction_Amount: $Transaction_Amount")

String NJT_Msg = WebUI.getText(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/span_For assistance please contact NJT at 862-229-7139'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("NJT_Msg: $NJT_Msg")

WebUI.verifyElementPresent(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_Print'), 
    0)

WebUI.delay(5)

