package pageClassesInProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class RegisterAPatientPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ex = new ExplicitWaitClass();

	public RegisterAPatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "givenName")
	WebElement givenNameTextBox;

	@FindBy(name = "familyName")
	WebElement familyNameTextBox;

	@FindBy(id = "gender-field")
	WebElement genderPatient;

	@FindBy(id = "birthdateDay-field")
	WebElement dayOfBirthdayField;

	@FindBy(id = "birthdateMonth-field")
	WebElement monthOfBirthdayField;

	@FindBy(id = "birthdateYear-field")
	WebElement yearOfBirthdayField;

	@FindBy(id = "address1")
	WebElement addressField1;

	@FindBy(id = "address2")
	WebElement addressField12;

	@FindBy(id = "cityVillage")
	WebElement cityVillageField;

	@FindBy(id = "stateProvince")
	WebElement stateProvinceField;

	@FindBy(id = "country")
	WebElement countryField;

	@FindBy(id = "postalCode")
	WebElement postalCodeField;

	@FindBy(name = "phoneNumber")
	WebElement phoneNumberField;

	@FindBy(id = "submit")
	WebElement confirmButton;

	@FindBy(xpath = "//span[@class='PersonName-givenName']")
	WebElement registeredGivenName;

	@FindBy(name = "middleName")
	WebElement middleTextBox;

	@FindBy(xpath = "//input[@placeholder='Person Name']")
	WebElement personNameTextBox;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(xpath = "//span[@id='confirmation_label']")
	WebElement confirmTab;

	public String registeringPatient(String gname, String fname, int index, String day, int month, String year,
			String address1, String address2, String city, String state, String country, String postalCode,
			String phnum) throws InterruptedException {
		gl.typeOnElement(givenNameTextBox, gname);
		gl.typeOnElement(familyNameTextBox, fname);
		gl.clickOnElement(nextButton);

		gl.selectFromDropDownByIndex(genderPatient, index);
		gl.clickOnElement(nextButton);

		gl.typeOnElement(dayOfBirthdayField, day);
		gl.selectFromDropDownByIndex(monthOfBirthdayField, month);
		gl.typeOnElement(yearOfBirthdayField, year);
		gl.clickOnElement(nextButton);

		gl.typeOnElement(addressField1, address1);
		gl.typeOnElement(addressField12, address2);
		gl.typeOnElement(cityVillageField, city);
		gl.typeOnElement(stateProvinceField, state);
		gl.typeOnElement(countryField, country);
		gl.typeOnElement(postalCodeField, postalCode);
		gl.clickOnElement(nextButton);

		gl.typeOnElement(phoneNumberField, phnum);
		gl.clickOnElement(confirmTab);

		gl.clickOnElement(confirmButton);
		ex.visibilityOfElementLocatedWait(driver, registeredGivenName);

		return gl.getTextOfElement(registeredGivenName);

	}

	public String readStringDataFromExcel(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);

	}

	public String readIntDataFromExcel(int row, int col) throws IOException {
		return ExcelReadClass.readIntegerData(row, col);

	}

}
