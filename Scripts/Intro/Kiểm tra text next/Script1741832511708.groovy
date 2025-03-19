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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.MobileElement
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File
import java.awt.Color
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import org.openqa.selenium.Rectangle
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils
import java.io.File

Mobile.callTestCase(findTestCase('Start app'), null)
Mobile.callTestCase(findTestCase('adsinter'), null)

String actualText = Mobile.getText(findTestObject('Object Repository/Intro/btnnext'), 10)

boolean isElementPresent = Mobile.verifyElementExist(findTestObject('Object Repository/Intro/btnnext'), 10)

if (isElementPresent) {
	Mobile.comment('Button next tồn tại.')
} else {
	KeywordUtil.markFailed('button next không tồn tại: ')


}

if (actualText.trim().equalsIgnoreCase('Next')) {
	KeywordUtil.logInfo("✅ Nội dung hiển thị chính xác!")
} else {
	KeywordUtil.markFailed("❌ Nội dung sai! Giá trị thực tế: '" + actualText + "'")
}


