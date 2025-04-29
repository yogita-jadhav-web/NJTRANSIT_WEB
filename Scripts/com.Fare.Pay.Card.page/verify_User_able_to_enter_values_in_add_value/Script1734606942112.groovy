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
TestObject addValueTextBox = findTestObject('Object Repository/AmountLessThanFive/Page_Fare-Pay Dashboard  NJ Transit/input_Add Value_addFunds')

TestObject button5Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_5')

TestObject button10Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_10')

TestObject button20Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_20')

TestObject button50Dollars = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_50_RA')

// Define a map of buttons and their corresponding expected values
Map<TestObject, String> buttonValueMap = [(button5Dollars) : '5', (button10Dollars) : '10', (button20Dollars) : '20', (button50Dollars) : '50']

// Iterate through each button and validate the behavior
buttonValueMap.each({ def button, def expectedValue ->
        WebUI.comment('Testing button for $${expectedValue amount')
		println('Testing button for $${expectedValue} amount')
     
        WebUI.click(button)

      
        String actualValue = WebUI.getAttribute(addValueTextBox, 'value')
		println('actualValue :'+actualValue)
       
        if (actualValue == expectedValue) {
            WebUI.comment('Validation Passed: Add Value textbox correctly displays $${actualValue}') 
			println('Validation Passed: Add Value textbox correctly displays $${actualValue}')
        } else {
            WebUI.comment('Validation Failed: Expected $${expectedValue}, but found $${actualValue}')

            WebUI.takeScreenshot()
        }
    })

