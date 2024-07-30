package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;
import utilities.ExcelReadClass;

public class LoginPageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	

	@Test(priority=4)
	public void verifySucessfulLogin() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringDataFromExcel(1, 1), lp.readStringDataFromExcel(1, 2));
		hp = new HomePageClass(driver);
		String actual = hp.getsuperAdminTextValue();
		AssertJUnit.assertEquals(actual, lp.readStringDataFromExcel(1, 3));

	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "unsucessfulLoginData",priority=2)

	public void verifyUnsucessfulLogin(String uname, String pwd) throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(uname, pwd);
		String actualMessage = lp.textOfInvalidCredsMessageBox();
		AssertJUnit.assertTrue(actualMessage.contains(lp.readStringDataFromExcel(3, 3)));

	}

	@Test(priority=3)

	public void verifyCannotLoginOption() throws IOException {
		lp = new LoginPageClass(driver);
		String actualPopUpMessage = lp.cannotLogin();
		AssertJUnit.assertTrue(actualPopUpMessage.contains(lp.readStringDataFromExcel(7, 3)));

	}

	@Test(priority=1)

	public void verifyIfLogoIsDiplayed() {
		lp = new LoginPageClass(driver);
		AssertJUnit.assertTrue(lp.logoDisplayed());

	}

}
