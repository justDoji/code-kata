package be.doji.sandbox.kata;

public class Game {

	private int score = 0;

	public void roll(int pinsRolledOver) {
		score += pinsRolledOver;
	}

	public int score() {
		return this.score;
	}
}
