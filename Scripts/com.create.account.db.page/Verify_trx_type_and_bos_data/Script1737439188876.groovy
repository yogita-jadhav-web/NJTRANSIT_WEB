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
import groovy.json.JsonSlurper as JsonSlurper
import groovy.json.JsonOutput


Web_db_connection = CustomKeywords.'com.web.db.NJT_Web_Database.get_MySQL_Web_DBConnection'(GlobalVariable.NJT_Web_DB_Url, 
    GlobalVariable.NJT_Web_DB_UserName, GlobalVariable.NJT_Web_DB_Password)

Trx_Type = CustomKeywords.'com.web.db.NJT_Web_Database.get_TRX_TYPE_from_DB'(Web_db_connection)
WebUI.comment("Trx_Type: " + Trx_Type)

String bosData = CustomKeywords.'com.web.db.NJT_Web_Database.get_BOS_data_from_DB'(Web_db_connection)

println('BOS Data from DB: ' + bosData)

def jsonSlurper = new JsonSlurper()

WebUI.comment("BOS Data: " + bosData)

