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

//WebUI.verifyElementText(findTestObject('Object Repository/Page_Sign In  NJ Transit/div_Your NJ TRANSIT E-Ticketing Account is _b95b3c'), 
//    'Your NJ TRANSIT E-Ticketing Account is not active yet, please activate using the email sent by NJTransit')
not_run: WebUI.verifyElementText(findTestObject('Object Repository/Page_Sign In  NJ Transit/div_Your NJ TRANSIT E-Ticketing Account is _b95b3c'), 
    'Your NJ TRANSIT E-Ticketing account is not active yet. Please activate using the email sent by NJTransit.')

msg = WebUI.getText(findTestObject('Object Repository/Page_Sign In  NJ Transit/div_Your NJ TRANSIT E-Ticketing Account is _b95b3c'), 
    FailureHandling.STOP_ON_FAILURE)

println('msg :' + msg)

WebUI.comment('msg :' + msg)

