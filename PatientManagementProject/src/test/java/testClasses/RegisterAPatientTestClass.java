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
import pageClassesInProject.RegisterAPatientPageClass;

public class RegisterAPatientTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;

	@Test(priority = 1, groups = { "basicfunctionality" })
	public void verifyPatientRegistration() throws InterruptedException, IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		rp = new RegisterAPatientPageClass(driver);

		lp.login(lp.readStringDataFromExcel(20, 1), lp.readStringDataFromExcel(20, 2));
		hp.registeringAPatient();
		String actualRegsiteredName = rp.registeringPatient(lp.readStringDataFromExcel(20, 3),
				lp.readStringDataFromExcel(21, 3), 1, "25", 6, "1994", lp.readStringDataFromExcel(26, 3),
				lp.readStringDataFromExcel(27, 3), lp.readStringDataFromExcel(28, 3), lp.readStringDataFromExcel(29, 3),
				lp.readStringDataFromExcel(30, 3), "123321", "1234567890");
		AssertJUnit.assertEquals(actualRegsiteredName, lp.readStringDataFromExcel(20, 3));

	}
}
