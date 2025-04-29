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

WebUI.verifyElementText(findTestObject('Object Repository/Page_Add Fare-Pay Card  NJ Transit/h1_Manage FARE-PAY Card'), 
    'Manage FARE-PAY Card')

not_run: WebUI.verifyElementText(findTestObject('Page_Add Fare-Pay Card  NJ Transit/span_Denotes required fields'), '* Denotes required fields')

WebUI.callTestCase(findTestCase('com.auto.reload.page/Denotes_Required_Field'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Add Fare-Pay Card  NJ Transit/span_FARE-PAY Card Number'), 
    'FARE-PAY Card Number')

//WebUI.verifyElementText(findTestObject('Page_Add Fare-Pay Card  NJ Transit/fare_pay_card_information'), ' Please enter your FARE-PAY Card information below to review your activity.')
TestObject Element_Text = findTestObject('Page_Add Fare-Pay Card  NJ Transit/fare_pay_card_information')

String messagetext = WebUI.getText(Element_Text, FailureHandling.STOP_ON_FAILURE)

println('messagetext :' + messagetext)

TestObject cclabel = findTestObject('Page_Add Fare-Pay Card  NJ Transit/label_FARE-PAY Card Number')

String cclabelText = WebUI.getText(cclabel)

println('labelText :' + cclabelText)

WebUI.verifyMatch(cclabelText, 'FARE-PAY Card Number *', false)

TestObject Pinlabel = findTestObject('Object Repository/Page_Add Fare-Pay Card  NJ Transit/div_PIN')

String labelText = WebUI.getText(Pinlabel)

println('labelText :' + labelText)

WebUI.verifyMatch(labelText, 'PIN *', false)

