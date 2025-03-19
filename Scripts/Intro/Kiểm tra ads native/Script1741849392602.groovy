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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
//
//
Mobile.callTestCase(findTestCase('Start app'), null)
Mobile.callTestCase(findTestCase('adsinter'), null)


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

// Đóng ứng dụng sau khi kiểm tra


