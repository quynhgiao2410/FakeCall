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

Mobile.callTestCase(findTestCase('splash'), null)

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
