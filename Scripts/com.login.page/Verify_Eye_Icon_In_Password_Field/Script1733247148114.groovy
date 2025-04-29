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

// Locate the password field and eye icon
def passwordField = findTestObject('Object Repository/LoginTC_Object_Repository/Page_Sign In  NJ Transit/input_Password')

// Step 1: Verify the password field initially hides the input
String initialType = WebUI.getAttribute(passwordField, 'type')

assert initialType == 'password'

// Step 2: Click the eye icon to show the password
def eyeIcon = findTestObject('To_verify_the_eye_icon_in_password_field_Object_Repository/button_show_pass')

WebUI.click(eyeIcon)

// Step 3: Verify the password field now shows the input
String visibleType = WebUI.getAttribute(passwordField, 'type')

assert visibleType == 'text'

// Step 4: Click the eye icon again to hide the password
WebUI.click(eyeIcon)

//WebUI.click(eyeIcon)
// Step 5: Verify the password field hides the input again
String finalType = WebUI.getAttribute(passwordField, 'type')

assert finalType == 'password'

