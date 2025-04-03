package org.midterm;

public interface GameSubject {

	void addObserver(ScoreObserver observer);

	void removeObserver(ScoreObserver observer);

	void updateObservers();
}
