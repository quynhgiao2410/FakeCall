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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.io.File
import java.util.List
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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.io.File
import java.util.List

Mobile.callTestCase(findTestCase('Start app'), null)
  
// Lấy đối tượng AppiumDriver
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

if (driver == null) {
	KeywordUtil.logInfo("❌ Không thể lấy Appium Driver. Kiểm tra kết nối Appium.")
	Mobile.closeApplication()
	return
}

// Đường dẫn đến thư mục chứa ảnh trên thiết bị (ví dụ: /storage/emulated/0/Pictures)
String imageDirectory = "/storage/emulated/0/Pictures" // Thay đổi đường dẫn nếu cần

// Lấy danh sách các file ảnh trong thư mục
List<String> deviceImages = getDeviceImages(imageDirectory)

// Lấy danh sách các ảnh mà ứng dụng hiển thị (cần điều chỉnh tùy theo ứng dụng)
List<String> appImages = getAppImages()

// In ra số ảnh ứng dụng lấy được
KeywordUtil.logInfo("Ứng dụng lấy được " + appImages.size() + " ảnh.")

// So sánh danh sách ảnh
if (deviceImages.size() == appImages.size() && deviceImages.containsAll(appImages)) {
	KeywordUtil.logInfo("✅ Ứng dụng hiển thị đầy đủ ảnh từ thiết bị.")
} else {
	KeywordUtil.logInfo("❌ Ứng dụng không hiển thị đầy đủ ảnh từ thiết bị.")
	// In ra danh sách ảnh thiếu (nếu cần)
	deviceImages.removeAll(appImages)
	KeywordUtil.logInfo("Ảnh thiếu: " + deviceImages)
}

// Đóng ứng dụng
Mobile.closeApplication()

// Hàm lấy danh sách file ảnh trên thiết bị
List<String> getDeviceImages(String directoryPath) {
	List<String> imageList = []
	File directory = new File(directoryPath)
	File[] files = directory.listFiles()

	if (files != null) {
		for (File file : files) {
			if (file.isFile() && (file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".png"))) {
				imageList.add(file.getName())
			}
		}
	}
	return imageList
}

// Hàm lấy danh sách ảnh mà ứng dụng hiển thị (cần điều chỉnh tùy theo ứng dụng)
List<String> getAppImages() {
	List<String> appImageList = []
	// Thêm logic để lấy danh sách ảnh từ ứng dụng
	// Ví dụ: Lấy danh sách các ImageView hoặc các phần tử chứa ảnh
	// appImageList.add("image1.jpg")
	// appImageList.add("image2.png")
	return appImageList
}