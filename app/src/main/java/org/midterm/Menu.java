package org.midterm;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	public void menuChoice() {
		int userChoice;
		Boolean valiedChoice;
		Boolean playing = true;
		HashMap<Integer, Boolean> options = new HashMap<>();

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

			GameLoop mainGame = GameLoopManager.getInstance();

			switch (userChoice) {
				case 1:
					// NOTE: Starting game

					// Locks
					options.put(1, false);
					// Unlocks
					options.put(2, true);// Sim
					options.put(3, true);// Current score
					options.put(4, true);// Predict final

					HashMap<Integer, Object[]> teamsMap = mainGame.getTeamMap();

					Object[] teamOneArray = teamsMap.get(1);
					Object[] teamTwoArray = teamsMap.get(2);

					String teamOneName = (String) teamOneArray[0];
					String teamTwoName = (String) teamTwoArray[0];

					System.out.println("The game is starting ");
					System.out.println(teamOneName + " will be playing " + teamTwoName);

					break;
				case 2:
					// TODO: Sim a quarter

					break;

				case 3:
					// TODO: Print score

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
					// TODO: Make title

					break;

				case 8:
					System.out.println("GoodBye");
					playing = false;
					break;

				default:
					throw new UnsupportedOperationException("Switch out of bounce");
			}

		} while (playing);

		System.exit(0);
	}

}
