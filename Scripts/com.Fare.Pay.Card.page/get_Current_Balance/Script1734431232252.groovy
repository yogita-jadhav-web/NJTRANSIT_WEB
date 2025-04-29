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
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

String Max_Amount = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/p_Note Total Balance cannot be more than 500.00'))

String current_balance = WebUI.getText(findTestObject('Object Repository/Page_Fare-Pay Dashboard  NJ Transit/h3_Current Balance 275.00'))

println('current_balance: ' + current_balance)

String Maximum_balance = '$500.00'

String Max_Payable = Maximum_balance - current_balance

println('Max_Payable: ' + Max_Payable)

// Step 2: Define a Regular Expression to Match Dollar Values
Pattern pattern = Pattern.compile('\\$([0-9]+\\.[0-9]{2})')

String totalAmount = ''

String currentAmount = ''

// Step 3: Extract Numeric Amount from Message 1
Matcher matcher1 = pattern.matcher(Max_Amount)

if (matcher1.find()) {
    totalAmount = matcher1.group(1 // Extracts only the numeric part (500.00)
        )
}

// Step 4: Extract Numeric Amount from Message 2
Matcher matcher2 = pattern.matcher(current_balance)

if (matcher2.find()) {
    currentAmount = matcher2.group(1 // Extracts only the numeric part (275.00)
        )
}

// Step 5: Print the Extracted Numeric Values
println('Total Amount: ' + totalAmount // Output: 500.00
    )

println('Current Amount: ' + currentAmount // Output: 275.00
    )

// Optional: Convert to Double for Arithmetic Calculations
double total = Double.parseDouble(totalAmount)

double current = Double.parseDouble(currentAmount)

double remaining = total - current

double updatedRemaining = remaining + 5

println('Remaining Balance: ' + remaining  )

println('Updated Remaining Balance (Add 5): ' + updatedRemaining)

WebUI.click(findTestObject('AmountLessThanFive/Page_Fare-Pay Dashboard  NJ Transit/input_Add Value_addFunds'))

WebUI.sendKeys(findTestObject('AmountLessThanFive/Page_Fare-Pay Dashboard  NJ Transit/input_Add Value_addFunds'), Keys.chord(
        Keys.CONTROL, 'a') + Keys.BACK_SPACE)


WebUI.setText(findTestObject('Object Repository/AmountLessThanFive/Page_Fare-Pay Dashboard  NJ Transit/input_Add Value_addFunds'), 
    updatedRemaining)

