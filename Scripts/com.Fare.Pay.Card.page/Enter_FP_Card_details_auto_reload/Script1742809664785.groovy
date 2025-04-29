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


// Load the Test Data
TestData data = findTestData("Data Files/Excel_Files/FP_Auto_Reload_Test_Data")  // Replace with actual test data name
//
findTestData("Data Files/Excel_Files/FP_Test_Data")
// Get data from a specific row (Example: Row 1)
String cardNumber = data.getValue("FP_Card_No", 2)
String pin = data.getValue("FP_Pin", 2)

println ("Card Number: " + cardNumber)
println ("PIN: " + pin)

WebUI.setText(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_FARE-PAY Card Number_serialNumber'), 
    cardNumber)

WebUI.click(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_PIN_securityCode'))

WebUI.setText(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/input_PIN_securityCode'), 
   pin)

WebUI.click(findTestObject('Object Repository/fareCardNum_ExistingCC/Page_Add Fare-Pay Card  NJ Transit/div_Add FARE-PAY Card'))

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/verify_Your_FARE_PAY_card_has_been_registered_successfully'), [:], 
    FailureHandling.STOP_ON_FAILURE)

