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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.scrollToElement(findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpMonth'), 0)

WebUI.delay(3)

current_month = CustomKeywords.'kw_web.kw_Random.get_current_Month'()

println('current_month :' + current_month)

String selectedMonth = WebUI.getText(findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpMonth'))

println('selectedMonth :' + selectedMonth)

if (selectedMonth == current_month) {
    println('Validation passed: Current month is selected in the dropdown.')

    WebUI.verifyMatch(selectedMonth, current_month, false)
} else {
    println('Validation failed: Current month is not selected in the dropdown.')
}

//**********
TestObject expmonth = findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpMonth')

WebUI.click(expmonth)

TestObject expmonthdropdown = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/Exp_Month_DropDwn_li')

List<WebElement> elements = WebUiCommonHelper.findWebElements(expmonthdropdown, 10)

// Step 3: Extract the 'data-value' or text from each <li>
List<String> actualMonths = []

for (WebElement element : elements) {
    actualMonths.add(element.getAttribute('data-value' ))
}

// Step 4: Define the expected months
List<String> expectedMonths = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12']

// Step 5: Validate the values
if (actualMonths.equals(expectedMonths)) {
    WebUI.comment('Validation Passed: Dropdown contains all months from 01 to 12.')
} else {
    WebUI.comment('Validation Failed: Dropdown does not contain all months.')

    WebUI.comment('Actual months: ' + actualMonths)
}

// Step 6: Log the results
println('Actual dropdown values: ' + actualMonths)

