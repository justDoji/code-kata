package be.doji.sandbox.kata;

public class Game {

	private final int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pinsRolledOver) {
		rolls[currentRoll++] = pinsRolledOver;
	}

	public int score() {
		int score = 0;
		int rollCounter = 0;
		for(int frame = 0; frame < 10; frame++) {
			int frameScore = rolls[rollCounter] + rolls[rollCounter + 1];
			score += frameScore == 10 ? frameScore + rolls[rollCounter + 2] : frameScore;
			rollCounter += 2;
		}
		return score;
	}
}
