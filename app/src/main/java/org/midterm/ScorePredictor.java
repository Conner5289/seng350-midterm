package org.midterm;

public class ScorePredictor implements ScoreObserver {
	private int teamOneScore;
	private int teamTwoScore;
	private String teamOneName;
	private String teamTwoName;
	private int teamOneOldPrediction = 0;
	private int teamTwoOldPrediction = 0;

	@Override
	public void updateScore(int[] score) {
		teamOneScore = score[0];
		teamTwoScore = score[1];
	}

	@Override
	public void updateName(String[] names) {
		teamOneName = names[0];
		teamTwoName = names[1];
	}

	public void prediction() {

		BaseGame currentGame = GameManager.getCurrentGame();

		int teamOnePrediction = currentGame.getTeamOne().getScore();
		int teamTwoPrediction = GameAssests.getScore() + teamTwoScore;

		System.out.println("The system predices that");
		System.out.println(teamOneName + " will have " + teamOnePrediction);
		System.out.println(teamTwoName + " will have " + teamTwoPrediction);

		teamOneOldPrediction = teamOnePrediction;
		teamTwoOldPrediction = teamTwoPrediction;
	}
}
