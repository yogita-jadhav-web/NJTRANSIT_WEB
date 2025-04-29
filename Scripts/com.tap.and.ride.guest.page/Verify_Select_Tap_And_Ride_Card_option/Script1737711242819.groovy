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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


TestObject cardnumberdropdown = findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/div_Card_Number_Dropdown')

String actualText_cc = WebUI.getText(cardnumberdropdown)

String first12Chars = actualText_cc.substring(0, 15 )

String expectedFirst12 = 'XXXX-XXXX-XXXX-'

assert first12Chars == expectedFirst12 : 'First 12 characters do not match the expected format!'

String actualDynamicPart = actualText_cc.substring(15)

println('First 12 characters are valid: ' + first12Chars)

assert actualDynamicPart.matches('\\d{4}') : 'Dynamic part is not a 4-digit number!'

println('Static part validated: ' + first12Chars)

String selectedOption = WebUI.getText(cardnumberdropdown)

if (selectedOption == actualText_cc) {
	WebUI.comment('Default card is selected correctly: ' + selectedOption)
	println('Default card is selected correctly:')
	
} else {
	WebUI.comment('Default card is NOT selected. Expected: ' + actualText_cc + ', but found: ' + selectedOption)
	WebUI.verifyMatch(selectedOption, actualText_cc, false) 
}
