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

prior_msg = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_Prior to the first business day of the calendar monthweek you will receive a full refund. After the start of the monthweek, if the refund is requested immediately following the purchase, the full amount charged for'))

WebUI.comment('prior_msg :' + prior_msg)

println('prior_msg :' + prior_msg)

Refund_msg = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_After refund, the ticket(s) will not be available for use. Do you want to continue'))

WebUI.comment('Refund_msg :' + Refund_msg)

println('Refund_msg :' + Refund_msg)

TestObject btnYes = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_Yes')

TestObject btnNo = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/button_No')

WebUI.verifyElementPresent(btnYes, 0)

WebUI.verifyElementPresent(btnNo, 0)

