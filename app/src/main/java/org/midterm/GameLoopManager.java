package org.midterm;

public class GameLoopManager {
	private static GameLoop gameLoopInstance;

	private GameLoopManager() {
	}

	public static GameLoop getInstance() {
		if (gameLoopInstance == null) {

			gameLoopInstance = new GameLoop();
		}
		return gameLoopInstance;
	}

	public static void removeInstance() {
		gameLoopInstance = null;

	}
}
