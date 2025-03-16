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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

// Mở ứng dụng
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File
Mobile.startApplication('C:\\Users\\trant\\Downloads\\FCdemo.apk', false)
Mobile.waitForElementPresent(findTestObject('Object Repository/Video'), 30) // Đợi video hiển thị



// 🎥 Hàm tính sự khác biệt giữa 2 ảnh
double getImageDifference(BufferedImage img1, BufferedImage img2) {
	int width = Math.min(img1.getWidth(), img2.getWidth())  // Đảm bảo cùng kích thước
	int height = Math.min(img1.getHeight(), img2.getHeight())
	long diff = 0

	for (int x = 0; x < width; x += 5) { // Giảm số pixel quét để tăng tốc
		for (int y = 0; y < height; y += 5) {
			int rgb1 = img1.getRGB(x, y)
			int rgb2 = img2.getRGB(x, y)
			diff += Math.abs((rgb1 & 0xFF) - (rgb2 & 0xFF)) // So sánh độ sáng pixel
		}
	}
	return (diff / (width * height)) // Trả về mức độ khác biệt
}

// 📸 Chụp 10 ảnh liên tiếp để kiểm tra sự thay đổi
List<BufferedImage> images = []
for (int i = 0; i < 2; i++) {
	// Chụp ảnh và lưu tạm thời trong thư mục
	String screenshotPath = Mobile.takeScreenshot("screenshot_" + i + ".png")
	
	// Đọc ảnh từ đường dẫn vừa chụp
	BufferedImage screenshot = ImageIO.read(new File(screenshotPath))
	images.add(screenshot)
	Thread.sleep(5000) // Chờ 500ms giữa các lần chụp
}

// 📊 Tính tổng sự khác biệt giữa các ảnh liên tiếp
double totalDifference = 0
for (int i = 1; i < images.size(); i++) {
	totalDifference += getImageDifference(images[i], images[i - 1])
}

// 🧐 Xác định có phải video không?
double threshold = 5.0  // Ngưỡng thay đổi để xác định video
if (totalDifference > threshold) {
	KeywordUtil.logInfo("✅ Đây là video!")
} else {
	KeywordUtil.logInfo("❌ Đây có thể là ảnh tĩnh hoặc loading animation.")
}

// Chụp nhiều ảnh liên tiếp
//int numScreenshots = 6
//int delayBetweenShots = 2 // thời gian chờ giữa các lần chụp (giây)
//List<BufferedImage> images = []
//
//for (int i = 0; i < numScreenshots; i++) {
//	String path = "screenshot" + i + ".png"
//	Mobile.takeScreenshot(path)
//	images.add(ImageIO.read(new File(path)))
//	Mobile.delay(delayBetweenShots)
//}
//
//// Hàm tính sự khác biệt giữa hai ảnh
//double getImageDifference(BufferedImage img1, BufferedImage img2) {
//	int width = img1.getWidth()
//	int height = img1.getHeight()
//	long diff = 0
//
//	for (int x = 0; x < width; x++) {
//		for (int y = 0; y < height; y++) {
//			int rgb1 = img1.getRGB(x, y)
//			int rgb2 = img2.getRGB(x, y)
//			diff += Math.abs((rgb1 & 0xFF) - (rgb2 & 0xFF)) // So sánh độ sáng pixel
//		}
//	}
//	return diff / (width * height) // Trả về phần trăm khác biệt
//}
//
//// Tính mức độ thay đổi giữa các ảnh
//double totalDifference = 0
//for (int i = 1; i < images.size(); i++) {
//	totalDifference += getImageDifference(images[i], images[i - 1])
//}
//
//double avgDifference = totalDifference / (numScreenshots - 1)
//
//// Nếu độ thay đổi trung bình thấp => Có thể là loading
//if (avgDifference < 5) { // Ngưỡng 5% (tuỳ chỉnh theo thử nghiệm)
//	KeywordUtil.logInfo("⚠️ Phát hiện hoạt ảnh lặp lại => Có thể là loading.")
//} else {
//	KeywordUtil.logInfo("✅ Nội dung thay đổi liên tục => Có thể là video.")
//}
