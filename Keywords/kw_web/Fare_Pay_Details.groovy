package kw_web

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testdata.TestDataFactory
import internal.GlobalVariable



public class Fare_Pay_Details {

	static int cardIndex = 1

	@Keyword
	public Map<String, String> getNextCard() {
		// Load Excel Data
		def testData = TestDataFactory.findTestData("Data Files/Excel_Files/FP_Test_Data")

		// Get total rows
		int totalCards = testData.getRowNumbers()

		// Retrieve card number and PIN
		String cardNumber = testData.getValue("FP_Card_No", cardIndex)
		String cardPin = testData.getValue("FP_Pin", cardIndex)

		// Increment index
		cardIndex++

		// Reset index if all cards are used
		if (cardIndex > totalCards) {
			cardIndex = 1
		}

		// Return card details as a Map
		return ["cardNumber": cardNumber, "cardPin": cardPin]
	}
}


