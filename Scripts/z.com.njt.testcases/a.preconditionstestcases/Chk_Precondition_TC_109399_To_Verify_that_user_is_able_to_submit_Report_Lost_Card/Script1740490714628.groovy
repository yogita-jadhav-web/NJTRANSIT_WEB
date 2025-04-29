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

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Login_Lost_LoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Manage_Fare_Pay_Card_Screen'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_FARE-PAY Card Number_serialNumber'), 
    GlobalVariable.FP_CN_Lost)

WebUI.click(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_PIN_securityCode'))

WebUI.setText(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_PIN_securityCode'), 
    GlobalVariable.FP_Pin_Lost)

WebUI.click(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/div_Add FARE-PAY Card'))

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Your_FARE_PAY_card_has_been_registered_successfully'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_Report_Lost_Stolen_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_On_Yes_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Your_card_has_been_reported_lost_stolen_successfully'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.create.account.db.page/Verify_trx_type_and_bos_data'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

