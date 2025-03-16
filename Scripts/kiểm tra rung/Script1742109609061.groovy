import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import java.io.BufferedReader
import java.io.InputStreamReader

// Khởi động ứng dụng
Mobile.startApplication('C:\\Users\\trant\\Downloads\\FCdemo.apk', false)
Mobile.delay(30)

try {
	// Gửi lệnh kiểm tra trạng thái rung qua ADB
	String command = "adb logcat -b system"

	// Khởi tạo ProcessBuilder để chạy lệnh ADB
	ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command)
	processBuilder.redirectErrorStream(true)
	Process process = processBuilder.start()

	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
	String line
	StringBuilder output = new StringBuilder()

	while ((line = reader.readLine()) != null) {
		output.append(line).append("\n")
	}

	process.waitFor()

	// In ra toàn bộ kết quả để kiểm tra thông tin trả về
	KeywordUtil.logInfo("Kết quả trả về: \n" + output.toString())

	// Kiểm tra kết quả trả về có chứa thông tin về trạng thái rung
	if (output.toString().contains("mVibratorEnabled=true")) {
		KeywordUtil.logInfo("✅ Ứng dụng đang sử dụng chức năng rung.")
	} else {
		KeywordUtil.logInfo("❌ Ứng dụng không sử dụng chức năng rung.")
	}

} catch (Exception e) {
	KeywordUtil.logInfo("⚠️ Lỗi khi kiểm tra trạng thái rung: " + e.getMessage())
}
