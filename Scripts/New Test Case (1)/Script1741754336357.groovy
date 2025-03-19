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

Mobile.startApplication('C:\\Users\\Hi\\Downloads\\FCdemo.apk', true)

Mobile.swipe(0, 0, 0, 0)

Mobile.swipe(0, 0, 0, 0)

Mobile.swipe(500, 800, 200, 200)

Mobile.scrollToText('Malaysia')

Mobile.closeApplication()

Mobile.tap(findTestObject("Language/LanguageRadioButton/English"), 0)

// Lấy phần tử nút cần kiểm tra màu sắc
// Giả sử mobileElement là đối tượng phần tử bạn muốn lấy tọa độ
TestObject testObject = findTestObject('Object Repository/Language/LanguageTitle')

// Chuyển đối tượng Katalon TestObject thành MobileElement của Appium
MobileElement element = (MobileElement) Mobile.getDriver().findElement(testObject.getSelector())

MobileElement mobileElement = findTestObject('Object Repository/Language/LanguageTitle')

// Lấy tọa độ của phần tử
Point location = mobileElement.getLocation()

// Lấy tọa độ x và y
int x = location.getX()
int y = location.getY()

// In ra tọa độ
println("X: " + x + ", Y: " + y)

//
//WebElement button = MobileDriverFactory.getDriver().findElement(By.id('com.asianmobile.fakecall:id/ivApply'))
//
//String color = button.getAttribute("color")  // hoặc "background-color"
//println("Color: " + color)

File screenshot = Mobile.takeScreenshot()  // Chụp ảnh màn hình
BufferedImage img = ImageIO.read(screenshot)  // Đọc ảnh đã chụp
int grb = img.getRGB(x, y)  // Lấy màu của pixel tại tọa độ x, y

// Chuyển đổi RGB thành mã Hex
Color color = new Color(grb)
String hexColor = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue())



// So sánh với màu mong muốn (ví dụ: màu xanh lá cây)
String expectedColor = "#FFFFFF" // Mã màu xanh lá cây

// Kiểm tra màu sắc
if (color.equals(expectedColor)) {
	Mobile.comment("Màu sắc đúng như mong đợi: " + expectedColor)
} else {
	Mobile.comment("Màu sắc không đúng. Màu sắc hiện tại: " + color)
}




TestObject title = findTestObject('Object Repository/Language/LanguageTitle')
Mobile.getAttribute(findTestObject('Object Repository//Language/LanguageTitle'), null, 0)
Mobile.getElementAttribute(title, '#FF6600', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementFont(title, 'bold', FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementSize(title, 200, 50, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementPosition(title, 540, 100, FailureHandling.CONTINUE_ON_FAILURE)
String[] languages = ['English', 'Tiếng Việt', 'فارسی', '日本', '中国', 'Español', 'Português']
int yPosition = 200

for (String lang : languages) {
	TestObject langItem = findTestObject("Object Repository/LanguageScreen/text_${lang}")
	
	Mobile.verifyElementFont(langItem, 'default', FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.verifyElementColor(langItem, '#000000', FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.verifyElementPosition(langItem, 100, yPosition, FailureHandling.CONTINUE_ON_FAILURE)
	yPosition += 100
}

TestObject installBtn = findTestObject('Object Repository/LanguageScreen/button_Install')

Mobile.verifyElementColor(installBtn, '#FF6600', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementSize(installBtn, 150, 50, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.verifyElementPosition(installBtn, 900, 1700, FailureHandling.CONTINUE_ON_FAILURE)

// Đóng ứng dụng
Mobile.closeApplication()


TestObject testObject = findTestObject('Object Repository/Intro/textnext')

String screenshotPath = 'screenshot_background.png'
Mobile.takeScreenshot(screenshotPath)

// ✅ 3. Đọc ảnh và lấy màu tại vị trí mong muốn
File imageFile = new File(screenshotPath)
BufferedImage img = ImageIO.read(imageFile)


import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.driver.DriverFactory
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Start app'), null)


// Lấy MobileDriver của ứng dụng

MobileElement element = (MobileElement) Mobile.findElementByXPath(testObject.getSelectorCollection().get('//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]'))

// Lấy tọa độ (X, Y) của đối tượng
int x = element.getLocation().getX()
int y = element.getLocation().getY()

// Lấy kích thước (Width, Height) của đối tượng
int width = element.getSize().getWidth()
int height = element.getSize().getHeight()

// In ra thông tin về tọa độ và kích thước
println("Tọa độ X: " + x)
println("Tọa độ Y: " + y)
println("Chiều rộng: " + width)
println("Chiều cao: " + height)


Color actualColor = new Color(img.getRGB(x, y))

// ✅ 4. Chuyển đổi màu thành mã HEX
String actualHexColor = String.format("#%02x%02x%02x", actualColor.getRed(), actualColor.getGreen(), actualColor.getBlue()).toUpperCase()

// ✅ 5. Xác định màu mong đợi (HEX)
String expectedHexColor = "#000000" // Ví dụ: màu đen

// ✅ 6. So sánh kết quả
if (actualHexColor.equals(expectedHexColor)) {
	KeywordUtil.logInfo("✅ Background color is correct: " + actualHexColor)
} else {
	KeywordUtil.markFailed("❌ Background color is incorrect! Expected: " + expectedHexColor + ", but found: " + actualHexColor)
}
