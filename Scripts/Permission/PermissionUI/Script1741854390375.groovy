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
Mobile.callTestCase(findTestCase('Start app'), null)

Mobile.callTestCase(findTestCase('adsinter'), null)

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


boolean isElementPresent = Mobile.verifyElementExist(findTestObject('Object Repository/Permission/Permission Image'), 10)

if (isElementPresent) {
	Mobile.comment('Hình ảnh tồn tại.')
} else {
		KeywordUtil.markFailed('❌ Hình ảnh không tồn tại ')

}

String actualText = Mobile.getText(findTestObject('Object Repository/Permission/Textview Permission'), 10)

if (actualText.trim().equalsIgnoreCase('Permission')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText + "'")
}


String actualText1 = Mobile.getText(findTestObject('Object Repository/Permission/Des Permission'), 10)
if (actualText1.trim().equalsIgnoreCase('The app needs to use Camera permission for fake call feature')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText1 + "'")
}


String actualText2 = Mobile.getText(findTestObject('Object Repository/Permission/Permission Name'), 10)
if (actualText2.trim().equalsIgnoreCase('Camera Permission')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText2 + "'")
}

String actualText3 = Mobile.getText(findTestObject('Object Repository/Permission/CONTINUE'), 10)
if (actualText3.trim().equalsIgnoreCase('CONTINUE')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText3 + "'")
}

//String actualText4 = Mobile.getText(findTestObject('Object Repository/Permission/Grant permission later'), 10)
//if (actualText3.trim().equalsIgnoreCase('Grant permission later')) {
//	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
//} else {
//	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText4 + "'")
//}

// Kiểm tra xem quảng cáo Native có hiển thị không
if (Mobile.waitForElementPresent(findTestObject('Object Repository/Intro/AdsIntro'), 10, FailureHandling.OPTIONAL)) {
	KeywordUtil.logInfo("✅ Quảng cáo Native đã xuất hiện!")

	// Kiểm tra các thành phần của quảng cáo (ví dụ: hình ảnh, tiêu đề, mô tả, nút CTA)
	boolean isAdImageVisible = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/MediaView'), 5, FailureHandling.OPTIONAL)
	boolean isAddesVisible = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/DescriptionAdsIntro'), 5, FailureHandling.OPTIONAL)
	boolean isAdCTAButtonVisible = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/CTA'), 5, FailureHandling.OPTIONAL)
	
	if (isAdImageVisible && isAddesVisible && isAdCTAButtonVisible) {
		KeywordUtil.logInfo("✅ Quảng cáo Native hiển thị đầy đủ!")
	} else if(isAdImageVisible && isAddesVisible && !isAdCTAButtonVisible ){
		
		KeywordUtil.markWarning("⚠️ Quảng cáo Native bị thiếu CTA!")
	} else if(isAdImageVisible && !isAddesVisible && isAdCTAButtonVisible ){
		
		KeywordUtil.markWarning("⚠️ Quảng cáo Native bị thiếu Des!")}
	else if(!isAdImageVisible && isAddesVisible && isAdCTAButtonVisible ){
		
		KeywordUtil.markWarning("⚠️ Quảng cáo Native bị thiếu Media!")}
} else {
	KeywordUtil.markFailed("❌ Quảng cáo Native KHÔNG hiển thị!")
}
