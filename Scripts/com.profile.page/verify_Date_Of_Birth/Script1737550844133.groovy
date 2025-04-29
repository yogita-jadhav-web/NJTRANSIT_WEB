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

//Verify the label 
TestObject dobLabel = findTestObject('Page_Create Account  NJ Transit/span_Date Of Birth (MMDD)')

WebUI.scrollToElement(dobLabel, 0)

String dob_Text = WebUI.getText(dobLabel)

println('dob_Text :' + dob_Text)

String labelText = WebUI.getText(dobLabel)

// Check if the label does NOT indicate a mandatory field
if (!(labelText.contains('*')) && !(labelText.toLowerCase().contains('required'))) {
    println('The field is NOT marked as mandatory. Test Passed.')

    WebUI.verifyMatch(dob_Text, 'Date Of Birth (MM/DD)', false)
} else {
    println('The field is marked as mandatory. Test Failed.')
}

// Verify the placeholder value
TestObject dob_placeholder = findTestObject('Page_Profile  NJ Transit/input_Date Of Birth (MMDD)')

WebUI.verifyElementAttributeValue(dob_placeholder, 'placeholder', 'MM/DD', 10)

// Validate if the 'aria-disabled' attribute has the value 'true'
boolean isAriaDisabled = WebUI.getAttribute(dob_placeholder, 'aria-disabled') == 'true'

if (isAriaDisabled) {
    println('The Date of Birth field is not editable.')

    WebUI.comment('The Date of Birth field is not editable')
} else {
    println('The Date of Birth field is editable.')
	WebUI.comment('The Date of Birth field is editable')
}

