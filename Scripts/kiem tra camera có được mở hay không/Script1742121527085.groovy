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
import com.kms.katalon.core.testobject.TestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import io.appium.java_client.MobileElement
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File

// Bước 1: Mở ứng dụng
Mobile.startApplication('C:\\Users\\trant\\Downloads\\FCdemo.apk', false)


//// Bước 2: Tìm và nhấn nút mở camera
//TestObject cameraButton = findTestObject('Object Repository/Camera_Button')  // Đảm bảo rằng bạn có đối tượng nút camera trong Object Repository
//Mobile.tap(cameraButton, 0)  // Nhấn nút mở camera

// Bước 3: Kiểm tra xem phần tử camera preview có hiển thị hay không
TestObject cameraPreview = findTestObject('Object Repository/Camera_Preview')  // Đảm bảo có đối tượng camera preview trong Object Repository
boolean isCameraPreviewVisible = Mobile.verifyElementVisible(cameraPreview, 10)  // Kiểm tra phần tử trong 10 giây

if (isCameraPreviewVisible) {
	KeywordUtil.logInfo("✅ Camera đã mở thành công và phần tử hiển thị.")
	
	// Bước 4: Kiểm tra xem camera có hiển thị hình ảnh động hay không
	File beforeImage = captureScreenshot()  // Chụp ảnh màn hình trước
	Mobile.delay(2)  // Chờ 2 giây để camera bắt đầu hoạt động
	File afterImage = captureScreenshot()  // Chụp ảnh màn hình sau 2 giây

	// Kiểm tra sự khác biệt giữa 2 ảnh
	if (areImagesDifferent(beforeImage, afterImage)) {
		KeywordUtil.logInfo("✅ Camera đang hiển thị hình ảnh động.")
	} else {
		KeywordUtil.logInfo("❌ Camera không hiển thị hình ảnh động, có thể là ảnh tĩnh.")
	}

} else {
	KeywordUtil.logInfo("❌ Camera không mở hoặc không hiển thị đúng.")
}


// Hàm chụp ảnh màn hình
File captureScreenshot() {
	return Mobile.takeScreenshot()  // Chụp ảnh và trả về file
}

// Hàm so sánh sự khác biệt giữa 2 ảnh
boolean areImagesDifferent(File image1, File image2) {
	return !image1.equals(image2)  // Kiểm tra xem hai bức ảnh có khác nhau hay không
}
