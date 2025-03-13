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

// **2. Kiểm tra danh sách ngôn ngữ**
//def languages = ['English', 'VietNam', 'UAE', 'Japan', 'China', 'TayBanNha', 'BoDaoNha']
//
//for (def language : languages) {
//	// Kiểm tra sự tồn tại của mỗi ngôn ngữ, biểu tượng và nút radio
//	Mobile.verifyElementVisible(findTestObject("Language/LanguageOption/${language}"), FailureHandling.CONTINUE_ON_FAILURE)
//	Mobile.verifyElementVisible(findTestObject("Object Repository/Language/LanguageRadioButton/${language}"), FailureHandling.CONTINUE_ON_FAILURE)
//}

// **3. Kiểm tra chức năng cuộn màn hình để hiển thị đầy đủ danh sách ngôn ngữ**
Mobile.swipe(200, 800, 200, 200) // Cuộn từ dưới lên trên

// Lặp lại kiểm tra ngôn ngữ sau khi cuộn
for (def language : languages) {
	Mobile.verifyElementVisible(findTestObject("Object Repository/Language/LanguageOption/${language}"), FailureHandling.CONTINUE_ON_FAILURE)
}

// **4. Kiểm tra sự hiện diện của quảng cáo AdMob**
Mobile.verifyElementVisible(findTestObject('Object Repository/AdMobAd'), FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/AdMobAdImage'), FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/AdMobAdTitle'), FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/AdMobAdDescription'), FailureHandling.CONTINUE_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/AdMobAdInstallButton'), FailureHandling.CONTINUE_ON_FAILURE)

// **5. Kiểm tra màu sắc, kích thước, vị trí các phần tử**
def checkElementStyle(TestObject obj, String expectedColor, int expectedWidth, int expectedHeight) {
	def color = Mobile.getAttribute(obj, 'backgroundColor', FailureHandling.CONTINUE_ON_FAILURE)
	def width = Mobile.getElementWidth(obj)
	def height = Mobile.getElementHeight(obj)
	
	Mobile.verifyMatch(color, expectedColor, false, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.verifyEqual(width, expectedWidth, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.verifyEqual(height, expectedHeight, FailureHandling.CONTINUE_ON_FAILURE)
}

// Kiểm tra màu sắc và kích thước của nút INSTALL trên quảng cáo
checkElementStyle(findTestObject('Object Repository/AdMobAdInstallButton'), '#FFA500', 120, 50) // Màu cam, kích thước 120x50px

Mobile.closeApplication()

