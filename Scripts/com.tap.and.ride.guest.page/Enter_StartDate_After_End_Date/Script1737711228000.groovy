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

TestObject dateInputField = findTestObject('Object Repository/Page_Tap  Ride Dashboard  NJ Transit/input_Start Date_startDate')

String selectedDate = WebUI.getAttribute(dateInputField, 'value')

println('selectedDate :' + selectedDate)

WebUI.click(findTestObject('startDate_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_Start Date'))

WebUI.click(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/svg_NextMonth'))

WebUI.delay(5)

String PostDate = CustomKeywords.'kw_web.kw_Random.get_Post_date_from_current_Date'()

println('PostDate: ' + PostDate)

WebUI.comment(('user should not be able to select End Date lass than Start date, the ' + PostDate) + ' should be disabled')

