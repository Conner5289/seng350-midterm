package org.midterm;

import java.util.HashMap;
import java.util.Scanner;

public class GameLoop {
	public void gameStart() {
		int quarter = 0;
		int userChoice;
		Boolean isGame = false;
		Boolean valiedChoice;
		Boolean playing = true;
		HashMap<Integer, Boolean> options = new HashMap<>();
		GameLogic gameLogic;

		// Base locks(false) and unlocks(true)
		options.put(1, true);// Start game
		options.put(2, false);// Sim
		options.put(3, false);// Current score
		options.put(4, false);// Predict final
		options.put(5, true);// Predict Stats
		options.put(6, true);// See all finished games
		options.put(7, false);// Make a headline

		do {

			do {
				valiedChoice = true;
				Scanner scrn = new Scanner(System.in);

				System.out.println("===== Main Menu =====");
				if (isGame == false) {
					System.out.println("There is no game");

				} else if (quarter == 0) {
					System.out.println("The games is about to start");

				} else {
					System.out.println("The quarter is " + quarter);
				}

				System.out.println("1. Start a new game");
				System.out.println("2. Sim a Quarter");
				System.out.println("3. Currnet score");
				System.out.println("4. Predict final score");
				System.out.println("5. Prediction Stats");
				System.out.println("6. See All finished games");
				System.out.println("7. Make a headline");
				System.out.println("8. Exit");
				System.out.println();
				System.out.print("What would you like to do? :");

				userChoice = scrn.nextInt();

				if (userChoice < 1 || userChoice > 8) {
					System.out.println("");
					System.out.println("That was not an option, pick again");
					System.out.println("");
				}

				if (!options.getOrDefault(userChoice, true)) {
					System.out.println(
							"That option is unavaile at this time, you may need to start a game or a game is already under way");
					valiedChoice = false;
				}

			} while (userChoice < 1 || userChoice > 8 || valiedChoice == false);

			gameLogic = GameLogicManager.getInstance();

			switch (userChoice) {
				case 1:
					// Start a game
					isGame = true;

					// Locks
					options.put(1, false);
					// Unlocks
					options.put(2, true);// Sim
					options.put(3, true);// Current score
					options.put(4, true);// Predict final

					System.out
							.println(gameLogic.getName("teamOne") + " will be playing " + gameLogic.getName("teamTwo"));

					break;
				case 2:
					// Sim a quarter

					gameLogic.setScore("teamOne");

					gameLogic.setScore("teamTwo");

					quarter++;

					break;

				case 3:
					// Print Score
					if (quarter == 0) {
						System.out.println("Current scores for start of the game");

					} else if (quarter > 0) {
						System.out.println("Current scores after quarter " + quarter);

					}

					System.out.println("The Score for " + gameLogic.getName("teamOne") + " is: "
							+ gameLogic.getScore("teamOne"));
					System.out.println("The Score for " + gameLogic.getName("teamTwo") + " is: "
							+ gameLogic.getScore("teamTwo"));
					System.out.println();

					break;

				case 4:
					// TODO: Print Predication

					break;

				case 5:
					// TODO: Print Predication stats

					break;

				case 6:
					// TODO: All games

					break;

				case 7:
					// TODO: Make title think that it might not need a option but just does it on it
					// own

					break;

				case 8:
					System.out.println("GoodBye");
					playing = false;
					break;

				default:
					throw new UnsupportedOperationException("Switch out of bounce");
			}

			if (quarter == 4) {
				quarter = 0;
				isGame = false;
				System.out.println("Game has Finshed");
				System.out.println("The fianl score for " + gameLogic.getName("teamOne") + " is: "
						+ gameLogic.getScore("teamOne"));
				System.out.println("The final score for " + gameLogic.getName("teamTwo") + " is: "
						+ gameLogic.getScore("teamTwo"));
				System.out.println();

				GameLogicManager.removeInstance();
			}

		} while (playing);

		System.exit(0);
	}

}
