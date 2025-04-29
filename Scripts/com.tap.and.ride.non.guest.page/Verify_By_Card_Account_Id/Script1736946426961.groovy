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

WebUI.click(findTestObject('Object Repository/By_Card_Account_Id_Object_Repository/Page_Add Payment Card  NJ Transit/button_By Card Account Id'))

WebUI.callTestCase(findTestCase('com.auto.reload.page/Denotes_Required_Field'), [:], FailureHandling.STOP_ON_FAILURE)

Msg_text = WebUI.getText(findTestObject('Object Repository/By_Card_Account_Id_Object_Repository/Page_Add Payment Card  NJ Transit/span_Register your card using Card Account _6639b8'))

println('Msg_text :' + Msg_text)

WebUI.comment('Msg_text :' + Msg_text)

TestObject card_label = findTestObject('Page_Add Payment Card  NJ Transit/label_Card Account Id')

String country_Text = WebUI.getText(card_label)

println('labelText :' + country_Text)

WebUI.verifyMatch(country_Text, 'Card Account ID *', false)

TestObject Input_accId = findTestObject('Object Repository/By_Card_Account_Id_Object_Repository/Page_Add Payment Card  NJ Transit/input_Card Account Id')

// Get the maxlength attribute value
String maxLength = WebUI.getAttribute(Input_accId, 'maxlength')

// Verify if it matches 8
assert maxLength == '8'

println('maxLength card account id :' + maxLength)

