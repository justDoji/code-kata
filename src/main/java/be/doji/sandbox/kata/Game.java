package be.doji.sandbox.kata;

public class Game {

	private final int[] pinsKnockedOver = new int[21];
	private int currentRoll = 0;

	public void roll(int pinsRolledOver) {
		pinsKnockedOver[currentRoll++] = pinsRolledOver;
	}

	public int score() {
		int score = 0;
		int rollCounter = 0;
		for(int frame = 0; frame < 10; frame++) {
			if(pinsKnockedOver[rollCounter] == 10) {
				score += 10 + pinsKnockedOver[rollCounter +1 ] + pinsKnockedOver[rollCounter + 2];
				rollCounter += 1;
			} else {
				int frameScore = pinsKnockedOver[rollCounter] + pinsKnockedOver[rollCounter + 1];
				score += isSpare(frameScore) ? frameScore + pinsKnockedOver[rollCounter + 2] : frameScore;
				rollCounter += 2;
			}
		}
		return score;
	}

	private boolean isSpare(int frameScore) {
		return frameScore == 10;
	}
}
