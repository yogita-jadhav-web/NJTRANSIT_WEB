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

Web_db_connection = CustomKeywords.'com.web.db.NJT_Web_Database.get_MySQL_Web_DBConnection'(GlobalVariable.NJT_Web_DB_Url, 
    GlobalVariable.NJT_Web_DB_UserName, GlobalVariable.NJT_Web_DB_Password)

g_subscription_Data = CustomKeywords.'com.web.db.Validate_g_subscription.get_g_subscription_data_from_DB'(Web_db_connection, 
    GlobalVariable.Email)

println('Auto-reload Data from DB: ' + g_subscription_Data)

// Get USER_ID from DB
def dbUserId = g_subscription_Data['USER_ID']

println('USER_ID from DB: ' + dbUserId)

def expectedUserId = GlobalVariable.Email

println('Expected USER_ID: ' + expectedUserId)

WebUI.verifyMatch(expectedUserId, dbUserId, false)

//status
def dbStatus = g_subscription_Data['STATUS']

WebUI.verifyMatch('1', dbStatus, false)

//card no
def dbCardNo = g_subscription_Data['CARD_NO']

cardNumber = GlobalVariable.Card_Number

println('cardNumber: ' + cardNumber)

// Get the last 4 digits
String last4Digits = cardNumber.replaceAll('.*(\\d{4})$', '$1')

//String last4Digits = cardNumber.replaceAll('.*(\\d{4})\\s*$', '$1')
WebUI.verifyMatch(last4Digits, dbCardNo, false)

// Reload amount validation
def dbReloadAmount = (g_subscription_Data['RELOAD_AMT']).toString()

String reloadAmount = GlobalVariable.Reload_Amount

println('reloadAmount' + reloadAmount)

int reloadInCents = Integer.parseInt(reloadAmount.replace('$', '').trim()) * 100

WebUI.verifyMatch(reloadInCents.toString(), dbReloadAmount, false)

// Threshold amount validation
def dbThresholdAmount = (g_subscription_Data['THRESHOLD_AMT']).toString()

String thresholdAmount = GlobalVariable.Threshold_Amount

println('thresholdAmount' + thresholdAmount)

int thresholdInCents = Integer.parseInt(thresholdAmount.replace('$', '').trim()) * 100

WebUI.verifyMatch(thresholdInCents.toString(), dbThresholdAmount, false)

