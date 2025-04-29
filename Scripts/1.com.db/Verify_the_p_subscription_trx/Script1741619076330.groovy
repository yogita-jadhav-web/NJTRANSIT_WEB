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

def p_subscription_trx = CustomKeywords.'com.web.db.Validate_p_autoreload_trx.get_p_autoreload_trx_data_from_DB'(Web_db_connection, 
    GlobalVariable.Email)

println('Auto-reload Data from DB: ' + p_subscription_trx)

// Reload amount validation
def dbReloadAmount = (p_subscription_trx['AMOUNT']).toString()

String reloadAmount = GlobalVariable.Reload_Amount

println('reloadAmount' + reloadAmount)

int reloadInCents = Integer.parseInt(reloadAmount.replace('$', '').trim()) * 100

WebUI.verifyMatch(reloadInCents.toString(), dbReloadAmount, false)

// PAY_REF_ID validation
def dbPAY_REF_ID = p_subscription_trx['PAY_REF_ID']

String card_nickName = GlobalVariable.card_nickname

println('card_nickName' + card_nickName)

WebUI.verifyMatch(card_nickName, dbPAY_REF_ID, false)
// RETRY_COMMENT validation
def dbRETRY_COMMENT = p_subscription_trx['RETRY_COMMENT']

println('card_nickName' + card_nickName)

WebUI.verifyMatch("Success", dbRETRY_COMMENT, false)

