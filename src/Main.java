import java.util.Locale;

import com.github.javafaker.Faker;

public class Main {
	public static void main(String[] args) {
		Faker faker = new Faker(Locale.KOREAN);
		System.out.println(faker.name().fullName());
		System.out.println(faker.address().fullAddress());

		System.out.println(faker.pokemon().name());
	}
}
