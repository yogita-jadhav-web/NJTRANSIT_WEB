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
import com.kms.katalon.core.util.KeywordUtil
import java.nio.file.*
import internal.GlobalVariable


public class unusedobjets {

	@Keyword
	public static FindUnusedObjects() {
		/**
		 * This script identifies unused objects in the Object Repository.
		 */

		// Define paths to folders
		String objectRepoPath = "Object Repository"
		String testCasesPath = "Test Cases"
		String keywordsPath = "Keywords"

		// List to store unused objects
		List<String> unusedObjects = []

		// Get all objects in the Object Repository
		File objectRepoDir = new File(objectRepoPath)
		objectRepoDir.eachFileRecurse { objectFile ->
			if (objectFile.name.endsWith(".rs")) {
				String objectName = objectFile.name.replace(".rs", "")
				boolean isUsed = false

				// Check for object usage in Test Cases
				new File(testCasesPath).eachFileRecurse { testCaseFile ->
					if (testCaseFile.text.contains(objectName)) {
						isUsed = true
					}
				}

				// Check for object usage in Keywords
				new File(keywordsPath).eachFileRecurse { keywordFile ->
					if (keywordFile.text.contains(objectName)) {
						isUsed = true
					}
				}

				// If not used, add to unused objects list
				if (!isUsed) {
					unusedObjects.add(objectFile.absolutePath)
				}
			}
		}

		// Log the result
		if (unusedObjects.isEmpty()) {
			KeywordUtil.logInfo("No unused objects found.")
		} else {
			KeywordUtil.logWarning("Unused objects found:")
			unusedObjects.each { objectPath ->
				KeywordUtil.logWarning(objectPath)
			}
		}
	}
}
