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

	// method to take screenshot and save it to a folder
	public void takeScreenshot(WebDriver driver, String name) throws IOException {
		// creating a folder in our project to save the screenshots
		String folder_path = "/Users/reshmabibin/Java/Selenium/PatientManagementProject/TestEvidences";
		// file represntation of the folder path/directory
		File file = new File(folder_path);
		if (!file.exists()) {
			file.mkdirs();
		}

		// Taking screenshots as FILE type and storing in a File variable
		TakesScreenshot take_screenshot = (TakesScreenshot) driver;
		File screenshotFile = take_screenshot.getScreenshotAs(OutputType.FILE);

		// To save the SS in a specific filename(using Time-stamp , the name of the
		// failed TEstcase name and the extension)

		String timeStamp = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());

		String destination_Path = folder_path + name + timeStamp + ".png";

		// To copy the SS to the destination folder

		File fileDestination = new File(destination_Path);

		FileHandler.copy(screenshotFile, fileDestination);

	}

}
