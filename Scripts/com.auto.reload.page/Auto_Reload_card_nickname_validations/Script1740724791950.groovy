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

TestObject card_nickname = findTestObject('fareCardNum_ExistingCC/Page_Fare-Pay Dashboard  NJ Transit/input_CardNickname')

WebUI.scrollToElement(card_nickname, 0)

//Enter alphabet
alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 10)

println('alphabets : ' + alphabets)

WebUI.comment('Enter alphabets : ' + alphabets)

WebUI.setText(card_nickname, alphabets)

WebUI.comment('alphabets shoud be accepted')

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter special character
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 10)

println('Enter special character : ' + special_characters)

WebUI.comment('Enter special character : ' + special_characters)

WebUI.setText(card_nickname, special_characters)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter space
spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('spaces', 10)

println('spaces : ' + spaces)

WebUI.comment('Enter spaces : ' + spaces)

WebUI.setText(card_nickname, spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of number and alphabet
number_and_alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and alphabets', 8)

println('Enter combination of number and alphabet : ' + number_and_alphabets)

WebUI.comment('Enter combination of number and alphabet : ' + number_and_alphabets)

WebUI.setText(card_nickname, number_and_alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of number and special character
number_and_splCha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and special characters', 10)

println('number and special characters : ' + number_and_splCha)

WebUI.comment('Enter combination of number and special character : ' + number_and_splCha)

WebUI.setText(card_nickname, number_and_splCha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of alphabet and special character
alpha_and_splCha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabet and special characters', 10)

println('alphabet and special characters : ' + alpha_and_splCha)

WebUI.comment('Enter combination of alphabet and special character : ' + alpha_and_splCha)

WebUI.setText(card_nickname, alpha_and_splCha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter number with space
num_spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number with spaces', 10)

println('number with spaces: ' + num_spaces)

WebUI.comment('Enter combination of number and speces : ' + num_spaces)

WebUI.setText(card_nickname, num_spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_invalid'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter value and clear the field
WebUI.sendKeys(card_nickname, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Card_Nickname_is_required'), [:], FailureHandling.STOP_ON_FAILURE)