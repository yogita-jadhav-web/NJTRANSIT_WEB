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

//1. JavaScript to check if the session storage contains card information
String cardInfo = WebUI.executeJavaScript("return sessionStorage.getItem('Card_Details');", null)

// Validate that card information is NOT stored
if (cardInfo == null) {
    println "Test Passed: Card information is NOT stored in session storage."
} else {
    println "Test Failed: Card information is found in session storage - " + cardInfo
    WebUI.verifyMatch(cardInfo, null, false) // Fail the test if card info is found
}

//2. JavaScript to get all session storage keys
List<String> sessionKeys = WebUI.executeJavaScript("return Object.keys(sessionStorage);", null)

if (sessionKeys.isEmpty()) {
	println "Test Passed: No sensitive data is stored in session storage."
} else {
	println "Test Failed: Session storage contains data - " + sessionKeys
	WebUI.verifyEqual(sessionKeys.size(), 0) // Fail test if session storage is not empty
}