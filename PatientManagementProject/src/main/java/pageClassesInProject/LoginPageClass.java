package pageClassesInProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement usernameTextBox;

	@FindBy(id = "password")
	WebElement passwordTextBox;

	@FindBy(xpath = "//li[@id='Pharmacy']")
	WebElement pharmacyTab;

	@FindBy(id = "loginButton")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id='error-message']")
	WebElement invalidCredsMessageBox;

	@FindBy(id = "cantLogin")
	WebElement caanotLoginText;

	@FindBy(xpath = "//div[@id='cannotLoginPopup']//child::h3")
	WebElement canotLoginDialoguePopup;

	@FindBy(xpath = "//div[@class='logo']//img")
	WebElement logo;

	public void login(String uname, String pwd) {
		gl.typeOnElement(usernameTextBox, uname);
		gl.typeOnElement(passwordTextBox, pwd);
		gl.clickOnElement(pharmacyTab);
		gl.clickOnElement(loginButton);

	}

	public String textOfInvalidCredsMessageBox() {
		ex.visibilityOfElementLocatedWait(driver, invalidCredsMessageBox);
		return gl.getTextOfElement(invalidCredsMessageBox);
	}

	public String cannotLogin() {
		gl.clickOnElement(caanotLoginText);
		ex.visibilityOfElementLocatedWait(driver, canotLoginDialoguePopup);
		return gl.getTextOfElement(canotLoginDialoguePopup);
	}

	public boolean logoDisplayed() {
		ex.visibilityOfElementLocatedWait(driver, logo);
		return gl.isElementDisplayed(logo);

	}
	public String readStringDataFromExcel(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row,col);
		
	}
	
    public String readIntDataFromExcel(int row,int col) throws IOException {
    	return ExcelReadClass.readIntegerData(row,col);
    	
		
	}

}
