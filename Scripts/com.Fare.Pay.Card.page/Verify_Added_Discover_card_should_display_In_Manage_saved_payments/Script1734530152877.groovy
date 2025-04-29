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

WebUI.scrollToElement(findTestObject('profile_Object_Repository/Page_Profile  NJ Transit/button_Manage Saved Payments_managePayments'), 
    10)

if (WebUI.verifyElementVisible(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/img_discover_card'), FailureHandling.OPTIONAL)) {
    boolean isCardAdded = WebUI.verifyElementPresent(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/img_discover_card'), 10)

    assert isCardAdded

    println('Discover is added successfully')
} else if (WebUI.verifyElementVisible(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/img_visa_card'), FailureHandling.OPTIONAL)) {
    WebUI.comment('The element is not visible.')
}

