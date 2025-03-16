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

//// Bắt đầu ứng dụng
//Mobile.startApplication('/path/to/your/app.apk', false)
//
//// Đọc Logcat để kiểm tra sự kiện rung
//String logcatOutput = Mobile.getDeviceLogs()
//if (logcatOutput.contains("vibrator")) {
//	println("Ứng dụng đang rung!")
//} else {
//	println("Ứng dụng không rung.")
//}
//
//// Đóng ứng dụng
//Mobile.closeApplication()
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

// Khởi động ứng dụng
Mobile.startApplication('/path/to/your/app.apk', false)

// Xóa logcat để lấy log mới nhất
Mobile.executeShellCommand("logcat -c")

// Đợi một chút để ứng dụng rung (tùy vào logic của app)
Mobile.delay(3)

// Lấy logcat kiểm tra rung
String logOutput = Mobile.executeShellCommand("logcat -d | grep VibratorService")

if (logOutput.contains("VibratorService")) {
	KeywordUtil.logInfo("Ứng dụng đang rung!")
} else {
	KeywordUtil.logInfo("Ứng dụng không rung.")
}

// Đóng ứng dụng
Mobile.closeApplication()
