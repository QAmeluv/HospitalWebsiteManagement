package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	static Faker faker;
	static String fname;

	public static String getfirstName() {
		faker = new Faker(new Locale("en-IND"));
		fname = faker.name().firstName();
		return fname;
	}

	public static String getlastName() {
		faker = new Faker(new Locale("en-IND"));
		fname = faker.name().lastName();
		return fname;
	}

}
