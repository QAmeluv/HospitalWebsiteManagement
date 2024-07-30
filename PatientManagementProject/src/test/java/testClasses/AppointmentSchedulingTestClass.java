package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClassesInProject.AppointmentSchedulingPageClass;
import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;

public class AppointmentSchedulingTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	AppointmentSchedulingPageClass as;

	@Test(priority=1)
	public void verifyAddingNewService() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		as = new AppointmentSchedulingPageClass(driver);

		lp.login(lp.readStringDataFromExcel(36, 1),lp.readStringDataFromExcel(36, 2));
		hp.selectAppointmentScheduling();
		as.clickManageServiceTypes();

		String serviceHeading = as.addNewServiceType(lp.readStringDataFromExcel(36, 3), "60");
		AssertJUnit.assertTrue(serviceHeading.contains(lp.readStringDataFromExcel(36, 4)));

	}

	@Test(priority=2)

	public void verifyEditService() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		as = new AppointmentSchedulingPageClass(driver);

		lp.login(lp.readStringDataFromExcel(38, 1),lp.readStringDataFromExcel(38, 2));
		hp.selectAppointmentScheduling();
		as.clickManageServiceTypes();
		String serviceHeadingTest = as.editService(lp.readStringDataFromExcel(38, 3), "60");
		AssertJUnit.assertTrue(serviceHeadingTest.contains(lp.readStringDataFromExcel(38, 4)));

	}

	@Test(priority=3)
	public void deleteService() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		as = new AppointmentSchedulingPageClass(driver);

		lp.login(lp.readStringDataFromExcel(38, 1),lp.readStringDataFromExcel(38, 2));
		hp.selectAppointmentScheduling();
		as.clickManageServiceTypes();
		AssertJUnit.assertTrue(as.deleteService());

	}
}
