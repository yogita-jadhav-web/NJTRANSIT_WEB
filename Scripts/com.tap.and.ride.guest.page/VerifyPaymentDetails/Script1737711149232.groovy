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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.verifyElementPresent(findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Tap  Ride Dashboard  NJ Transit/Card_Number'), 
    0)

cardnumber = findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Tap  Ride Dashboard  NJ Transit/Card_Number')

// Step 1: Get the dynamic text
String actualText_cc = WebUI.getText(cardnumber)

println('actualText_cc : ' + actualText_cc)

String first12Chars = actualText_cc.substring(0, 15 )

println('first12Chars : ' + first12Chars)

// Step 4: Verify the first 12 characters
String expectedFirst12 = 'XXXX-XXXX-XXXX-'

assert first12Chars == expectedFirst12 : 'First 12 characters do not match the expected format!'

String actualDynamicPart = actualText_cc.substring(15)

// Debugging: Print the actual first 12 characters
println('First 12 characters are valid: ' + first12Chars)

assert actualDynamicPart.matches('\\d{4}') : 'Dynamic part is not a 4-digit number!'

println('Static part validated: ' + first12Chars)

println('Dynamic part validated: ' + actualDynamicPart)

String Card_Status = WebUI.getText(findTestObject('Verify_Payment_Information/Page_Tap  Ride Dashboard  NJ Transit/span_ACTIVE'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Card_Status: $Card_Status")

String Media_Type = WebUI.getText(findTestObject('Verify_Payment_Information/Page_Tap  Ride Dashboard  NJ Transit/span_Contactless Card'), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo("Media_Type: $Media_Type")

