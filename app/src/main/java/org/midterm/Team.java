package org.midterm;

import com.github.javafaker.Faker;

public class Team {
	private String name;
	private int score;
	private Faker faker = new Faker();

	public Team() {
		this.name = faker.team().name();
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addPoints(int points) {
		this.score = +points;
	}

}
