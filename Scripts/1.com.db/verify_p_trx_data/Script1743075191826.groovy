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

def p_trx_Data = CustomKeywords.'com.web.db.Validate_p_web_trx_table.get_p_web_trx_from_DB'(Web_db_connection)

println('p_web_trx_refund_Data : ' + p_trx_Data)

// Get TRX_TYPE from DB
def dbUserId = p_trx_Data['TRX_TYPE']

def expectedUserId = GlobalVariable.Email

println('Expected USER_ID: ' + expectedUserId)

//TRX_DATE
def dbTrxDate = p_trx_Data['TRX_DATE']



// TRX_AMT validation
def dbReloadAmount = (p_trx_Data['TRX_AMT']).toString()

String reloadAmount1 ='$501.0'
String reloadAmount = reloadAmount1.replace('$', '').trim()
//String reloadAmount = GlobalVariable.Reload_Amount.replace('$', '').trim()
println('reloadAmount' + reloadAmount)

// Convert the cleaned amount to double
double reloadAmountDouble = Double.parseDouble(reloadAmount)


println("Reload Amount from GlobalVariable: " + reloadAmount)
println("Converted to Double: " + reloadAmountDouble)
println("Database Reload Amount: " + dbReloadAmount)

// Convert to cents
int reloadInCents = (reloadAmountDouble * 100) as int

// **Check if DB stores amount in cents or dollars**
if (dbReloadAmount.contains(".")) { 
    // Case: DB stores amounts in **dollars** (e.g., "501.00" or "50.00")
    WebUI.verifyMatch(reloadAmountDouble.toString(), dbReloadAmount, false)
} else { 
    // Case: DB stores amounts in **cents** (e.g., "50100" or "5000")
    WebUI.verifyMatch(reloadInCents.toString(), dbReloadAmount, false)
}


//FARE_CARD_ID
def dbFarecardId = p_trx_Data['FARE_CARD_ID']

def cardDetails = CustomKeywords.'kw_web.Fare_Pay_Details.getNextCard'()

// Extract values
String FP_Card_No = cardDetails['cardNumber']


//WebUI.verifyMatch(FP_Card_No, dbFarecardId, false)
