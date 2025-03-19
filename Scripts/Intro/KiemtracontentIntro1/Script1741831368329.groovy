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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
//Mobile.callTestCase(findTestCase('splash'), null)
Mobile.callTestCase(findTestCase('Start app'), null)
Mobile.callTestCase(findTestCase('adsinter'), null)


String actualText = Mobile.getText(findTestObject('Object Repository/Intro/Text Funny Call With'), 10)

// So sánh thủ công
if (actualText == 'Funny Call With ' ) {
	KeywordUtil.logInfo('✅ Nội dung hiển thị chính xác: ' + actualText)
} else {
	KeywordUtil.markFailed('❌ Nội dung sai: ' + actualText)
}


String actualText1 = Mobile.getText(findTestObject('Object Repository/Intro/Text Famus Idol'), 10)




String actualText1 = Mobile.getText(findTestObject('Object Repository/Intro/Text Famus Idol'), 10)
if (actualText1.trim().equalsIgnoreCase(' FAMOUS IDOL')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText1 + "'")
}