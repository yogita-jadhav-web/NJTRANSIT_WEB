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

//select ticket
TestObject selected_plan = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Monthly Adult - 80.00')

String planText = WebUI.getText(selected_plan)

println('planText :' + planText)

WebUI.comment('planText :' + planText)

WebUI.getAttribute(selected_plan, 'disabled')

WebUI.comment('The selected Plan should not be editable')

TestObject sel_plan = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_Note NJ TRANSIT will automatically reload a monthly pass to your FARE-PAY card account by last day of this month')

String plan_Text = WebUI.getText(sel_plan)

println('plan_Text :' + plan_Text)

WebUI.comment('plan_Text :' + plan_Text)

