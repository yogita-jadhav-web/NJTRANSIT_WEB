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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

Select_Ticket = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_Select Ticket'))

println('Select_Ticket :' + Select_Ticket)

WebUI.click(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Select Ticket'))

TestObject dropdownList = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_selectticket_dp_options')

List<WebElement> options = WebUiCommonHelper.findWebElements(dropdownList, 10)

// Print all options

for (WebElement option : options) {
    dp_Opn=option.getText()
	println('Dropdown options: ' + dp_Opn)

	WebUI.comment('Dropdown options: ' + dp_Opn)
}

