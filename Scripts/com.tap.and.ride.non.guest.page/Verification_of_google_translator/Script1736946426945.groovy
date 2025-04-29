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

WebUI.selectOptionByValue(findTestObject('Object Repository/googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/select_Language_Dropdown'), 
    'mr', false)

WebUI.verifyElementText(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/font_text'), 
    'फेअर-पे कार्ड व्यवस्थापित करा')

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/select_Language_Dropdown'), 
    'kn', false)

WebUI.verifyElementText(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/font_text'), 
    'FARE-PAY ಕಾರ್ಡ್ ನಿರ್ವಹಿಸಿ')

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/select_Language_Dropdown'), 
    'hi', false)

WebUI.verifyElementText(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/font_text'), 
    'FARE-PAY कार्ड प्रबंधित करें')

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/select_Language_Dropdown'), 
    'en', false)

WebUI.verifyElementText(findTestObject('googe_translator_object_repository/Page_Add Fare-Pay Card  NJ Transit/h1_Manage FARE-PAY Card'), 
    'Manage FARE-PAY Card')

WebUI.delay(5)

