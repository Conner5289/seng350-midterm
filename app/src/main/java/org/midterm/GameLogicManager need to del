package org.midterm;

public class GameLogicManager {
	private static GameLogic gameLogicInstance;

	private GameLogicManager() {
	}

	public static GameLogic getInstance() {
		if (gameLogicInstance == null) {

			gameLogicInstance = new GameLogic();
		}
		return gameLogicInstance;
	}

	public static void removeInstance() {
		gameLogicInstance = null;

	}
}
