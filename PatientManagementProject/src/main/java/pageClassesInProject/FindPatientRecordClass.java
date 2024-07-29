package pageClassesInProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class FindPatientRecordClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public FindPatientRecordClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "patient-search")
	WebElement patientSearchBox;

	@FindBy(xpath = "//div[contains(@class,'identifiers')]//child::span")
	WebElement foundPatientId;

	@FindBy(xpath = "//div[@class='action-section']//child::li[2]")
	WebElement visitNoteTab;

	@FindBy(xpath = "//div[@class='action-section']//child::li[6]")
	WebElement addPastVisitTab;

//	@FindBy(xpath = "//div[@class='action-section']//ul//child::li[7]")
//	WebElement deletePatient;
	
	
	@FindBy(xpath = "//a[contains(@id,'coreapps.deletePatient')]")
	WebElement deletePatient;

	@FindBy(id = "delete-reason")
	WebElement deleteReason;

	@FindBy(xpath = "//input[@id='delete-reason']//following-sibling::button[1]")
	WebElement deleteConfirmBtn;

	@FindBy(xpath = "//div[@class='toast-container toast-position-top-right']")
	WebElement ToastContainer;

	public void searchPatient(String patientId) {
		ex.visibilityOfElementLocatedWait(driver, patientSearchBox);
		gl.typeOnElementAndClickEnter(patientSearchBox, patientId);
	}

	public String fetchPatientIdTextValue() {
		ex.visibilityOfElementLocatedWait(driver, foundPatientId);
		return gl.getTextOfElement(foundPatientId);
	}

	public boolean DeletePatient(String deletionReason) throws InterruptedException {
		ex.visibilityOfElementLocatedWait(driver, deletePatient);
		gl.clickOnElement(deletePatient);

		ex.visibilityOfElementLocatedWait(driver, deleteReason);
		gl.typeOnElementAndClickEnter(deleteReason, deletionReason);

		ex.elementToBeClickableWait(driver, deleteConfirmBtn);
		gl.clickOnElement(deleteConfirmBtn);

		ex.visibilityOfElementLocatedWait(driver, ToastContainer);
		return gl.isElementDisplayed(ToastContainer);

	}
	public String readStringDataFromExcel(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row,col);
		
	}
	
    public String readIntDataFromExcel(int row,int col) throws IOException {
    	return ExcelReadClass.readIntegerData(row,col);
    	
		
	}

}
