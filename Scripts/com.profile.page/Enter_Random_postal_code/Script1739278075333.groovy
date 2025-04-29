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

TestObject zip_input = findTestObject('UserRegistration_object_Repository/Page_Create Account  NJ Transit/input_ZipPostalCode')

//Enter 4 digit Zip/Postal code
fourdigitnumbers = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 4)

println('fourdigitnumbers : ' + fourdigitnumbers)

WebUI.setText(zip_input, fourdigitnumbers)
TestObject update_button=findTestObject('Page_Profile  NJ Transit/button_Update')

boolean isClickable = false
int attempt = 1
int maxRetries = 3  // Set a limit to avoid infinite looping

// Define postal code lengths to try (4, 5, 6, ..., 10 digits)
List<Integer> zipLengths = [4, 5, 6]

// Loop through different postal code lengths until the button is clickable
for (int length : zipLengths) {
    for (int i = 1; i <= maxRetries / zipLengths.size(); i++) {
        // Generate a random postal code of the current length
        String zipCode = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', length)

        println("Attempt ${attempt}: Trying ${length}-digit zip code - " + zipCode)
		
	
		WebUI.sendKeys(zip_input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
        // Enter zip code
        WebUI.setText(zip_input, zipCode)

        // Wait briefly before checking
        WebUI.delay(1)

        // Check if "Update" button is clickable
        isClickable = WebUI.waitForElementClickable(update_button, 10, FailureHandling.OPTIONAL)

        if (isClickable) {
            WebUI.comment("Update button is clickable with zip code: " + zipCode)
            break
        } else {
            WebUI.comment("Update button is NOT clickable with zip code: " + zipCode)
        }

        attempt++
    }

    if (isClickable) break  
}
