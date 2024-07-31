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

public class HomePageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 1, groups = { "basicfunctionality" })
	public void verifyLogoOutIsSucessful() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);

		lp.login(lp.readStringDataFromExcel(10, 1), lp.readStringDataFromExcel(10, 2));
		String actualUrl = hp.logout();
		AssertJUnit.assertEquals(actualUrl, lp.readStringDataFromExcel(10, 3));

	}

}
