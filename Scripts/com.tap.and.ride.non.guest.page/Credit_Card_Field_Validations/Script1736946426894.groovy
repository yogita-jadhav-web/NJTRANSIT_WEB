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

TestObject card_Inputfield = findTestObject('Object Repository/Page_Add Payment Card  NJ Transit/input_Card Number')

WebUI.setText(card_Inputfield, '43885761794502')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/Verify_Card_Number_is_too_short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, 'abcdabcdabcdabcd')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, 'abcd1234abcd1234')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, 'abcd@abcdabcdabc')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, '441617@@23072276')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, '@#######@@@@@@@%')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, '441617   23072276')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(card_Inputfield, GlobalVariable.AMEX)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/Verify_Card Number is required'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(card_Inputfield, GlobalVariable.AMEX)

WebUI.comment('Card Search should successfull')

WebUI.setText(card_Inputfield, GlobalVariable.Mastercard)

WebUI.sendKeys(card_Inputfield, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.comment('Card Search should successfull')

