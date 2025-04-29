package com.puttyconnection

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
import java.io.IOException
import internal.GlobalVariable
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.*
import java.awt.datatransfer.*
import java.awt.event.KeyEvent
import com.jcraft.jsch.*

public class StartPuTTY {


	@Keyword
	def launchPuttyssh() {

		// Define the path to the PuTTY executable
		//	String puttyPath = "\"C:\\Program Files (x86)\\PuTTY\\putty.exe\""
		String puttyPath = '"' + GlobalVariable.PuTTy_Path + '"'
		println('puttyPath :'+puttyPath)

		// Define SSH parameters
		String hostname = "10.150.10.20"
		int port = 22 // Default SSH port
		String username = GlobalVariable.SSH_USserName // "YJadhav"
		String password = GlobalVariable.SSH_Password //"F3bru@ry@2025"

		// Construct the command to execute PuTTY with SSH credentials
		String command = puttyPath + " -ssh " + username + "@" + hostname + " -P " + port + " -pw " + password ;

		println('command :'+command)
		try {
			// Start PuTTY process
			Process process = Runtime.getRuntime().exec(command);
			println("PuTTY started successfully and logging in...");
			Thread.sleep(5000)
			// Optionally, wait for the process to complete
			//process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			println(" Failed to start PuTTY.");
		}
	}
}


@Keyword
def closePuTTY() {
	try {
		// Command to forcefully close all PuTTY windows
		String command = "taskkill /F /IM putty.exe"

		// Execute the command
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();

		println(" PuTTY closed successfully.");
	} catch (IOException | InterruptedException e) {
		e.printStackTrace();
		println(" Failed to close PuTTY.");
	}
}


@Keyword
def startPutty_with_robot(){
	try {
		// Retrieve PuTTY path from global variable
		String puttyPath = '"' + GlobalVariable.PuTTy_Path + '"'  // Ensure path is enclosed in quotes for spaces
		println('PuTTY Path: ' + puttyPath)

		// SSH Credentials
		String hostname = "10.150.10.20"
		int port = 22 // Default SSH port
		String username = GlobalVariable.SSH_USserName
		String password = GlobalVariable.SSH_Password

		// Construct PuTTY launch command
		String command = puttyPath + " -ssh " + username + "@" + hostname + " -P " + port
		println("Executing command: " + command)

		// Launch PuTTY
		Process process = Runtime.getRuntime().exec(command)

		// Wait for PuTTY window to open
		Thread.sleep(5000)

		// Copy password to clipboard
		StringSelection pass_word = new StringSelection(password)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pass_word, null)

		// Simulate right-click to paste password
		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_SHIFT)
		robot.keyPress(KeyEvent.VK_INSERT)
		robot.keyRelease(KeyEvent.VK_INSERT)
		robot.keyRelease(KeyEvent.VK_SHIFT)

		// Press Enter to log in
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)

		println("PuTTY login attempt completed.")
	} catch (Exception e) {
		e.printStackTrace()
		println("Error during PuTTY automation: " + e.getMessage())
	}
}

@Keyword
def startPutty_with_cmd(){


	String puttyPath = GlobalVariable.PuTTy_Path.replace("\"", "") // Remove extra quotes
	String hostname = "10.150.10.20"
	String username = GlobalVariable.SSH_USserName
	String password = GlobalVariable.SSH_Password

	String command = "\"$puttyPath\" -ssh $username@$hostname -pw $password"
	println("Executing command: " + command)

	try {
		Process process = Runtime.getRuntime().exec(command)
		Thread.sleep(5000)
		println("PuTTY started successfully!")
	} catch (IOException | InterruptedException e) {
		e.printStackTrace()
		println("An error occurred while managing PuTTY.")
	}
}
