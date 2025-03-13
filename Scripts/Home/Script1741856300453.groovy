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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil

Mobile.callTestCase(findTestCase('splash'), null)

Mobile.tap(findTestObject("Language/LanguageRadioButton/English"), 0)

Mobile.tap(findTestObject("Language/Buttonselect"), 0)
Mobile.tap(findTestObject("Intro/btnnext"), 0)

Mobile.tap(findTestObject("Intro/Text Start"), 0)
Mobile.tap(findTestObject("Favourite/BtnGetStarted"), 0)


Mobile.delay(5)
// Kiểm tra xem "Test Ad" có xuất hiện không
if (Mobile.verifyElementExist(findTestObject('Object Repository/Test_Ad'), 5, FailureHandling.OPTIONAL)) {
	println("Quảng cáo xuất hiện! Đang đóng...")

	// Nhấn vào nút Close Ads
	Mobile.tap(findTestObject('Object Repository/Close_Ads_Button'), 5)
	println("Đã nhấn vào nút đóng quảng cáo!")
} else {
	println("Không có quảng cáo xuất hiện.")
}
Mobile.tap(findTestObject("Permission/CONTINUE"), 0)

// Định nghĩa số lần kiểm tra
int totalChecks = 5   // Số lần kiểm tra (5 lần)
int interval = 20       // Thời gian chờ giữa mỗi lần kiểm tra (giây)

// Lặp kiểm tra xem Dialog có xuất hiện không
for (int i = 1; i <= totalChecks; i++) {
	KeywordUtil.logInfo("🔍 Kiểm tra lần thứ " + i)
	
	// Chờ 5 giây trước khi kiểm tra
	Mobile.delay(interval)
	
	// Kiểm tra xem Dialog có xuất hiện không
	boolean isDialogPresent = Mobile.waitForElementPresent(findTestObject('Object Repository/Home/DialogIncomingCall'), 3, FailureHandling.OPTIONAL)
	
	if (isDialogPresent) {
		KeywordUtil.markPassed("✅ Dialog xuất hiện tại lần kiểm tra thứ " + i)
	} else {
		KeywordUtil.markWarning("⚠ Dialog KHÔNG xuất hiện tại lần kiểm tra thứ " + i)
	}
}

// Đóng ứng dụng sau khi kiểm tra xong
Mobile.closeApplication()
