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

TestObject FP_PIN = findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_PIN_securityCode')


alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 3)

println('alphabets : ' + alphabets)

WebUI.setText(FP_PIN, alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.comment('alphabets shoud be accepted')
WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 3)

println('special_characters : ' + special_characters)

WebUI.setText(FP_PIN, special_characters)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('spaces', 3)

println('spaces : ' + spaces)

WebUI.setText(FP_PIN, spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

number_and_alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and alphabets', 3)

println('number and alphabets : ' + number_and_alphabets)

WebUI.setText(FP_PIN, number_and_alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

number_and_splCha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and special characters', 3)

println('number and special characters : ' + number_and_splCha)

WebUI.setText(FP_PIN, number_and_splCha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

alphabets_spcha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabet and special characters', 3)

println('alphabet and special characters : ' + alphabets_spcha)

WebUI.setText(FP_PIN, alphabets_spcha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.setText(FP_PIN, '1 R')

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_PIN'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.sendKeys(FP_PIN, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_PIN_is_required'), [:], FailureHandling.STOP_ON_FAILURE)

