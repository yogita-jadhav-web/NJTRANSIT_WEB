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
TestObject dob_placeholder = findTestObject('Page_Create Account  NJ Transit/input_Date Of Birth (MMDD)')

WebUI.verifyElementAttributeValue(dob_placeholder, 'placeholder', 'Date Of Birth (MM/DD)', 10)

//Enter 4 digit Phone number
Invnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 1)

println('fourdigitnumbers : ' + Invnumbers)

WebUI.setText(dob_placeholder, Invnumbers)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Please enter a valid date in the format'), [:], 
    FailureHandling.STOP_ON_FAILURE)

fourdigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 4)

println('fourdigitnumbers : ' + fourdigitnumbers)

WebUI.setText(dob_placeholder, fourdigitnumbers)

WebUI.callTestCase(findTestCase('com.create.and.update.account.page/verify_Invalid Date Of Birth'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(dob_placeholder, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

Month_date = CustomKeywords.'kw_web.kw_Random.get_current_Month_Date'()

println('Month_date : ' + Month_date)

WebUI.setText(dob_placeholder, Month_date)

println('The date of birth should be accepted')

WebUI.comment('The date of birth should be accepted' + Month_date)

