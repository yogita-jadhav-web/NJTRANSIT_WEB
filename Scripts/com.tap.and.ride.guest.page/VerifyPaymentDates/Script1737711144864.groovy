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

String Exp_Date = WebUI.getText(findTestObject('Verify_Payment_Information/Page_Tap  Ride Dashboard  NJ Transit/span_02282029'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Exp_Date: $Exp_Date")

String First_Trip = WebUI.getText(findTestObject('Verify_Payment_Information/Page_Tap  Ride Dashboard  NJ Transit/span_02212024'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("First_Trip: $First_Trip")

String Last_Trip = WebUI.getText(findTestObject('Verify_Payment_Information/Page_Tap  Ride Dashboard  NJ Transit/span_02282029'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Last_Trip: $Last_Trip")

