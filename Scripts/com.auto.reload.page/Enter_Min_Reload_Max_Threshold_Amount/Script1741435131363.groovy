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

WebUI.setText(input_Reload_amount, '10')

WebUI.sendKeys(input_Reload_amount, Keys.chord(Keys.TAB))

WebUI.delay(3)

Reload_Amount = '10'//WebUI.getText(input_Reload_amount)

println('Reload_Amount : ' + Reload_Amount)

GlobalVariable.Reload_Amount = Reload_Amount

println('Reload_Amount : ' + Reload_Amount)

TestObject button50Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_50_TA')

WebUI.click(button50Dollars)

TestObject input_threshold_amount = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Threshold amount')

WebUI.click(input_threshold_amount)

Threshold_Amount = WebUI.getText(button50Dollars)

GlobalVariable.Threshold_Amount = Threshold_Amount

println('Threshold_Amount : ' + Threshold_Amount)

