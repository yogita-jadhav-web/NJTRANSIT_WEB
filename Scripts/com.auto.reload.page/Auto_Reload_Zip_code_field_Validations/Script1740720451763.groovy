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

TestObject card_Zipcode = findTestObject('Object Repository/profile_Object_Repository/Page_Profile  NJ Transit/input_Zip_Code')

WebUI.scrollToElement(card_Zipcode, 0)

//Enter alphabet
alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabets', 4)

println('alphabets : ' + alphabets)

WebUI.comment('Enter alphabet :' + alphabets)

WebUI.setText(card_Zipcode, alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.comment('alphabets shoud be accepted')
WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter special character
special_characters = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('special characters', 4)

println('special_characters : ' + special_characters)

WebUI.comment('Enter special character :' + special_characters)

WebUI.setText(card_Zipcode, special_characters)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter space
spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('spaces', 4)

println('spaces : ' + spaces)

WebUI.comment('Enter  spaces :' + spaces)

WebUI.setText(card_Zipcode, spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of number and alphabet
number_and_alphabets = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and alphabets', 4)

println('number and alphabets : ' + number_and_alphabets)

WebUI.comment('Enter combination of number and alphabet :' + number_and_alphabets)

WebUI.setText(card_Zipcode, number_and_alphabets)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of number and special character
number_and_splCha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number and special characters', 4)

println('number and special characters : ' + number_and_splCha)

WebUI.comment('Enter combination of number and special character :' + number_and_splCha)

WebUI.setText(card_Zipcode, number_and_splCha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter combination of alphabet and special character
alphabets_spcha = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('alphabet and special characters', 4)

println('alphabet and special characters : ' + alphabets_spcha)

WebUI.comment('Enter combination of alphabet and special character :' + alphabets_spcha)

WebUI.setText(card_Zipcode, alphabets_spcha)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter valid number with space
Num_Spaces = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('number with spaces', 4)

println('number with spaces : ' + Num_Spaces)

WebUI.comment('Enter valid number with space :' + Num_Spaces)

WebUI.setText(card_Zipcode, Num_Spaces)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

//Enter valid number less than 5 digits
inv_Num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 4)

println('Enter valid number less than 5 digits  : ' + inv_Num)

WebUI.comment('Enter valid number less than 5 digits :' + inv_Num)

WebUI.setText(card_Zipcode, inv_Num)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Please_enter_a_valid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter value and clear the field
WebUI.sendKeys(card_Zipcode, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Zip_code_is_required'), [:], FailureHandling.STOP_ON_FAILURE)

//Enter random number more than 5 digits
enter_Num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 6)

println('Enter random number more than 5 digit  : ' + enter_Num)

WebUI.comment('Enter random number more than 5 digits :' + enter_Num)

WebUI.setText(card_Zipcode, enter_Num)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)
//Enter invalid(alphabet/special character/space) more than 5 digits
enter_Num = "A # a "

println('Enter invalid(alphabet/special character/space) more than 5 digits  : ' + enter_Num)

WebUI.comment('Enter invalid(alphabet/special character/space) more than 5 digits :' + enter_Num)

WebUI.setText(card_Zipcode, enter_Num)
WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Invalid_zip_code'), [:], FailureHandling.STOP_ON_FAILURE)
