package org.midterm;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements GameSubject {
	private static BaseGame currentGame;
	private List<ScoreObserver> observers = new ArrayList<>();

	public static void getGame(BaseGame game) {
		if (currentGame != null) {
			throw new IllegalStateException("A game is already in progress!");
		}
		currentGame = game;
	}

	public static BaseGame getCurrentGame() {
		return currentGame;
	}

	public static void finishGame() {
		currentGame = null;
	}

	public static void startBasketball() {
		BaseGame basketball = new Basketball();
		getGame(basketball);
	}

	@Override
	public void updateObservers() {
		int teamOneScore = currentGame.getTeamOne().getScore();
		int teamTwoScore = currentGame.getTeamTwo().getScore();
		int[] scoreArray = { teamOneScore, teamTwoScore };

		String teamOneName = currentGame.getTeamOne().getName();
		String teamtwoName = currentGame.getTeamTwo().getName();
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
