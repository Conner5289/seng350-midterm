package org.midterm;

import java.util.Scanner;

public class App {

	public static int menu() {
		int userChoice;

		do {
			Scanner scrn = new Scanner(System.in);

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
				System.out.println("That was not an option");
				System.out.println("");
			}

		} while (userChoice < 1 || userChoice > 8);

		return userChoice;

	}

	public static void main(String[] args) {
		Game game = new Game();

		int userChose = App.menu();

		switch (userChose) {
			case 1:
				// NOTE: working on
				game.gameLoop();

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
				System.exit(0);

				break;

			default:
				throw new UnsupportedOperationException("Switch out of bounce");
		}

	}
}
