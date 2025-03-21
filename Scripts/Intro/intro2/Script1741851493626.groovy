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
//Mobile.callTestCase(findTestCase('Language/splash'), null)
Mobile.callTestCase(findTestCase('Start app'), null)
Mobile.callTestCase(findTestCase('adsinter'), null)

int posX = Mobile.getElementLeftPosition(findTestObject("Intro/btnnext"), 0)
int posY = Mobile.getElementTopPosition(findTestObject("Intro/btnnext"), 0)

println("Tọa độ X: " + posX)
println("Tọa độ Y: " + posY)



// Tìm kiếm hình ảnh dựa vào đối tượng trong Object Repository
boolean isElementPresent = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/ImageIntro1'), 10)

if (isElementPresent) {
	Mobile.comment('Hình ảnh tồn tại.')
} else {
		KeywordUtil.markFailed('❌ Hính ảnh không tồn tại ')

}
Mobile.tap(findTestObject("Intro/btnnext"), 0)
Mobile.delay(2)

String actualText = Mobile.getText(findTestObject('Object Repository/Intro/Text Fake Call To'), 10)


if (actualText.trim().equalsIgnoreCase('Fake Call To')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText + "'")
}


String actualText1 = Mobile.getText(findTestObject('Object Repository/Intro/Text Troll Frends'), 10)
if (actualText1.trim().equalsIgnoreCase('Troll Friends')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText1 + "'")
}



// Tìm kiếm hình ảnh dựa vào đối tượng trong Object Repository
boolean isElementPresent1 = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/Indicator1'), 10)
if (isElementPresent1) {
	Mobile.comment('Indicator tồn tại.')
} else {
	KeywordUtil.markFailed('Indicator không tồn tại: ')

}

String actualText2 = Mobile.getText(findTestObject('Object Repository/Intro/Text Start'), 10)

boolean isElementPresent2 = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/Text Start'), 10)

if (isElementPresent2) {
	Mobile.comment('Button next tồn tại.')
} else {
	KeywordUtil.markFailed('button next không tồn tại: ')

}

if (actualText2.trim().equalsIgnoreCase('Start')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText2 + "'")
}

