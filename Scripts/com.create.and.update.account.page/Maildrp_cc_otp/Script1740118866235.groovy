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
import java.util.regex.*

// Open a new tab
WebUI.executeJavaScript('window.open();', [])

WebUI.delay(2)

// Switch to the new tab (index 1)
WebUI.switchToWindowIndex(1)

println('🆕 Switched to new tab for OTP collection')

// Navigate to Maildrop
WebUI.navigateToUrl('https://maildrop.cc/')

WebUI.maximizeWindow()

// Enter email in the Maildrop search field
WebUI.setText(findTestObject('Page_Maildrop - Free Disposable Email Address/input_Contact Us'), GlobalVariable.randomEmail)

// Click "View Mailbox" button
WebUI.click(findTestObject('Page_unequal.wallaby3730 Mailbox  Maildrop/button_View MailboxGo'))



String waitForEmailAndExtractOTP(String expectedEmail, int timeoutSeconds) {
    int elapsedTime = 0

    boolean emailFound = false

    String otpCode = ''

    while (elapsedTime < timeoutSeconds) {
        WebUI.click(findTestObject('Page_unequal.wallaby3730 Mailbox  Maildrop/button_Refresh Mailbox'))

        WebUI.delay(5)

        boolean isEmailDisplayed = WebUI.waitForElementPresent(findTestObject('Page_adgs Mailbox  Maildrop/div_cmsqaapp-noreplycmsservices.us'), 
            3, FailureHandling.OPTIONAL)

        if (isEmailDisplayed) {
            emailFound = true

            println(('✅ Email from ' + expectedEmail) + ' found!')

            WebUI.click(findTestObject('Page_adgs Mailbox  Maildrop/div_cmsqaapp-noreplycmsservices.us'))

            WebUI.delay(3)

            String emailBody = WebUI.getText(findTestObject('Page_adgs Mailbox  Maildrop/div_Thank you for creating your NJ TRANSIT _ec1834'))

            Pattern pattern = Pattern.compile('\\b\\d{6}\\b')

            Matcher matcher = pattern.matcher(emailBody)

            if (matcher.find()) {
                otpCode = matcher.group()

                println('🔢 Extracted OTP: ' + otpCode)
            } else {
                println('❌ OTP not found in the email body!')
            }
            
            break
        } else {
            println('⏳ Email not found, retrying...')

            elapsedTime += 5
        }
    }
    
    if (!(emailFound)) {
        println('❌ Email not received within timeout period!')
    }
    
    return otpCode
	
	
	// Switch back to the original tab
	WebUI.switchToWindowIndex(0)
	
	println('🔄 Switched back to the original tab')
	
	// Enter OTP in the verification field
	WebUI.setText(findTestObject('Object Repository/UserRegistration_object_Repository/Page_Verify Email  NJ Transit/input_securityCode'),
		otpCode)
	
	println('✅ OTP Entered: ' + otpCode)
}

