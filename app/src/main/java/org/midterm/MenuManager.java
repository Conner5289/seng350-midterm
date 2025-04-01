package org.midterm;

public class MenuManager {

	private static Menu menuInstance;

	private MenuManager() {
	}

	public static Menu getInstance() {

		if (menuInstance == null) {
			menuInstance = new Menu();
		}

		return menuInstance;
	}

}
