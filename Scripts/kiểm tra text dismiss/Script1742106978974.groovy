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


////Mobile.closeApplication()
Mobile.callTestCase(findTestCase('Start app'), null)
for (int x = 0; x <5 ; x++) {
// Kiểm tra xem text "Dismiss" có hiển thị không
if (x<5 && Mobile.verifyElementExist(new TestObject().addProperty("xpath",
	com.kms.katalon.core.testobject.ConditionType.EQUALS, "//android.widget.TextView[@text='Dismiss']"),
	5, FailureHandling.OPTIONAL)) {
	
	// Nếu tồn tại, bấm vào
	Mobile.tap(new TestObject().addProperty("xpath",
		com.kms.katalon.core.testobject.ConditionType.EQUALS, "//android.widget.TextView[@text='Dismiss']"), 5)
	
	println('Clicked on "Dismiss" button')
} else {
	println('"Dismiss" button not found')
}
}
Mobile.tap(findTestObject, x)
// Đóng ứng dụng
Mobile.closeApplication()





