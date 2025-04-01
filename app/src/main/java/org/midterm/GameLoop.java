package org.midterm;

import java.util.HashMap;

public class GameLoop {
	private HashMap<Integer, Object[]> map = new HashMap<>();
	private int quarter;

	public GameLoop() {
		// This makes a hash map for to teams, key 1 is team one and 2 is two. The value
		// is an Object array where index 0 is name and index 1 is score
		GameAssests assests = new GameAssests();

		Object[] nameScoreTeamOne = new Object[2];
		Object[] nameScoreTeamTwo = new Object[2];

		nameScoreTeamOne[0] = assests.teamName();
		nameScoreTeamTwo[0] = assests.teamName();

		nameScoreTeamOne[1] = 0;
		nameScoreTeamTwo[1] = 0;

		map.put(1, nameScoreTeamOne);
		map.put(2, nameScoreTeamTwo);

	}

	public void quarterSim() {

	}

	public HashMap<Integer, Object[]> getTeamMap() {
		return map;
	}

}
