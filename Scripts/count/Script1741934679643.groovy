import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
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

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.MobileElement
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import java.time.Duration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Dimension
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration
import io.appium.java_client.TouchAction
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration
import io.appium.java_client.TouchAction
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.Dimension
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import java.time.Duration
import io.appium.java_client.TouchAction
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.Dimension
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import org.openqa.selenium.interactions.PointerInput.MouseButton
import java.time.Duration
import java.util.Arrays

// Start the app
Mobile.startApplication('C:\\Users\\Hi\\Downloads\\FCdemo.apk', false)
Mobile.delay(5)

// Check for an ad and close it
if (Mobile.verifyElementExist(findTestObject('Object Repository/Test_Ad'), 5, FailureHandling.OPTIONAL)) {
	println("Ad detected! Closing it...")
	Mobile.tap(findTestObject('Object Repository/Close_Ads_Button'), 5)
	println("Ad closed successfully!")
} else {
	println("No ad detected.")
}

Mobile.tap(findTestObject('BtnMore'), 0)

AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()
if (driver == null) {
	KeywordUtil.logInfo("❌ Could not get Appium Driver. Check Appium connection.")
	Mobile.closeApplication()
	return
}

Dimension screenSize = driver.manage().window().getSize()
int screenHeight = screenSize.height
int screenWidth = screenSize.width

// Find parent element (RecyclerView)
MobileElement parentElement = driver.findElementById("com.asianmobile.fakecall:id/rvFakeCall")

// Store child elements
List<MobileElement> allChildElements = []

boolean isScrollable = true
while (isScrollable) {
	parentElement = driver.findElementById("com.asianmobile.fakecall:id/rvFakeCall")
	List<MobileElement> childElements = parentElement.findElementsByClassName("android.view.ViewGroup") // Use actual child class
	allChildElements.addAll(childElements)

	if (childElements.size() == 0) {
		isScrollable = false // Stop if no more child elements
	} else {
		// Perform scroll action using PointerInput
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger")
		Sequence sequence = new Sequence(finger, 1);

		int startX = screenWidth / 2;
	
		int startY = (int) (screenHeight * 0.4); // 40% từ trên xuống
		int endY = (int) (screenHeight * 0.2);   // 20% từ trên xuống  // Cast to int

		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		sequence.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
		sequence.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));

		((AppiumDriver) driver).perform(Arrays.asList(sequence));

		Mobile.delay(1)
	}
}

println("Total child elements in rvFakeCall: " + allChildElements.size())

// Close the app
Mobile.closeApplication()




//AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()
//if (driver == null) {
//	KeywordUtil.logInfo("❌ Không thể lấy Appium Driver. Kiểm tra lại kết nối Appium.")
//	Mobile.closeApplication()
//	return
//}
////
//
//// Tìm phần tử cha (RecyclerView hoặc ListView) theo ID
//MobileElement parentElement = driver.findElementById("com.asianmobile.fakecall:id/rvFakeCall")
//
//// Tìm các phần tử con bên trong phần tử cha
//List<MobileElement> childElements = parentElement.findElementsByClassName("android.widget.TextView")  // Thay "android.widget.TextView" bằng lớp của phần tử con thực tế
//
//// Đếm số lượng phần tử con
//int totalChildElements = childElements.size()
//
//// In số phần tử con
//println("✅ Tổng số phần tử con trong rvFakeCall: " + totalChildElements)
//
//// Đóng ứng dụng
//Mobile.closeApplication()
