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
import org.jsoup.Jsoup as Jsoup
import groovy.json.JsonSlurper as JsonSlurper
import groovy.json.JsonOutput as JsonOutput
import org.jsoup.select.Elements as Elements
import org.jsoup.nodes.Document as Document
import org.jsoup.nodes.Element as Element

Mas_DB_Connection = CustomKeywords.'com.masqa.db.NJT_Mas_Database.get_MySQL_Mas_DBConnection'(GlobalVariable.NJT_Mas_DB_Url, 
    GlobalVariable.NJT_Mas_DB_UserName, GlobalVariable.NJT_Mas_DB_Password)

String htmlContent = CustomKeywords.'com.masqa.db.NJT_Mas_Database.get_message_body_from_DB'(Mas_DB_Connection, GlobalVariable.Email)

def jsonSlurper = new JsonSlurper()

def doc = Jsoup.parse(htmlContent)

def plainText = doc.text().replaceAll('\\s{2,}', '\n').trim()

println('Extracted Plain Text: ' + plainText)

WebUI.comment('Extracted Plain Text: ' + plainText)

// Extract email subject
Subject = CustomKeywords.'com.masqa.db.NJT_Mas_Database.verify_text_present_in_subject'(Mas_DB_Connection, GlobalVariable.Email)

WebUI.comment('Extract email subject: ' + Subject)

// Extract all tables
Elements tables = doc.select('table')

List<Map> allTablesData = []

for (Element table : tables) {
    List<String> headers = table.select('tr').first().select('th').eachText()

    List<Map> rows = []

    for (Element row : table.select('tr').next()) {
        List<String> rowData = row.select('td').eachText()

        if (rowData.size() == headers.size()) {
            Map<String, String> rowMap = [:]

            headers.eachWithIndex({ def header, def index ->
                    (rowMap[header]) = (rowData[index])
                })

            rows.add(rowMap)
        }
    }
    
    allTablesData.add([('headers') : headers, ('rows') : rows])
}

// Convert extracted table data to JSON
String jsonOutput = JsonOutput.prettyPrint(JsonOutput.toJson(allTablesData))

println('Extracted Table Data in JSON format:\n' + jsonOutput)

WebUI.comment('Extracted Table Data: ' + jsonOutput)

