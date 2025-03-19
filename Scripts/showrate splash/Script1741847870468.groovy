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
import com.kms.katalon.core.util.KeywordUtil
Mobile.callTestCase(findTestCase('Start app'), null)

Mobile.startApplication('C:\\Users\\Hi\\Downloads\\FCdemo.apk', true)
Mobile.delay(2)
// Kiểm tra xem "consent" có xuất hiện không
if (Mobile.verifyElementExist(findTestObject('Object Repository/btnconsent'), 5, FailureHandling.OPTIONAL)) {
	println("consent  xuất hiện! Đang đóng...")

	// Nhấn vào nút consent
	Mobile.tap(findTestObject('Object Repository/btnconsent'), 5)
	println("Đã nhấn vào nút đóng consent!")
} else {
	println("Không có consent.")
}

// Chờ và xác minh quảng cáo xuất hiện
Mobile.waitForElementPresent(findTestObject('Object Repository/Test_Ad'), 30)
int totalAdsShown = 0
int totalTests = 5

for (int i = 0; i < totalTests; i++) {
	Mobile.startApplication('C:\\Users\\Hi\\Downloads\\FCdemo.apk', false)
//	Mobile.delay(30)
	// Chờ và kiểm tra quảng cáo xuất hiện
	if (Mobile.waitForElementPresent(findTestObject('Object Repository/Test_Ad'), 30)) {
		totalAdsShown++
	}
	
	// Đóng ứng dụng hoặc quay lại màn hình chính
	Mobile.closeApplication()
}



// Tính phần trăm (đảm bảo dùng double để tính toán chính xác)
double showRate = (totalAdsShown / (double)totalTests) * 100


// Sử dụng String.format để làm tròn đến 2 chữ số thập phân
String formattedShowRate = String.format("%.2f", showRate)
//==========================================================================================
