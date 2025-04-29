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

WebUI.executeJavaScript('document.body.style.zoom = "70%";', null)

WebUI.click(findTestObject('startDate_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_Start Date'))

WebUI.click(findTestObject('startDate_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_ArrowDropDownIcon'))

not_run: WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_pastyear'))

String pastyear = CustomKeywords.'kw_web.ApplicationFunction.click_pastyear_on_Date_Picker'()

println('pastyear :' + pastyear)

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_highlighteddate'))

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_Search'))

WebUI.delay(10)

CustomKeywords.'kw_web.web.scrollToPageBottom'()

