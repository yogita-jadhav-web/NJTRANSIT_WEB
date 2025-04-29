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

def p_web_trx_refund_Data = CustomKeywords.'com.web.db.Validate_p_web_trx_refunds.get_p_web_trx_refund_data_from_DB'(Web_db_connection,
	GlobalVariable.Email)

println('p_web_trx_refund_Data : ' + p_web_trx_refund_Data)

// Get USER_ID from DB
def dbUserId = p_web_trx_refund_Data['USER_ID']


def expectedUserId = GlobalVariable.Email

println('Expected USER_ID: ' + expectedUserId)

WebUI.verifyMatch(expectedUserId, dbUserId, false)

// Reload amount validation
def dbReloadAmount = p_web_trx_refund_Data['REFUND_AMT']

WebUI.verifyMatch('0', dbReloadAmount, false)


//status
def dbStatus = p_web_trx_refund_Data['REFUND_STATUS']

WebUI.verifyMatch('INIT', dbStatus, false)

//REFUND_STATE
def dbrefundstate = p_web_trx_refund_Data['REFUND_STATE']

WebUI.verifyMatch('7', dbrefundstate, false)
//COMMENTS
def dbrefundcomments = p_web_trx_refund_Data['COMMENTS']

WebUI.verifyMatch('Refund process initiated', dbrefundcomments, false)

