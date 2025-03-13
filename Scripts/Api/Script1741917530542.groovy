import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import java.util.HashSet
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import java.util.HashSet
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import java.util.HashSet
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import java.util.HashSet
import com.kms.katalon.core.model.FailureHandling as FailureHandling


// Lấy Test Object cho GridView
TestObject gridItem = findTestObject('Object Repository/CharacterNames')
if (gridItem == null) {
	KeywordUtil.logInfo("⚠️ Không tìm thấy GridView! Kiểm tra lại Object Repository.")
	Mobile.closeApplication()
	return
}

int totalElements = 0
Set<String> uniqueElements = new HashSet<>()

// Lặp để lấy các phần tử của GridView
while (true) {
	// Gọi hàm getElementLeftPosition; kết quả có thể trả về Integer (0) nếu không tìm thấy phần tử nào
	
	def result = Mobile.getElementLeftPosition(gridItem, totalElements)
	// Nếu result là số 0, gán thành danh sách rỗng
	if (result instanceof Integer && result == 0) {
		result = []
	}
	List<WebElement> currentElements = result as List<WebElement>
	
	if (currentElements == null || currentElements.isEmpty()) {
		break
	}
	
	boolean newElementFound = false
	// Duyệt qua từng phần tử và lấy text của nó
	for (WebElement element : currentElements) {
		try {
			String elementText = Mobile.getText(element, 10)  // hoặc element.getText()
			if (elementText == null) {
				elementText = ""
			}
			if (!uniqueElements.contains(elementText)) {
				uniqueElements.add(elementText)
				totalElements++
				newElementFound = true
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Error extracting text from element: " + e.getMessage())
		}
	}
	
	// Nếu không tìm thấy phần tử mới, thoát vòng lặp
	if (!newElementFound) {
		break
	}
	
	// Swipe để tải thêm phần tử (nếu có)
	Mobile.swipe(500, 1500, 500, 500)
}

KeywordUtil.logInfo("✅ Tổng số phần tử trong GridView: " + totalElements)
println("✅ Tổng số phần tử trong GridView: " + totalElements)

// Đóng ứng dụng
Mobile.closeApplication()
