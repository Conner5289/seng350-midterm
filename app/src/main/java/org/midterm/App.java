package org.midterm;

public class App {

	public static void main(String[] args) {
		boolean playing = true;
		Menu gameMenu = new Menu();
		dbDriver db = new dbDriver();
		menuReturnCode returnCode;
		do {

			do {
				returnCode = gameMenu.startMenu();
				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}

			} while (returnCode != menuReturnCode.GAME_START && playing);

			do {
				returnCode = gameMenu.duringGameMenu();
				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}

			} while (returnCode != menuReturnCode.GAME_OVER && playing);

			BaseGame currentGame = GameManager.getCurrentGame();
			Team teamOne = currentGame.getTeamOne();
			Team teamTwo = currentGame.getTeamTwo();

			db.addTeamdb(teamOne.getScore(), teamOne.getName());
			db.addTeamdb(teamTwo.getScore(), teamTwo.getName());

			do {
				returnCode = gameMenu.postGameMenu();
				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}

			} while (returnCode != menuReturnCode.GAME_FINISH && playing);

		} while (playing);
	}
}
