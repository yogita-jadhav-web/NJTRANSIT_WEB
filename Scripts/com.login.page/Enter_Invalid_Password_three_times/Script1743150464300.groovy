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

ran_num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 3)

password = ('Test@' + ran_num.toString())
println('password :'+password)
TestObject Fname_Input = findTestObject('LoginTC_Object_Repository/Page_Sign In  NJ Transit/input_Password')

WebUI.setText(Fname_Input, password)
ran_num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 3)

password = ('Test@' + ran_num.toString())
println('password :'+password)
WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Verify_Invalid_Email_Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Fname_Input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
ran_num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 3)

password = ('Test@' + ran_num.toString())
WebUI.setText(Fname_Input, password)
println('password :'+password)
WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Verify_Invalid_Email_Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Fname_Input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
ran_num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 3)

password = ('Test@' + ran_num.toString())
WebUI.setText(Fname_Input, password)
println('password :'+password)
WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Verify_Invalid_Email_Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(Fname_Input, Keys.chord(Keys.CONTROL, 'a') + Keys.BACK_SPACE)
ran_num = CustomKeywords.'kw_web.kw_Random.generateRandomInput'('numbers', 3)

password = ('Test@' + ran_num.toString())
WebUI.setText(Fname_Input, password)
println('password :'+password)
WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Verify_Invalid_Email_Password'), [:], FailureHandling.STOP_ON_FAILURE)

