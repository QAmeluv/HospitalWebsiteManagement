package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;

public class HomePageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority=1)
	public void verifyLogoOutIsSucessful() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);

		lp.login(lp.readStringDataFromExcel(10, 1), lp.readStringDataFromExcel(10, 2));
		String actualUrl = hp.logout();
		Assert.assertEquals(actualUrl, lp.readStringDataFromExcel(10, 3));

	}

}