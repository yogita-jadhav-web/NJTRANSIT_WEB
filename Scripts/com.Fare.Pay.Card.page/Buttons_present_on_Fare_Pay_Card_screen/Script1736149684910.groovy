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



// button=WebUI.verifyElementNotClickable(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Add FARE-PAY Card'), 
//    FailureHandling.STOP_ON_FAILURE)
 
 //TestObject addFP_button=findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Add FARE-PAY Card')

CustomKeywords.'kw_web.web.scrollToPageBottom'()

WebUI.delay(2)

Map<String, String> buttons = [
	
	
    "Add Value"       : 'Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Add Value',
    "Buy Tickets"     : 'Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Buy Tickets',
    "Auto Reload"     : 'Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Auto Reload',
    "TRX History"     : 'Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_TRX. History',
    "Report Lost"     : 'Object Repository/Page_Fare-Pay Dashboard  NJ Transit/button_Report LostStolen'
]

// Iterate through each button
buttons.each { buttonName, buttonPath ->
    TestObject button = findTestObject(buttonPath)
    boolean isNotClickable = WebUI.verifyElementNotClickable(button, FailureHandling.CONTINUE_ON_FAILURE)
    
    if (!isNotClickable) {
        WebUI.comment("The '${buttonName}' button is incorrectly clickable.")
        println("${buttonName} button is clickable.")
    } else {
        WebUI.comment("The '${buttonName}' button is correctly not clickable.")
        println("${buttonName} button is not clickable.")
    }
}