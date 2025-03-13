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
import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling

import io.appium.java_client.android.AndroidDriver




// Khởi động ứng dụng
Mobile.startApplication('C:\\Users\\Hi\\Downloads\\FCdemo.apk', true)
// Chờ một chút để quảng cáo tải lên
//
Mobile.delay(5)
// Kiểm tra xem "consent" có xuất hiện không
if (Mobile.verifyElementExist(findTestObject('Object Repository/btnconsent'), 5, FailureHandling.OPTIONAL)) {
	println("consent  xuất hiện! Đang đóng...")

	// Nhấn vào nút consent
	Mobile.tap(findTestObject('Object Repository/btnconsent'), 5)
	println("Đã nhấn vào nút đóng consent!")
} else {
	println("Không có consent.")
}

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


// **1. Kiểm tra tiêu đề màn hình**
Mobile.verifyElementText(findTestObject('Object Repository/Language/LanguageTitle'), 'Language')

Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/English"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/VietNam"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/UAE"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/China"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/Japan"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/TayBanNha"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/BoDaoNha"), 0)

Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/English"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/VietNam"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/UAE"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/China"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/Japan"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/TayBanNha"), 0)
Mobile.verifyElementVisible(findTestObject("Language/LanguageRadioButton/BoDaoNha"), 0)
int device_Width = Mobile.getDeviceWidth()
int device_Height = Mobile.getDeviceHeight()

println("Chiều rộng màn hình: " + device_Width)
println("Chiều cao màn hình: " + device_Height)
int startX = device_Width / 2
int startY = device_Height * 0.4 // 
int endY = device_Height * 0.3   // 


Mobile.verifyElementVisible(findTestObject("Language/FloodItAd"), 0)
//Mobile.verifyElementVisible(findTestObject("Language/FloodItAdDescription"), 0)
//Mobile.verifyElementVisible(findTestObject("Language/FloodItAdImage"), 0)
Mobile.verifyElementVisible(findTestObject("Language/FloodItAdInstallButton"), 0)
Mobile.verifyElementVisible(findTestObject("Language/FloodItMediaView"), 0)
//Mobile.verifyElementVisible(findTestObject("Language/LableItAd"), 0)
Mobile.tap(findTestObject("Language/LanguageRadioButton/English"), 0)

for (int i = 0; i < 3; i++) { // Thử lại 3 lần nếu lỗi
	try {
		TestObject vietnamOption = findTestObject('Object Repository/Language/LanguageOption/English')
		Mobile.tap(vietnamOption, 5)
		break // Nếu tap thành công, thoát khỏi vòng lặp
	} catch (Exception e) {
		Mobile.delay(2) // Chờ 2 giây rồi thử lại
	}
}



Mobile.swipe(200, 500, 200, 300)

Mobile.tap(findTestObject("Language/Buttonselect"), 0)

// **6. Đóng ứng dụng**
//Mobile.closeApplication()
