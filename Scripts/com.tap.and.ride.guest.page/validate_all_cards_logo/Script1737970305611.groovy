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

List<String> cardNames = ['Visa card', 'Master card', 'American Express card', 'Discover card', 'Jcb card', 'Union Pay card']

for (String cardName : cardNames) {
	
    TestObject dynamicLogo = findTestObject('Page_Guest Tap  Ride  NJ Transit/div_Card Number_MuiBox-root css-1rgy1dx')

    dynamicLogo = WebUI.modifyObjectProperty(dynamicLogo, 'xpath', 'equals', ('//img[@alt=\'' + cardName) + '\']', true)

    WebUI.verifyElementVisible(dynamicLogo, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment('Verified: ' + cardNames + ' logo is displayed.')
}

assert cardNames.size() == 6 // Ensure all 6 logos are present

WebUI.comment(' All 6 logos are present')

println('All 6 logos are present')