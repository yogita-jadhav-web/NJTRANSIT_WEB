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
import com.kms.katalon.core.testobject.ConditionType

//WebUI.click(findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/button_1'))
TestObject element = findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/button_1')

TestObject firstPageButton = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[@aria-current='true' and text()='1']")


boolean isFirstPageSelected = WebUI.verifyElementPresent(firstPageButton, 10, FailureHandling.CONTINUE_ON_FAILURE)


if (isFirstPageSelected) {
    WebUI.comment("Validation successful: The first page is selected by default.")
	println('Validation successful: The first page is selected by default')
} else {
    WebUI.comment("Validation failed: The first page is NOT selected by default.")
}