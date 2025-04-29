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

def autoreloadData = CustomKeywords.'com.web.db.NJT_Web_Database.get_autoreload_data_from_DB'(Web_db_connection, GlobalVariable.Email)

println('Auto-reload Data from DB: ' + autoreloadData)

// Get USER_ID from DB
def dbUserId = autoreloadData['USER_ID']

println('USER_ID from DB: ' + dbUserId)

def expectedUserId = GlobalVariable.Email

println('Expected USER_ID: ' + expectedUserId)

WebUI.verifyMatch(expectedUserId, dbUserId, false)

//status
def dbStatus = autoreloadData['STATUS']
WebUI.verifyMatch('1', dbStatus, false)

//card no
def dbCardNo = autoreloadData['CARD_NO']

 cardNumber = GlobalVariable.Card_Number
println('cardNumber '+cardNumber)
String last4Digits = cardNumber.replaceAll('.*(\\d{4})$', '$1')
WebUI.verifyMatch(cardNumber, dbCardNo, false)

// Reload amount validation
def dbReloadAmount = autoreloadData['RELOAD_AMT'].toString() 
 String reloadAmount = GlobalVariable.Reload_Amount
println('reloadAmount'+reloadAmount)
 int reloadInCents = Integer.parseInt(reloadAmount.replace('$', '').trim()) * 100
 WebUI.verifyMatch(reloadInCents.toString(), dbReloadAmount, false)

// Threshold amount validation
def dbThresholdAmount = autoreloadData['THRESHOLD_AMT'].toString()
 String thresholdAmount = GlobalVariable.Threshold_Amount

 println('thresholdAmount'+thresholdAmount)
 int thresholdInCents = Integer.parseInt(thresholdAmount.replace('$', '').trim()) * 100
 WebUI.verifyMatch(thresholdInCents.toString(), dbThresholdAmount, false)
 