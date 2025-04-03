package org.midterm;

public class GameTraker implements ScoreObserver {
	private int teamOneScore;
	private int teamTwoScore;
	private String teamOneName;
	private String teamTwoName;

	@Override
	public void updateScore(int[] scores) {
		teamOneScore = scores[0];
		teamTwoScore = scores[1];

	}

	@Override
	public void updateName(String[] names) {
		teamOneName = names[0];
		teamTwoName = names[1];
	}

}
