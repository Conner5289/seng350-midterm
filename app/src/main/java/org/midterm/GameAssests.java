package org.midterm;

import java.util.Random;
import com.github.javafaker.Faker;

public class GameAssests {

	public String teamName() {
		Faker faker = new Faker();
		return faker.team().name();
	}

	public int getScore() {
		Random rand = new Random();
		return rand.nextInt(40);
	}
}
