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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

TestObject tariff_input = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_Tariff Type')

try {
    if (WebUI.waitForElementVisible(tariff_input, 10, FailureHandling.OPTIONAL)) {
        println('Tariff dropdown is present.')

        //    WebUI.click(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/div_tariff_DrpDwn'))
        WebUI.click(tariff_input)

        List<WebElement> t_options = WebUI.findWebElements(findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_via_options'), 
            30)

        println('Tt_options.' + t_options)

        int randomIndex = new Random().nextInt(t_options.size())

        println('randomIndex.' + randomIndex)

        WebElement randomOption = t_options.get(randomIndex)

        println('randomOption.' + randomOption)

        String selectedValue = randomOption.getAttribute('value')

        println('selectedValue.' + selectedValue)

        WebUI.comment((('Randomly selected option: ' + randomOption.getText()) + ' | data-value: ') + selectedValue)

        WebUI.delay(2)

        randomOption.click()

        WebUI.comment('Selected Trrif Option: ' + selectedValue)
    } else {
        println('Neither dropdown is present. Skipping selection.')
    }
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.message)
} 

