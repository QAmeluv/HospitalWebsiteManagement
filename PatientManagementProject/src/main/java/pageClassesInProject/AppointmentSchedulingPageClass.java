package pageClassesInProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class AppointmentSchedulingPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public AppointmentSchedulingPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='apps']//child::div[1]")
	WebElement manageSErviceTypesTab;

	@FindBy(xpath = "//button[@class='confirm appointment-type-label right']")
	WebElement newServiceTab;

	@FindBy(id = "name-field")
	WebElement serviceName;

	@FindBy(id = "duration-field")
	WebElement durationTab;

	@FindBy(id = "save-button")
	WebElement saveButton;

	@FindBy(xpath = "//div[@id='manageAppointmentsTypeTitle']//h1")
	WebElement headingServices;

	@FindBy(xpath = "//tbody[@role='alert']//tr[1]//td[4]//i[1]")
	WebElement editPencil;

	@FindBy(xpath = "//tbody[@role='alert']//tr[1]//td[4]//i[2]")
	WebElement deletePencil;

	@FindBy(xpath = "//div[@id='simplemodal-container']//button[1]")
	WebElement deleteYesBtn;

	@FindBy(xpath = "//div[@class='toast-container toast-position-top-right']")
	WebElement toastContainer;

	public void clickManageServiceTypes() {

		ex.visibilityOfElementLocatedWait(driver, manageSErviceTypesTab);
		gl.clickOnElement(manageSErviceTypesTab);

	}

	public String enteringServiceDetails(String name, String duration) {
		ex.visibilityOfElementLocatedWait(driver, serviceName);
		gl.clearElement(serviceName);
		gl.typeOnElement(serviceName, name);

		ex.visibilityOfElementLocatedWait(driver, durationTab);
		gl.typeOnElement(durationTab, duration);

		ex.elementToBeClickableWait(driver, saveButton);
		gl.clickOnElement(saveButton);

		ex.visibilityOfElementLocatedWait(driver, headingServices);
		return gl.getTextOfElement(headingServices);

	}

	public String addNewServiceType(String name, String duration) {

		gl.clickOnElement(newServiceTab);

		return enteringServiceDetails(name, duration);

	}

	public String editService(String name, String duration) {
		ex.visibilityOfElementLocatedWait(driver, editPencil);
		gl.clickOnElement(editPencil);

		return enteringServiceDetails(name, duration);

	}

	// TODO
	public boolean deleteService() {
		ex.visibilityOfElementLocatedWait(driver, deletePencil);
		gl.clickOnElement(deletePencil);

		ex.visibilityOfElementLocatedWait(driver, deleteYesBtn);
		gl.scrollToAnElement(driver, deleteYesBtn);
		gl.doubleClick(deleteYesBtn, driver);

		ex.visibilityOfElementLocatedWait(driver, toastContainer);
		return gl.isElementDisplayed(toastContainer);

	}
	public String readStringDataFromExcel(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row,col);
		
	}
	
    public String readIntDataFromExcel(int row,int col) throws IOException {
    	return ExcelReadClass.readIntegerData(row,col);
    	
		
	}
}
