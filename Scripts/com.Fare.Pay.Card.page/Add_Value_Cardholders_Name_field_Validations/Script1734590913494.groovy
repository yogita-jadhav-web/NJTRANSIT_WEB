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

TestObject FP_cardHolders_name = findTestObject('Object Repository/profile_Object_Repository/Page_Profile  NJ Transit/input_Cardholder_Name')

//WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 5)

println('alphabets : ' + alphabets)

WebUI.setText(FP_cardHolders_name, alphabets)

WebUI.comment('alphabets shoud be accepted')

WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/varify_cardholders_name_is_required'), [:], FailureHandling.STOP_ON_FAILURE)

special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 5)

println('special_characters : ' + special_characters)

WebUI.setText(FP_cardHolders_name, special_characters)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('spaces', 5)

println('spaces : ' + spaces)

WebUI.setText(FP_cardHolders_name, spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
decimal = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('decimal', 5)

println('decimal : ' + decimal)

WebUI.setText(FP_cardHolders_name, decimal)
WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

numbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 5)

println('numbers : ' + numbers)

WebUI.setText(FP_cardHolders_name, numbers)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
number_and_alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and alphabets', 8)

println('number and alphabets : ' + number_and_alphabets)

WebUI.setText(FP_cardHolders_name, number_and_alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(FP_cardHolders_name, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
number_and_splCha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and special characters', 5)

println('number and special characters : ' + number_and_splCha)

WebUI.setText(FP_cardHolders_name, number_and_splCha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_invalid_cardholders_name'), [:], FailureHandling.STOP_ON_FAILURE)

