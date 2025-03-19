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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ObjectRepository
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

Mobile.callTestCase(findTestCase('Start app'), null)
Mobile.callTestCase(findTestCase('adsinter'), null)

Mobile.tap(findTestObject('BtnMore'), 0)
Mobile.callTestCase(findTestCase('adsinter'), null)
Mobile.tap(findTestObject('BtnSearch'), 0)

String emptySearchKeyword = ''  // Từ khóa trống
TestObject searchBox = findTestObject('SearchBox')  // Tìm đối tượng hộp tìm kiếm
//TestObject searchButton = findTestObject('Object Repository/SearchButton')  // Tìm đối tượng nút tìm kiếm

// Xóa từ khóa hiện tại trong hộp tìm kiếm và bấm nút tìm kiếm
Mobile.setText(searchBox, emptySearchKeyword, 0)  // Nhập từ khóa trống vào hộp tìm kiếm

// Kiểm tra xem có hiển thị tất cả kết quả không
TestObject allResults = findTestObject('Object Repository/AllResults')  // Đảm bảo bạn có đối tượng hiển thị tất cả kết quả trong Object Repository
boolean isAllResultsPresent = Mobile.waitForElementPresent(allResults, 30, FailureHandling.OPTIONAL)

// Kiểm tra nếu không tìm thấy AllResults và hiển thị thông báo
if (!isAllResultsPresent) {
//	KeywordUtil.logInfo("❌ Không hiển thị tất cả kết quả.")
	KeywordUtil.markWarning("❌ Không hiển thị tất cả kết quả.")
} else {
boolean areAllResultsVisible = Mobile.verifyElementVisible(allResults, 5)  // Kiểm tra xem tất cả kết quả có hiển thị không
if (areAllResultsVisible) {
	KeywordUtil.logInfo("✅ Tìm kiếm với từ khóa trống hiển thị tất cả kết quả.")
} else {
	KeywordUtil.logInfo("❌ Tìm kiếm với từ khóa trống không hiển thị tất cả kết quả.")
}}