package org.midterm;

public abstract class BaseGame {
	private Team teamOne;
	private Team teamTwo;

	public BaseGame() {
		this.teamOne = new Team();
		this.teamTwo = new Team();
	}

	public Team getTeamOne() {
		return teamOne;
	}

	public Team getTeamTwo() {
		return teamTwo;
	}

	public void printSocres() {
		System.out.println(teamOne.getName() + " has a score of " + teamOne.getScore());
		System.out.println(teamTwo.getName() + " has a score of " + teamTwo.getScore());
	}

	public abstract void playGame();

	public abstract void updateScore();
}
