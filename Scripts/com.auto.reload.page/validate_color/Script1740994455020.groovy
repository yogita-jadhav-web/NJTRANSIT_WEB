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

//card value

TestObject yesButton=findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_ticket_value')
card_value = WebUI.getText(yesButton)
println('card_value :' + card_value)

String yesButtonColor = WebUI.getCSSValue(yesButton, 'color')

WebUI.comment('yesButtonColor ' + yesButtonColor)

println('yesButtonColor :' + yesButtonColor)

//ticket value

TestObject noButton=findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_No')
tkt_value = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_No'))
println('tkt_value :' + tkt_value)

String noButtonColor = WebUI.getCSSValue(noButton, 'color')

println('noButtonColor :' + noButtonColor)

WebUI.comment('noButtonColor ' + noButtonColor)