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

String td_DateTime = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_date_time'), 
    FailureHandling.STOP_ON_FAILURE)

println('td_DateTime :' + td_DateTime)

KeywordUtil.logInfo("Date/Time: $td_DateTime")

String trx_ID = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_ID'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("trx_ID: $trx_ID")

println('trx_ID : ' + trx_ID)

String ticket_Type = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Ticket_Type'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("ticket_Type: $ticket_Type")

println('ticket_Type :' + ticket_Type)

String td_Product = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Product'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("td_Product: $td_Product")

println('td_Product :' + td_Product)

String td_Route = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Route'),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("td_Route: $td_Route")

println('td_Route :' + td_Route)

String td_Tkt_Exp = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Ticket_Exp'),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("td_Tkt_Exp: $td_Tkt_Exp")

println('td_Tkt_Exp :' + td_Tkt_Exp)

String td_Amount = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Amount'),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("td_Amount: $td_Amount")

println('td_Amount :' + td_Amount)

String td_PaymentType = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/p_FP_Payment_Type'),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("td_PaymentType: $td_PaymentType")

println('td_PaymentType :' + td_PaymentType)

String status = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Action_Status'))

KeywordUtil.logInfo("status: $status")

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_date_time'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_ID'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Ticket_Type'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Product'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Route'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Ticket_Exp'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Amount'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/p_FP_Payment_Type'))

//WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/td_FP_Action_Status'))

