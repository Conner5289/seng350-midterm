package org.midterm;

public class GameManager {
	private static BaseGame currentGame;

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

}
