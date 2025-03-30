package org.midterm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.github.javafaker.Faker;

public class Game {

	public void gameLoop() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Random rand = new Random();
		Faker faker = new Faker();

		String teamOne = faker.team().name();
		String teamTwo = faker.team().name();

		System.out.println(teamOne);
		System.out.println(teamTwo);

		map.put(teamOne, rand.nextInt(31));
		map.put(teamTwo, rand.nextInt(31));

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Team: " + entry.getKey() + " " + "Score: " + entry.getValue());

		}

	}

}
