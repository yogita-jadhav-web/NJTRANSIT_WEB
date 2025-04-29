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
//******************
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

// Define test objects
TestObject select_zone = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Select Zone')

try {
    // Check if "Select Via" dropdown is visible
    if (WebUI.waitForElementVisible(select_zone, 10, FailureHandling.OPTIONAL)) {
        WebUI.comment('"Select zone" dropdown is visible.')

        // Click to open dropdown
        WebUI.click(select_zone)

        WebUI.delay(2)

        // Get all options from the "Select Via" dropdown
        List<WebElement> zone_options = WebUI.findWebElements(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_via_options'), 
            30)
		List<WebElement> enabledOptions = zone_options.findAll { it.getAttribute('aria-disabled') != 'true' }
		
        // Pick a random option if available
        if (!(enabledOptions.isEmpty())) {
            int randomIndex = new Random().nextInt(zone_options.size())

            WebElement randomOption = zone_options.get(randomIndex)

            // Log and select the random option
            String selectedValue = randomOption.getAttribute('data-value')

            WebUI.comment((('Randomly selected option: ' + randomOption.getText()) + ' | data-value: ') + selectedValue)
			WebUI.delay(2)
            randomOption.click()
			WebUI.delay(3)
            // Move focus away from the dropdown
          //  WebUI.sendKeys(select_zone, Keys.chord(Keys.TAB))

            WebUI.comment('Selected zone Option: ' + selectedValue)
        } else {
            WebUI.comment('No options available in "Select zone" dropdown.')
        }
    } else {
        WebUI.comment('"Select zone" dropdown is not visible. Proceeding to next steps.')
    }
    
    // Add further test steps here
    WebUI.comment('Continuing with the next steps...')
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.message)
} 

