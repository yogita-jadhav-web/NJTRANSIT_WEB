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

WebUI.callTestCase(findTestCase('com.login.page/Launch_NJT_Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/GuestTapRide_SearchCC_ObjRepo/Page_Sign In  NJ Transit/button_Guest Tap  Ride'))

WebUI.click(findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Guest Tap  Ride  NJ Transit/button_By Card Account Id'))

WebUI.setText(findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Guest Tap  Ride  NJ Transit/input_Card Account Id'), 
    GlobalVariable.Mastercard_Account_Id)

WebUI.scrollToElement(findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Guest Tap  Ride  NJ Transit/button_Search'), 
    0)

WebUI.click(findTestObject('Object Repository/GuestTapRide_SearchAccId_ObjRepo/Page_Guest Tap  Ride  NJ Transit/button_Search'))

WebUI.scrollToElement(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_TRX. History'), 
    0)

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_TRX. History'))

WebUI.executeJavaScript('document.body.style.zoom = "80%";', null)

WebUI.callTestCase(findTestCase('com.tap.and.ride.guest.page/Enter_StartDate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_DateTime'), 
    0)

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_receiptBtn'), 
    0)

WebUI.click(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/button_receiptBtn'))

WebUI.verifyElementPresent(findTestObject('Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/p_Transaction Data'), 0)

WebUI.verifyElementPresent(findTestObject('Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/h1_Payment Information'), 0)

WebUI.verifyElementPresent(findTestObject('Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/p_Transaction Data'), 0)

WebUI.closeBrowser()

