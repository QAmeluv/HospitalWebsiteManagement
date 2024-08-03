package testClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import pageClassesInProject.FindPatientRecordClass;
import pageClassesInProject.HomePageClass;
import pageClassesInProject.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class FindPatientTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	FindPatientRecordClass fp;

	@Test(priority = 1, groups = { "patientEdits" },retryAnalyzer = RetryAnalyzer.class)
	public void verifySearchingPatientRecord() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);

		lp.login(lp.readStringDataFromExcel(13, 1), lp.readStringDataFromExcel(13, 2));
		hp.selectFindPatient();
		fp.searchPatient("100J19");
		String actualPatientid = fp.fetchPatientIdTextValue();
		AssertJUnit.assertEquals(actualPatientid, "100J19");

	}

	@Test(priority = 2, groups = { "patientEdits" },retryAnalyzer = RetryAnalyzer.class)
	public void verifyIfPatientEditisWorking() throws IOException, InterruptedException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);
		lp.login(lp.readStringDataFromExcel(14, 1), lp.readStringDataFromExcel(14, 2));
		hp.selectFindPatient();
		Assert.assertTrue(fp.editPatient("100HYE", "New"));
	}

	@Test(priority = 3, groups = { "patientEdits" },retryAnalyzer = RetryAnalyzer.class)

	public void verifyDeletingPatient() throws InterruptedException, IOException

	{
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		fp = new FindPatientRecordClass(driver);
		lp.login(lp.readStringDataFromExcel(14, 1), lp.readStringDataFromExcel(14, 2));
		hp.selectFindPatient();
		fp.searchPatient("100HXG");
		AssertJUnit.assertTrue(fp.DeletePatient(lp.readStringDataFromExcel(14, 3)));

	}

}
