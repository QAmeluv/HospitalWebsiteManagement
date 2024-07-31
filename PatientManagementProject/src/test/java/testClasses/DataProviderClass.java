package testClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadClass;

public class DataProviderClass {

	@DataProvider(name = "unsucessfulLoginData")
	public Object[][] dp() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadClass.readStringData(3, 1), ExcelReadClass.readStringData(3, 2) },
				new Object[] { ExcelReadClass.readStringData(4, 1), ExcelReadClass.readStringData(4, 2) },
				new Object[] { ExcelReadClass.readStringData(5, 1), ExcelReadClass.readStringData(5, 2) }, };
	}
}
