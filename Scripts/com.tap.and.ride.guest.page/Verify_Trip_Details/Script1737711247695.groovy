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

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_Trip_Trx_No'), FailureHandling.STOP_ON_FAILURE)

String trx_ID = WebUI.getText(findTestObject('Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_ID'), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("trx_Number: $trx_ID")

println('trx_ID :' + trx_ID)

String TripDateTime = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_TripDateTime'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("TripDateTime: $TripDateTime")

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_EWR AirTrain Access Fee'))
String TicketType = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_EWR AirTrain Access Fee'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("TicketType: $TicketType")

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_Rail'))
String product = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_Rail'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("product: $product")

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_TripAmount'))
String TripAmount = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_TripAmount'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("TripAmount: $TripAmount")

//WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_1'))
String TripNo = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_1'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("TripNo: $TripNo")

