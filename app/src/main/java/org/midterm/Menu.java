package org.midterm;

import java.util.Scanner;

public class Menu {
	private Scanner scrn = new Scanner(System.in);

	public menuReturnCode startMenu() {
		int userChoice;
		boolean isChoiceValid = true;
		do {
			isChoiceValid = true;

			System.out.println("===== Main Menu =====");
			System.out.println("There is no game");
			System.out.println("1. Start a game");
			System.out.println("2. See All finished games");
			System.out.println("3. Exit");
			System.out.println();
			System.out.print("What would you like to do? :");
			userChoice = scrn.nextInt();

			if (userChoice < 1 || userChoice > 3) {
				System.out.println("That is not a vaild choice, pick again");
				isChoiceValid = false;
			} else {

				switch (userChoice) {
					case 1:
						GameManager.startBasketball();
						return menuReturnCode.GAME_START;
					case 2:
						getAllPastGames();
						return menuReturnCode.GET_PAST_GAMES;
					case 3:
						return menuReturnCode.GAME_EXIT;
					default:
						throw new IllegalStateException("Start menu bad case");
				}
			}
		} while (isChoiceValid == false);
		return menuReturnCode.MENU_FINISH;
	}

	public menuReturnCode duringGameMenu() {
		int userChoice;
		boolean isChoiceValid = true;
		do {
			isChoiceValid = true;

			System.out.println("===== Main Menu =====");
			System.out.println("It is the end of the quarter");
			System.out.println("1. Sim next quarter");
			System.out.println("2. Currnet score");
			System.out.println("3. Predict final score");
			System.out.println("4. Prediction Stats");
			System.out.println("5. See all finished games");
			System.out.println("6. Exit");
			System.out.println();
			System.out.print("What would you like to do? :");
			userChoice = scrn.nextInt();

			if (userChoice < 1 || userChoice > 6) {
				System.out.println("That is not a vaild choice, pick again");
				isChoiceValid = false;
			} else {

				BaseGame currentGame = GameManager.getCurrentGame();
				ScorePredictor predictor = new ScorePredictor();

				switch (userChoice) {
					case 1:
						currentGame.advanceCurrentPeriod();
						return menuReturnCode.GAME_ADVANCE;
					case 2:
						currentGame.printSocres();
						return menuReturnCode.PRINTED_SCORES;
					case 3:
						predictor.prediction();

						return menuReturnCode.PREDICT_FINAL_SCORES;
					case 4:
						// Print Prediction stats
						System.out.println("The system as been right 0% of the time");
						// I am just using random number to make a prediction so the odds of this ever
						// been right is very slim

						return menuReturnCode.PREDICTION_STATS;
					case 5:
						getAllPastGames();

						return menuReturnCode.GET_PAST_GAMES;
					case 6:
						gameExit();
						return menuReturnCode.GAME_EXIT;
					default:
						throw new IllegalStateException("pre menu bad case");
				}
			}
		} while (isChoiceValid == false);
		return menuReturnCode.MENU_FINISH;
	}

	public menuReturnCode postGameMenu() {
		int userChoice;
		boolean isChoiceValid = true;
		do {
			isChoiceValid = true;

			System.out.println("===== Main Menu =====");
			System.out.println("The games is over what you like to do?");
			System.out.println("1. Final score");
			System.out.println("2. Prediction Stats");
			System.out.println("3. See All finished games");
			System.out.println("4. Make a headline");
			System.out.println("5. End game");
			System.out.println("6. Exit");
			System.out.println();
			System.out.print("What would you like to do? :");
			userChoice = scrn.nextInt();

			if (userChoice < 1 || userChoice > 6) {
				System.out.println("That is not a vaild choice, pick again");
				isChoiceValid = false;
			} else {

				BaseGame currentGame = GameManager.getCurrentGame();
				GameHeadliner headliner = new GameHeadliner();
				switch (userChoice) {
					case 1:
						currentGame.printSocres();
						return menuReturnCode.PRINTED_SCORES;
					case 2:
						// Print Prediction stats
						System.out.println("The system as been right 0% of the time");
						// I am just using random number to make a prediction so the odds of this ever
						// been right is very slim
						return menuReturnCode.PREDICT_FINAL_SCORES;
					case 3:
						getAllPastGames();

						return menuReturnCode.GET_PAST_GAMES;
					case 4:
						headliner.makeHeadliner();

						return menuReturnCode.GET_HEADLINE;
					case 5: // Hope this works
						GameManager.finishGame();

						return menuReturnCode.GAME_FINISH;
					case 6:
						gameExit();

						break;
					default:
						throw new IllegalStateException("post menu bad case");
				}
			}
		} while (isChoiceValid == false);
		return menuReturnCode.MENU_FINISH;
	}

	public void getAllPastGames() {
		dbDriver db = new dbDriver();
		db.getAllTeams();
	}

	public void gameExit() {
		System.out.println("GoodBye!");
		System.exit(0);
	}

}
