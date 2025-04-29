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

//WebUI.scrollToElement(findTestObject('Page_Profile  NJ Transit/h2_Manage Saved Payments'), 0)
CustomKeywords.'kw_web.web.scrollToPageBottom'()

WebUI.delay(5)

fullText = WebUI.getText(findTestObject('Page_Profile  NJ Transit/span_card_text'))

println('fullText :' + fullText)

// Define regex to extract text before the number
Pattern pattern = Pattern.compile('^(.*?)\\s*\\(.*\\d{3}\\)')

Matcher matcher = pattern.matcher(fullText)

String extractedText = ''

if (matcher.find()) {
    extractedText = matcher.group(1).trim()

    println('Extracted Text: ' + extractedText)
} else {
    println('No match found!')
}

String card_nickName = GlobalVariable.card_nickname

println('card_nickName : ' + card_nickName)

WebUI.comment('card_nickName : ' + card_nickName)

WebUI.verifyMatch(card_nickName, extractedText, false)

