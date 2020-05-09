package be.doji.sandbox.kata;

public class Game {

	private final int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pinsRolledOver) {
		rolls[currentRoll++] = pinsRolledOver;
	}

	public int score() {
		int score = 0;
		for(int i = 0; i < rolls.length; i++) {
			score += rolls[i];
		}
		return score;
	}
}
