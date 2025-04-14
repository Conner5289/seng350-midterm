package org.midterm;

import java.util.Random;

public class Basketball extends BaseGame {

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
	public void playGame() {
		super.currentPeriod++;
		updateScore();
	}

	@Override
	public int makeScore() {
		return new Random().nextInt(0, 41);
	}
}
