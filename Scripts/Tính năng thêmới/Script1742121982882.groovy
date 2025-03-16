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
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
Mobile.startApplication('C:\\Users\\trant\\Downloads\\FCdemo.apk', false)
// 1. Nhập văn bản vào trường tìm kiếm
String CreateNew = "ABC" // Văn bản bạn muốn tìm kiếm
TestObject CharacterName = findTestObject("Object Repository/CharaterNameBox") // Đảm bảo bạn đã tạo Object Repository cho SearchBox
// Nhập văn bản vào trường tìm kiếm
Mobile.setText(CreateNew, CharacterName, 10)
Mobile.verifyElementText(findTestObject, CreateNew)

// Kiểm tra nếu không tìm thấy AllResults và hiển thị thông báo
if (!CreateNew) {
//	KeywordUtil.logInfo("❌ Không hiển thị tất cả kết quả.")
	KeywordUtil.markWarning("❌ Tạo mới không thành công")
} else {
	KeywordUtil.logInfo("Tạo mới thành công.")
}


//// 2. Kiểm tra xem có TextView hoặc phần tử nào chứa văn bản 'ABC' trên màn hình không
//boolean isTextFound = false
//try {
//	// Chờ phần tử chứa text "ABC" xuất hiện trên màn hình
//	WebDriverWait wait = new WebDriverWait(MobileDriverFactory.getDriver(), 10)
//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, '" + CreateNew + "')]")))
//
//	// Kiểm tra nếu phần tử này có chứa text "ABC"
//	if (element != null && element.getText().contains(CreateNew)) {
//		isTextFound = true
//		KeywordUtil.logInfo("✅ Text '" + CreateNew + "' đã được tìm thấy trên màn hình.")
//	} else {
//		KeywordUtil.logInfo("❌ Không tìm thấy text '" + CreateNew + "' trên màn hình.")
//	}
//} catch (Exception e) {
//	// Nếu không tìm thấy text hoặc gặp lỗi
//	KeywordUtil.markWarning("⚠️ Không tìm thấy text '" + CreateNew + "' trên màn hình.")
//}
//
//// Kết luận
//if (isTextFound) {
//	KeywordUtil.logInfo("✅ Kiểm tra thành công: Text '" + CreateNew + "' đã được tìm thấy.")
//} else {
//	KeywordUtil.logInfo("❌ Kiểm tra thất bại: Không tìm thấy text '" + CreateNew + "' trên màn hình.")
//}
