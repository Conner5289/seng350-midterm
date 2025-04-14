package org.midterm;

import java.util.Random;

public class Basketball extends BaseGame {

	BaseGame currentGame = GameManager.getCurrentGame();

	public Basketball() {
		super(4);
	}

	@Override
	public void updateScore() {
		Team teamOne = super.getTeamOne();
		Team teamTwo = super.getTeamTwo();

		int teamOneOldScore = teamOne.getScore();
		int teamTwoOldScore = teamTwo.getScore();

		teamOne.setScore(teamOneOldScore + makeScore());
		teamTwo.setScore(teamTwoOldScore + makeScore());
	}

	@Override
	public menuReturnCode advanceCurrentPeriod() {
		this.currentPeriod++;
		if (currentPeriod > totalPeriod) {
			System.out.println("Game is over");
			return menuReturnCode.GAME_OVER;
		}
		return menuReturnCode.GAME_GOING;
	}

	@Override
	public int makeScore() {
		return new Random().nextInt(0, 41);
	}

	@Override
	public int getCurrerntPeriod() {
		return this.currentPeriod;
	}

}
