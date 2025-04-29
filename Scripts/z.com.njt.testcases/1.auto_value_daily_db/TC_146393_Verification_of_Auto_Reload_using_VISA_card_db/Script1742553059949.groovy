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

WebUI.callTestCase(findTestCase('com.login.page/Login_Into_NJT_LoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.login.page/Click_On_Sign_In'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Unregistered_fare_pay_card'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('com.profile.page/Delete_Credit_Card_From_Manage_Saved_Payments'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_on_fare_pay_card_tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_FP_Card_details_Add_Value_random'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/Verify_Card_Value_Before_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/click_on_Auto_Reload_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/Enter_Min_Reload_Max_Threshold_Amount'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.profile.page/Click_On_Add_New_Card_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.profile.page/Enter_VISA_Credit_Card_Details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.profile.page/Enter_Credit_Card_Details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.tap.and.ride.non.guest.page/Enter_Exp_Month_Year'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Enter_Random_Card_nickname'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/click_on_setup_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/verify_NJ_TRANSIT_will_automatically_reload'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('1.com.db/Verify_the_g_autoreload'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('1.com.db/validate_text_of_Msg_body_subject'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.auto.reload.page/verify_Fare_pay_dashboard_Auto_Reload'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.refresh()

WebUI.delay(10)

WebUI.comment('Card value should be added through autoreload')

WebUI.callTestCase(findTestCase('com.auto.reload.page/Verify_Card_Value_Before_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_TrxHistory_Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Click_Card_Value_Trasactions'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/Verify_Wallet_Transactions'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.Fare.Pay.Card.page/click_on_close_button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('1.com.db/Verify_the_p_autoreload_trx'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('com.njt.web.db/Verify_trx_type_and_bos_data'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

