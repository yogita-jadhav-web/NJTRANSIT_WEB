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

TestObject cardvalue = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_cardvalue_amount')

// Get the initial value of the card
String initialValue = WebUI.getText(cardvalue)

println('Initial Card Value: ' + initialValue)

// Set max wait time and refresh interval
int maxWaitTime = 100 // Total time to wait (in seconds) → 10 minutes

int interval = 50 // Refresh interval (in seconds)

int elapsedTime = 0

boolean isValueChanged = false // Flag to track if value changed

// Loop until the value changes or the time exceeds maxWaitTime
while (elapsedTime < maxWaitTime) {
    // Refresh the page
    WebUI.refresh()

    // Wait for the element to be visible
    WebUI.waitForElementVisible(cardvalue, 10)

    // Get the updated card value
    String updatedValue = WebUI.getText(cardvalue)

    println('Updated Card Value: ' + updatedValue)

    // Break the loop if the value has changed
    if (!(updatedValue.equals(initialValue))) {
        println('Value changed, stopping refresh.')

        isValueChanged = true

        break
    }
    
    // Wait before the next refresh
    WebUI.delay(interval)

    elapsedTime += interval
}

// Final validation if the value did not change after the timeout
if (!(isValueChanged)) {
    println('Card value did not change within the time limit.')

    WebUI.comment(' Card value was NOT added through auto-reload as expected.')
} else {
    WebUI.comment(' Card value changed, but it should NOT have been added through auto-reload!')
}

