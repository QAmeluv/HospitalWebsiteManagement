package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public void takeScreenshot(WebDriver driver, String name) throws IOException {

		String folder_path = "/Users/reshmabibin/Java/Selenium/PatientManagementProject/TestEvidences";

		File file = new File(folder_path);
		if (!file.exists()) {
			file.mkdirs();
		}

		TakesScreenshot take_screenshot = (TakesScreenshot) driver;
		File screenshotFile = take_screenshot.getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());

		String destination_Path = folder_path + name + timeStamp + ".png";

		File fileDestination = new File(destination_Path);

		FileHandler.copy(screenshotFile, fileDestination);

	}

}
