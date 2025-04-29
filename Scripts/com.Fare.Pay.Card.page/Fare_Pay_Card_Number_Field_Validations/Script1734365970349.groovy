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

TestObject FP_cardNo_Field = findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_FARE-PAY Card Number_serialNumber')

WebUI.setText(FP_cardNo_Field, 'AAAAAAAAAAAAAAAA')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, '@@@@@@@@@@@@@@@@')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, 'abcd  1234  abcd ')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, 'abcd1234abcd1234')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, '4416@@23##2276&&')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, '@AGBX###SFDD@@@@')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Invalid_fare_pay_card_number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, '4416  172     213  0')

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/verify_Card_Number_is_Invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_cardNo_Field, GlobalVariable.AMEX)

WebUI.sendKeys(FP_cardNo_Field, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_fare_pay_card_number_is_required'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(FP_cardNo_Field, '6373737')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Fare_pay_card_no_is_too_short'), [:], FailureHandling.STOP_ON_FAILURE)

