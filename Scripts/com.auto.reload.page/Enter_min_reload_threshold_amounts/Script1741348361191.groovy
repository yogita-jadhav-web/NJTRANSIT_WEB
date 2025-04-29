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

TestObject input_Reload_amount = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Reload amount')

WebUI.click(input_Reload_amount)


TestObject button25Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_25')

WebUI.click(button25Dollars)
Reload_Amount=WebUI.getText(button25Dollars)
GlobalVariable.Reload_Amount=Reload_Amount
println('Reload_Amount : '+Reload_Amount)

TestObject button10Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_10')

WebUI.click(button10Dollars)

TestObject input_threshold_amount = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Threshold amount')

WebUI.click(input_threshold_amount)

Threshold_Amount=WebUI.getText(button10Dollars)
GlobalVariable.Threshold_Amount=Threshold_Amount
println('Threshold_Amount : '+Threshold_Amount)