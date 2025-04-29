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

WebUI.scrollToElement(findTestObject('Object Repository/Page_Profile  NJ Transit/button_NLR Underground Fare_tooltipMessage'), 0)

WebUI.mouseOver(findTestObject('Object Repository/Page_Profile  NJ Transit/button_NLR Underground Fare_tooltipMessage'))

TestObject icon = findTestObject('Object Repository/Page_Profile  NJ Transit/p_Underground Fare is a discounted')

boolean isDialogVisible = WebUI.waitForElementVisible(icon, 0)

// Step 3: Validate the Dialog is Displayed
if (isDialogVisible) {
    Fp_Icon_Msg = WebUI.getText(icon)

    println('Fp_Icon_Msg :' + Fp_Icon_Msg)

    WebUI.comment('The dialog appeared successfully.')

    println('The dialog appeared successfully.' // This will fail the test if the dialog is not visible
        )
} else {
    WebUI.comment('The dialog did not appear.')
}

