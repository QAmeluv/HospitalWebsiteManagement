package pageClassesInProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class CaptureVitalsPageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public CaptureVitalsPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "patient-search")
	WebElement patientIdSerach;

	@FindBy(xpath = "//table[@id='patient-search-results-table']")
	WebElement firstRowOfTestResult;

	@FindBy(id = "coreapps-vitals-confirm")
	WebElement recordVitalButton;

	@FindBy(id = "w8")
	WebElement heightTab;

	@FindBy(id = "w10")
	WebElement weightTab;

	@FindBy(id = "save-form")
	WebElement saveForm;

	@FindBy(xpath = "//button[@onclick='submitHtmlForm()']")
	WebElement saveVitalsButton;

	@FindBy(xpath = "//div[@class='toast-container toast-position-top-right']")
	WebElement ToastContainer;

	public boolean captureVitalsOfPatient(String patientId, String height, String weight) throws InterruptedException {

		ex.visibilityOfElementLocatedWait(driver, patientIdSerach);
		gl.typeOnElement(patientIdSerach, patientId);
		
        ex.visibilityOfElementLocatedWait(driver, firstRowOfTestResult);
		gl.pressEnterKey(driver);

		ex.elementToBeClickableWait(driver, recordVitalButton);
		gl.clickOnElement(recordVitalButton);

		ex.visibilityOfElementLocatedWait(driver, heightTab);
		gl.typeOnElementAndClickEnter(heightTab, height);

		gl.typeOnElementAndClickEnter(weightTab, weight);

		gl.moveToAnElementAndCick(driver, saveForm);

		ex.elementToBeClickableWait(driver, saveVitalsButton);
		gl.clickOnElement(saveVitalsButton);

		ex.visibilityOfElementLocatedWait(driver, ToastContainer);
		gl.addSleep();

		return gl.isElementDisplayed(ToastContainer);

	}
	public String readStringDataFromExcel(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row,col);
		
	}
	
    public String readIntDataFromExcel(int row,int col) throws IOException {
    	return ExcelReadClass.readIntegerData(row,col);
    	
		
	}

}
