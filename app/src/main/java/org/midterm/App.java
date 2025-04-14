package org.midterm;

public class App {

	public static void main(String[] args) {
		boolean playing = true;
		Menu gameMenu = new Menu();
		menuReturnCode returnCode;
		do {

			do {
				returnCode = gameMenu.startMenu();

				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}
			} while (returnCode != menuReturnCode.GAME_START && playing);

			do {
				System.out.println(returnCode);
				returnCode = gameMenu.duringGameMenu();
				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}

			} while (returnCode != menuReturnCode.GAME_OVER && playing);

			do {
				System.out.println("THIS IS ");
				returnCode = gameMenu.postGameMenu();
				if (returnCode == menuReturnCode.GAME_EXIT) {
					playing = false;
				}

			} while (returnCode != menuReturnCode.GAME_FINISH && playing);

		} while (playing);
	}
}
