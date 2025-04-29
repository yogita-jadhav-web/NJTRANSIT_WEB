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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

TestObject route_input = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/input__route')

WebUI.click(route_input)

List<WebElement> route_options = WebUI.findWebElements(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_Option'),
	30)

int randomIndex = new Random().nextInt(route_options.size())

println('randomIndex should be :' + randomIndex)

WebElement randomOption = route_options.get(randomIndex)
WebUI.delay(2)
randomOption.click()
WebUI.delay(2)

String selected_Option = WebUI.getAttribute(route_input, 'value')

WebUI.comment('Selected Route: ' + selected_Option)

println('Selected Route: ' + selected_Option)


