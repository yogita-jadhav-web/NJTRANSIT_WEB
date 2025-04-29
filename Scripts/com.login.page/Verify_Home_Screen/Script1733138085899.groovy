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

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/h1_Sign In'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/h2_Welcome'), 
    0)

not_run: WebUI.verifyImagePresent(findTestObject('Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/img_Forgot Password_divider_Img'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/a_FAQ'), 'FAQ')

WebUI.verifyElementText(findTestObject('Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/a_Contact Us'), 'Contact Us')

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify_Home_Screen_Object_Repository/Verify_the_Home_Screen/span_2024  NJ TRANSIT All Rights Reserved'), 
    0)

