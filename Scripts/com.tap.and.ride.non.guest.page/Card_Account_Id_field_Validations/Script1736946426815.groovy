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

TestObject AccId_Inputfield = findTestObject('Object Repository/Page_Add Payment Card  NJ Transit/input_Card Account Id_cardAccountId')

WebUI.setText(AccId_Inputfield, '123ABC1')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/Verify_Card_Account_Id_is_too_short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.sendKeys(AccId_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(AccId_Inputfield, '23456789')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Invalid_Card_Account_Id'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.sendKeys(AccId_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(AccId_Inputfield, '@#$%ABCH')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Invalid_Card_Account_Id'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.sendKeys(AccId_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(AccId_Inputfield, 'ASDFGHJK')

WebUI.sendKeys(AccId_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card Account Id is required'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(AccId_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(AccId_Inputfield, 'ASDFGHJK')

WebUI.comment('Card account id search should be successfull')

