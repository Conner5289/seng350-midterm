package org.midterm;

public abstract class BaseGame {
	protected Team teamOne;
	protected Team teamTwo;
	protected int currentPeriod;
	protected int totalPeriod;
	protected boolean isGamePlaying = true;

	public BaseGame(int finalPeriod) {
		this.teamOne = new Team();
		this.teamTwo = new Team();
		this.totalPeriod = finalPeriod;
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

	public menuReturnCode advanceCurrentPeriod() {
		this.currentPeriod++;
		if (currentPeriod > totalPeriod) {
			System.out.println("Game is over");
			return menuReturnCode.GAME_OVER;
		}
		return menuReturnCode.GAME_GOING;
	}

	public abstract void playGame();

	public abstract void updateScore();

	public abstract int makeScore();

}
