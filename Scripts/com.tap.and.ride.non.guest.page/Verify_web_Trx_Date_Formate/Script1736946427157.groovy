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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.regex.Pattern
import java.util.regex.Matcher

String td_DateTime = WebUI.getText(findTestObject('Object Repository/Trx_object_repository/Page_Tap  Ride Dashboard  NJ Transit/td_DateTime'),
	FailureHandling.STOP_ON_FAILURE)

println('td_DateTime :' + td_DateTime)

KeywordUtil.logInfo("Date/Time: $td_DateTime")

// Step 2: Define the regex for MM/DD/YYYY HH:mm:ss format in 24-hour time

String regex = '^\\d{2}/\\d{2}/\\d{4} ([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$'

// Step 4: Validate the format using regex
Pattern pattern = Pattern.compile(regex)
Matcher matcher = pattern.matcher(td_DateTime)

if (matcher.matches()) {
	
	println("Date-Time format is valid.")
} else {
	
	println("Date-Time format is NOT valid.")
	assert false : "Date-Time format does not match MM/DD/YYYY HH:mm:ss."
}