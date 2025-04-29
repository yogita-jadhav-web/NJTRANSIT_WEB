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

WebUI.click(findTestObject('Page_Tap  Ride Dashboard  NJ Transit/path _Edit_card_nickname'), FailureHandling.STOP_ON_FAILURE)

TestObject cardnickname_Input = findTestObject('Page_Tap  Ride Dashboard  NJ Transit/input_Card Nickname')

TestObject updatebtn = findTestObject('Page_Tap  Ride Dashboard  NJ Transit/button_updateBtn')

String cardnickname = CustomKeywords.'kw_web.kw_Random.getRandomFirstName'()

println('cardnickname: ' + cardnickname)

WebUI.setText(cardnickname_Input, cardnickname)

boolean isVisible = WebUI.waitForElementVisible(updatebtn, 10)

if (isVisible) {
    WebUI.click(updatebtn)

    println('Button is visible and clicked.')
} else {
    println('Button is Clickable as expected.')

    assert false : 'Button should be disabled but it is enabled.'
}

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/Verify_Nickname_Updated_Successfully'), [:], FailureHandling.STOP_ON_FAILURE)

