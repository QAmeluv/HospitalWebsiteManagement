package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {

	public WebDriverWait wait;

	public void presenceOfElementXpathLocatedWait(WebDriver driver, String xpathValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}

	public void presenceOfElementIDLocatedWait(WebDriver driver, String id) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public void visibilityOfElementLocatedWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void alertIsPresentWait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void elementToBeClickableWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void elementToBeSelectedWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}

}
