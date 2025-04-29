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

// Step 1: Identify the dropdown (ul element)
TestObject dropdown = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/div_6375-0041-0503-9859')

WebUI.click(dropdown)

TestObject li_ele = findTestObject('Page_Fare-Pay Dashboard  NJ Transit/li_FP_optn')

// Step 2: Get all 'li' elements inside the dropdown (ul)
List<TestObject> listItems = WebUI.findWebElements(li_ele, 30)

// Step 3: Validate and count the number of cards (li elements)
int cardCount = listItems.size()

// Step 4: Print or assert the count
println('Number of cards added: ' + cardCount)
WebUI.comment('Number of cards added: ' + cardCount)
// Example validation (you can customize this based on your needs):
assert cardCount > 0 : 'No cards were found in the dropdown'

WebUI.sendKeys(li_ele, Keys.chord(Keys.ESCAPE))

