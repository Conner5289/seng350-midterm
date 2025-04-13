package org.midterm;

import java.util.Random;

public class GameAssests {

	public String makeName() {
		Faker faker = new Faker();
		return faker.team().name();
	}

	public static int getScore() {
		Random rand = new Random();
		return rand.nextInt(40);
	}
}
