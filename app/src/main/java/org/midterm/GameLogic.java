package org.midterm;

import java.util.ArrayList;
import java.util.List;

public class GameLogic implements GameSubject {
	private Team teamOne;
	private Team teamTwo;
	private List<ScoreObserver> observers = new ArrayList<>();

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

	@Override
	public void updateObservers() {
		int teamOneScore = teamOne.getScore();
		int teamTwoScore = teamTwo.getScore();
		int[] scoreArray = { teamOneScore, teamTwoScore };

		String teamOneName = teamOne.getName();
		String teamtwoName = teamTwo.getName();
		String nameArray[] = { teamOneName, teamtwoName };

		for (ScoreObserver observer : observers) {
			observer.updateScore(scoreArray);
			observer.updateName(nameArray);
		}
	}

	@Override
	public void removeObserver(ScoreObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void addObserver(ScoreObserver observer) {
		observers.add(observer);

	}
}
