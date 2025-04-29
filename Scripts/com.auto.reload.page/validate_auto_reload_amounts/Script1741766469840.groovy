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

//Reload Amount
TestObject label = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Reload Amount')

String labelText = WebUI.getText(label)

println('labelText :' + labelText)

WebUI.verifyMatch(labelText, 'Reload Amount *', false)

//Threshold  Amount
TestObject th_label = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Threshold Amount')

String th_labelText = WebUI.getText(th_label)

println('labelText :' + th_labelText)

WebUI.verifyMatch(th_labelText, 'Threshold Amount *', false)

reload_amount = WebUI.getAttribute(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Reload amount'),'value')

println('reload_amount :' + reload_amount)

WebUI.comment('reload_amount :' + reload_amount)

threshold_amount = WebUI.getAttribute(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Threshold amount'),'value')

println('threshold_amount :' + threshold_amount)

WebUI.comment('threshold_amount :' + threshold_amount)

WebUI.callTestCase(findTestCase('com.auto.reload.page/validate_status'), [:], FailureHandling.STOP_ON_FAILURE)

