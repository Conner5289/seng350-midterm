package org.midterm;

import java.util.HashMap;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.t;

public class GameLoop {
	public void gameStart() {
		int quarter = 0;
		int userChoice;

		Boolean isGameGoing = false;
		Boolean valiedChoice;
		Boolean playing = true;
		Boolean inPostGame = true;

		HashMap<Integer, Boolean> options = new HashMap<>();
		GameLogic gameLogic;
		GameHeadliner headliner = new GameHeadliner();
		ScorePredictor predictor = new ScorePredictor();
		GameTraker traker = new GameTraker();
		dbDriver database = new dbDriver();
		database.dbInit();

		// Base locks(false) and unlocks(true)
		options.put(1, true);// Start game
		options.put(2, false);// Sim
		options.put(3, false);// Current score
		options.put(4, false);// Predict final
		options.put(5, false);// Predict Stats
		options.put(6, true);// See all finished games
		options.put(7, false);// Make a headline
		options.put(8, false);// end game
		options.put(9, true);// end game

		do {// main loop
			do {// post game loop
				do {// input loop
					valiedChoice = true;
					Scanner scrn = new Scanner(System.in);

					if (isGameGoing == false && quarter == 0) {
						System.out.println("===== Main Menu =====");
						System.out.println("There is no game");
						System.out.println("1. Start a game");
						System.out.println("6. See All finished games");
						System.out.println("9. Exit");
						System.out.println();
						System.out.print("What would you like to do? :");

					} else if (quarter == 0) {
						System.out.println("===== Main Menu =====");
						System.out.println("The games is about to start");
						System.out.println("2. Sim first quarter");
						System.out.println("3. Currnet score");
						System.out.println("4. Predict final score");
						System.out.println("5. Prediction Stats");
						System.out.println("6. See All finished games");
						System.out.println("9. Exit");
						System.out.println();
						System.out.print("What would you like to do? :");

					} else if (quarter == 4) {
						System.out.println("===== Main Menu =====");
						System.out.println("The games is over what you like to do?");
						System.out.println("3. Final score");
						System.out.println("5. Prediction Stats");
						System.out.println("6. See All finished games");
						System.out.println("7. Make a headline");
						System.out.println("8. End game");
						System.out.println("9. Exit");
						System.out.println();
						System.out.print("What would you like to do? :");

					} else {// During game
						System.out.println("===== Main Menu =====");
						System.out.println("It is the end of the " + quarter);
						System.out.println("2. Sim next quarter");
						System.out.println("3. Currnet score");
						System.out.println("4. Predict final score");
						System.out.println("5. Prediction Stats");
						System.out.println("6. See all finished games");
						System.out.println("9. Exit");
						System.out.println();
						System.out.print("What would you like to do? :");
					}

					userChoice = scrn.nextInt();

					if (userChoice < 1 || userChoice > 9) {
						System.out.println("");
						System.out.println("That was not an option, pick again");
						System.out.println("");
					}

					if (!options.getOrDefault(userChoice, true)) {
						System.out.println(
								"That option is unavaile at this time, you may need to"
										+ " start a game or a game is already under way");
						valiedChoice = false;
					}

				} while (userChoice < 1 || userChoice > 9 || valiedChoice == false);

				gameLogic = GameLogicManager.getInstance();

				switch (userChoice) {
					case 1:// Start a game
						isGameGoing = true;

						gameLogic.addObserver(headliner);
						gameLogic.addObserver(predictor);
						gameLogic.addObserver(traker);

						// Locks
						options.put(1, false);// Start game
						// Unlocks
						options.put(2, true);// Sim
						options.put(3, true);// Current score
						options.put(4, true);// Predict final
						options.put(5, true);// Predict Stats
						options.put(6, true);// See all finished games

						System.out
								.println(gameLogic.getName("teamOne") + " will be playing "
										+ gameLogic.getName("teamTwo"));

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
						// Predication

						predictor.prediction();
						break;

					case 5:
						// Print Prediction stats
						System.out.println("The system as been right 0% of the time");
						// I am just using random number to make a prediction so the odds of this ever
						// been right is very slim

						break;

					case 6:
						// Get all games
						database.getAllTeams();

						break;

					case 7:
						// make headline
						headliner.makeHeadliner();

						break;

					case 8:
						inPostGame = false;

						break;
					case 9:
						// done
						System.out.println("GoodBye");
						System.exit(0);

						break;

					default:
						throw new UnsupportedOperationException("Switch out of bounce");
				}

				if (quarter == 4 && inPostGame) {

					options.put(1, false);// Start game
					options.put(2, false);// Sim
					options.put(3, true);// Current score
					options.put(4, false);// Predict final
					options.put(5, true);// Predict Stats
					options.put(6, true);// See all finished games
					options.put(7, true);// Make a headline
					options.put(8, true);// End game

					System.out.println("Game has Finshed");
					System.out.println("The fianl score for " + gameLogic.getName("teamOne") + " is: "
							+ gameLogic.getScore("teamOne"));
					System.out.println("The final score for " + gameLogic.getName("teamTwo") + " is: "
							+ gameLogic.getScore("teamTwo"));
					System.out.println();

					isGameGoing = false;
				}
				gameLogic.updateObservers();

			} while (inPostGame);

			database.addTeamdb(gameLogic.getScore("teamOne"), gameLogic.getName("teamOne"));
			database.addTeamdb(gameLogic.getScore("teamTwo"), gameLogic.getName("teamTwo"));
			inPostGame = true;
			quarter = 0;

			options.put(1, true);// Start game
			options.put(2, false);// Sim
			options.put(3, false);// Current score
			options.put(4, false);// Predict final
			options.put(5, false);// Predict Stats
			options.put(6, true);// See all finished games
			options.put(7, false);// Make a headline
			options.put(8, false);// end game

			GameLogicManager.removeInstance();
		} while (playing);

		System.exit(0);
	}

}
