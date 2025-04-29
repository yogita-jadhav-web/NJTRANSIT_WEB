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

// Define the test objects
TestObject addValueTextBox = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input_Reload amount')

TestObject button25Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_25')

TestObject button50Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_50_RA')

TestObject button100Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_100')

TestObject button200Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_200')

// Define a map of buttons and their corresponding expected values
Map<TestObject, String> buttonValueMap = [(addValueTextBox) : '25', (button50Dollars) : '50', (button100Dollars) : '100'
    , (button200Dollars) : '200']

// Iterate through each button and validate the behavior
buttonValueMap.each({ def button, def expectedValue ->
        WebUI.comment('Testing button for '+ expectedValue +'amount')

        println('Testing button for $${expectedValue} amount')

        WebUI.click(button)

        String actualValue = WebUI.getAttribute(addValueTextBox, 'value')

        println('actualValue :' + actualValue)

        if (actualValue == expectedValue) {
            WebUI.comment('Validation Passed: Add Value textbox correctly displays '+ actualValue)

            println('Validation Passed: Add Value textbox correctly displays '+actualValue)
        } else {
            WebUI.comment('Validation Failed: Expected '+expectedValue +', but found '+ actualValue)

            WebUI.takeScreenshot()
        }
    })
//Reload Amount should be between $10.00 and $500.00
reload_amount = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/span_Note Reload Amount should be between 10.00 and 500.00'))

println('reload_amount :' + reload_amount)

WebUI.comment('reload_amount :' + reload_amount)

