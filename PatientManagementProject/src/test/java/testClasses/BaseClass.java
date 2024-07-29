package testClasses;



import utilities.ScreenShot;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	static Properties property;
	ScreenShot sh;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		property.load(f);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		readProperty();
		driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			sh = new ScreenShot();
			sh.takeScreenshot(driver, result.getName());

		}
	}

}
