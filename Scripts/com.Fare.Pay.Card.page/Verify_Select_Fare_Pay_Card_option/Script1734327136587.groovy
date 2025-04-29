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

TestObject cardnumberdropdown = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_cardNumber_In_dropdown')

String actualText_cc = WebUI.getText(cardnumberdropdown)

println('actualText_cc : ' + actualText_cc)

def originalNumber = GlobalVariable.FarePay_Card_Number

// Use a regular expression to format it
def expectedText = originalNumber.replaceAll('(\\d{4})(\\d{4})(\\d{4})(\\d{4})', '$1-$2-$3-$4')

// Print or use the formatted number
println('expectedText : ' + expectedText)

not_run: WebUI.verifyMatch(expectedText, actualText_cc, false)

