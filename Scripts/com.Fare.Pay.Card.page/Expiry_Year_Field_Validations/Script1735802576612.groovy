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
import java.time.Year as Year
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.kms.katalon.core.webui.common.WebUiCommonHelper;
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI;

WebUI.scrollToElement(findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpYear'), 0)

WebUI.delay(3)

currentYear = CustomKeywords.'kw_web.ApplicationFunction.get_current_Year'()

println('currentYear :' + currentYear)

String selectedyear = WebUI.getText(findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpYear'))

println('selectedyear :' + selectedyear)

if (selectedyear == currentYear) {
    println('Validation passed: Current month is selected in the dropdown.')

    WebUI.verifyMatch(selectedyear, currentYear, false)
} else {
    println('Validation failed: Current month is not selected in the dropdown.')
}

//**********
TestObject expyear = findTestObject('TapAndRide_Object_Repository/Page_Add Payment Card  NJ Transit/ExpYear')

WebUI.click(expyear)

TestObject expyeardropdown = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/Exp_year_dropDwn_li')

List<WebElement> elements = WebUiCommonHelper.findWebElements(expyeardropdown, 10)

int currentYear = Year.now().getValue()

List<String> expectedYears = []

for (int i = 0; i < 16; i++) {
    expectedYears.add((currentYear + i).toString())
}

WebElement lastElement = elements.get(elements.size() - 1) 
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].scrollIntoView(true);", lastElement)

// Step 4: Validate the last item is visible (optional)
if (lastElement.isDisplayed()) {
    WebUI.comment("Last element is visible: " + lastElement.getText())
} else {
    WebUI.comment("Failed to scroll to the last element.")
}


WebUI.delay(5)

List<String> actualYears = []

for (WebElement element : elements) {
    actualYears.add(element.getAttribute('data-value'))
}

// Step 5: Validate the values
if (actualYears.equals(expectedYears)) {
    WebUI.comment('Validation Passed: Dropdown contains 16 years starting from the current year.')
} else {
    WebUI.comment('Validation Failed: Dropdown does not contain the correct years.')

    WebUI.comment('Expected years: ' + expectedYears)
}

// Step 6: Log the results
println('Expected years: ' + expectedYears)

