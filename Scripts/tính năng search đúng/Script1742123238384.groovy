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
Mobile.tap(findTestObject('SearchBox'), 0)
String searchKeyword = 'k'  // Từ khóa tìm kiếm

// Nhập từ khóa vào hộp tìm kiếm và bấm nút tìm kiếm
Mobile.setText(searchBox, searchKeyword, 0)  // Nhập từ khóa vào hộp tìm kiếm
//Mobile.tap(searchButton, 0)  // Bấm nút tìm kiếm

// Bước 3: Kiểm tra các phần tử tìm kiếm có chứa 'k' trong content
TestObject searchResults = findTestObject('Object Repository/SearchResults')  // Đảm bảo bạn có đối tượng chứa tất cả kết quả tìm kiếm

// Lấy danh sách các phần tử kết quả tìm kiếm
List<WebElement> results = MobileDriverFactory.getDriver().findElements(By.xpath('//android.widget.TextView'))  // Sử dụng XPath để lấy danh sách kết quả tìm kiếm. Điều chỉnh nếu sử dụng iOS hoặc đối tượng khác

boolean allResultsContainK = true

// Kiểm tra xem mỗi phần tử trong danh sách kết quả có chứa 'k' trong content không
for (WebElement result : results) {
	String resultText = result.getText()
	if (!resultText.toLowerCase().contains(searchKeyword.toLowerCase())) {
		allResultsContainK = false
		break  // Nếu tìm thấy kết quả không chứa 'k', dừng kiểm tra và báo lỗi
	}
}

// Bước 4: Xác nhận kết quả
if (allResultsContainK) {
	KeywordUtil.logInfo("✅ Tất cả các kết quả tìm kiếm đều chứa 'k'.")
} else {
	KeywordUtil.logInfo("❌ Một số kết quả tìm kiếm không chứa 'k'.")
}



// Bước 5: Đóng ứng dụng
Mobile.closeApplication()
