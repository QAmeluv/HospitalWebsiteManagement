package pageClassesInProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='content']//child::h4")
	WebElement superAdminText;

	@FindBy(xpath = "//i[@class='icon-signout small']")
	WebElement logoIcon;

	@FindBy(xpath = "//div[@id='apps']//child::a[4]")
	WebElement registerAPatientTile;

	@FindBy(xpath = "//div[@id='apps']//child::a[1]")
	WebElement findPatientTile;

	@FindBy(xpath = "//div[@id='apps']//child::a[3]")
	WebElement captureVitals;

	@FindBy(xpath = "//div[@id='apps']//child::a[5]")
	WebElement appointmentSchedulingTab;

	public String getsuperAdminTextValue() {
		ex.visibilityOfElementLocatedWait(driver, superAdminText);
		return gl.getTextOfElement(superAdminText);
	}

	public String logout() {
		ex.elementToBeClickableWait(driver, logoIcon);
		gl.clickOnElement(logoIcon);
		return gl.getCurrentUrlOfPage(driver);
	}

	public void registeringAPatient() {
		ex.visibilityOfElementLocatedWait(driver, registerAPatientTile);
		gl.clickOnElement(registerAPatientTile);

	}

	public void selectFindPatient() {
		ex.visibilityOfElementLocatedWait(driver, findPatientTile);
		gl.clickOnElement(findPatientTile);

	}

	public void selectCaptureVitals() {
		ex.visibilityOfElementLocatedWait(driver, captureVitals);
		gl.clickOnElement(captureVitals);

	}

	public void selectAppointmentScheduling() {
		ex.visibilityOfElementLocatedWait(driver, appointmentSchedulingTab);
		gl.clickOnElement(appointmentSchedulingTab);

	}

	public String readStringDataFromExcel(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);

	}

	public String readIntDataFromExcel(int row, int col) throws IOException {
		return ExcelReadClass.readIntegerData(row, col);

	}
}
