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

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/h1_Payment Information'), 
    5)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/Verify_Tap_And_Ride_Meanu_Options_Object_Repository/Page_Add Payment Card  NJ Transit/p_FARE-PAY Card'), 
    'FARE-PAY Card')

WebUI.verifyElementText(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/p_Tap  Ride'), 'TAP & RIDE')

WebUI.verifyElementText(findTestObject('Object Repository/Verify_Tap_And_Ride_Meanu_Options_Object_Repository/Page_Add Payment Card  NJ Transit/p_Profile'), 
    'PROFILE')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/p_FAQ'), 'FAQ')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/p_Contact Us'), 'CONTACT US')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/p_Logout'), 'LOGOUT')

