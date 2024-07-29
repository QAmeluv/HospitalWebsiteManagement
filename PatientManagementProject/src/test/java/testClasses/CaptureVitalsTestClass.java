package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClassesInProject.CaptureVitalsPageClass;
import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;

public class CaptureVitalsTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	CaptureVitalsPageClass cp;

	@Test(priority=1)
	public void verifyPatientVitalsAreCaptured() throws InterruptedException, IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		cp = new CaptureVitalsPageClass(driver);

		lp.login(lp.readStringDataFromExcel(17, 1), lp.readStringDataFromExcel(17, 2));
		hp.selectCaptureVitals();

		//Assert.assertTrue(cp.captureVitalsOfPatient(lp.readStringDataFromExcel(17, 4), lp.readStringDataFromExcel(17, 5), lp.readStringDataFromExcel(17, 6)));
		Assert.assertTrue(cp.captureVitalsOfPatient("100HPW", "100", "100"));

	}

}
