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

// Bước 2: Tìm kiếm với từ khóa 'k'
TestObject searchBox = findTestObject('SearchBox')  // Tìm đối tượng hộp tìm kiếm
//TestObject searchButton = findTestObject('Object Repository/SearchButton')  // Tìm đối tượng nút tìm kiếm




// Bước 3: Tìm kiếm với từ khóa không hợp lệ
String invalidSearchKeyword = 'NonExistingKeyword'  // Từ khóa không hợp lệ

// Nhập từ khóa không hợp lệ và bấm nút tìm kiếm
Mobile.setText(searchBox, invalidSearchKeyword, 0)  // Nhập từ khóa không hợp lệ vào hộp tìm kiếm
 // Bấm nút tìm kiếm

// Kiểm tra không có kết quả tìm kiếm (hiển thị thông báo không có kết quả)
TestObject noResultsMessage = findTestObject('Object Repository/NoResultsMessage')  // Đảm bảo bạn có đối tượng thông báo không có kết quả trong Object Repository

boolean isNoResultsVisible = Mobile.verifyElementVisible(noResultsMessage, 5)  // Kiểm tra thông báo không có kết quả có hiển thị không
if (isNoResultsVisible) {
	KeywordUtil.logInfo("✅ Tìm kiếm với từ khóa không hợp lệ 'NonExistingKeyword' không có kết quả.")
} else {
	KeywordUtil.logInfo("❌ Tìm kiếm với từ khóa không hợp lệ 'NonExistingKeyword' vẫn có kết quả.")
}
Mobile.closeApplication()
