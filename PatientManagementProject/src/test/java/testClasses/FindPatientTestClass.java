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

import pageClassesInProject.FindPatientRecordClass;
import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;

public class FindPatientTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	FindPatientRecordClass fp;

	@Test(priority = 1, groups = { "patientEdits" })
	public void verifySearchingPatientRecord() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);

		lp.login(lp.readStringDataFromExcel(13, 1), lp.readStringDataFromExcel(13, 2));
		hp.selectFindPatient();

//		fp.searchPatient(lp.readStringDataFromExcel(13, 4));
		fp.searchPatient("100KG9");
		String actualPatientid = fp.fetchPatientIdTextValue();
		// Assert.assertSame(actualPatientid, lp.readStringDataFromExcel(13, 4));
		AssertJUnit.assertEquals(actualPatientid, "100KG9");

	}

	@Test(priority = 2, groups = { "patientEdits" })
	public void verifyIfPatientEditisWorking() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);
		lp.login(lp.readStringDataFromExcel(14, 1), lp.readStringDataFromExcel(14, 2));
		hp.selectFindPatient();
		Assert.assertTrue(fp.editPatient("100HM1", "Dicoz"));
	}

	@Test(priority = 3, groups = { "patientEdits" })

	public void verifyDeletingPatient() throws InterruptedException, IOException

	{
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);
		lp.login(lp.readStringDataFromExcel(14, 1), lp.readStringDataFromExcel(14, 2));
		hp.selectFindPatient();
		// fp.searchPatient(lp.readStringDataFromExcel(14, 4));
		fp.searchPatient("100KG9");
		AssertJUnit.assertTrue(fp.DeletePatient(lp.readStringDataFromExcel(14, 3)));

	}

}
