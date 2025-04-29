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

WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/img_credit_card'))

fullText = WebUI.getText(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_credid_card_fullText'))

println('fullText :' + fullText)

// Use regex to extract the last 4 digits of the card number
//cardNumber = (((fullText =~ '(\\d{4})\\)')[0])[1])


//String cardNumber = fullText.split(' ')[-1].replace(')', '')

//GlobalVariable.Card_Number=cardNumber
//println('cardNumber :' + cardNumber)


String[] parts = fullText.split(' ')

// Get "XXX1" (second last) and "003" (last), remove non-numeric characters
String part1 = parts[-2].replaceAll('[^0-9]', '') // Extract digits from "XXX1"
String part2 = parts[-1].replace(')', '').trim()  // Remove parenthesis from "003)"

// Combine to form "1003"
String cardNumber = part1 + part2

GlobalVariable.Card_Number=cardNumber
println('cardNumber :' + cardNumber)
println('cardNumber:************* ' )
