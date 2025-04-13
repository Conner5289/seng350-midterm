package org.midterm;

import java.util.HashMap;

public class menu {
	HashMap<Integer, Boolean> options = new HashMap<>();

	public void printMenu(int i) {

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

		switch (i) {
			case 1:
				System.out.println("===== Main Menu =====");
				System.out.println("There is no game");
				System.out.println("1. Start a game");
				System.out.println("6. See All finished games");
				System.out.println("9. Exit");
				System.out.println();
				System.out.print("What would you like to do? :");
				break;
			case 2:
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

				break;
			case 3:
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

				break;

			default:
				System.out.println("===== Main Menu =====");
				System.out.println("It is the end of the quarter");
				System.out.println("2. Sim next quarter");
				System.out.println("3. Currnet score");
				System.out.println("4. Predict final score");
				System.out.println("5. Prediction Stats");
				System.out.println("6. See all finished games");
				System.out.println("9. Exit");
				System.out.println();
				System.out.print("What would you like to do? :");

				break;
		}

	}

}
