package org.midterm;

public class GameLogic {
	private int quarter;
	private Team teamOne;
	private Team teamTwo;

	GameAssests assests = new GameAssests();

	public GameLogic() {
		teamOne = new Team(assests.makeName());
		teamTwo = new Team(assests.makeName());
	}

	public void setScore(String team) {
		if (team.equals("teamOne")) {
			int oldScore = teamOne.getScore();
			int newScore = oldScore + assests.getScore();
			teamOne.setScore(newScore);

		} else if (team.equals("teamTwo")) {

			int oldScore = teamTwo.getScore();
			int newScore = oldScore + assests.getScore();
			teamTwo.setScore(newScore);

		} else {
			throw new IllegalArgumentException("Invalid team name, setScore");
		}
	}

	public int getScore(String team) {
		int score;
		if (team.equals("teamOne")) {
			score = teamOne.getScore();

		} else if (team.equals("teamTwo")) {
			score = teamTwo.getScore();

		} else {
			throw new IllegalArgumentException("Invalid team name, getScore");
		}
		return score;
	}

	public String getName(String team) {
		String name;
		if (team.equals("teamOne")) {
			name = teamOne.getName();

		} else if (team.equals("teamTwo")) {
			name = teamTwo.getName();

		} else {
			throw new IllegalArgumentException("Invalid team name, getScore");
		}
		return name;
	}
}
