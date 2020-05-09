package be.doji.sandbox.kata;

public class Game {

	public static final int MAXIMUM_ROLL_IN_GAME = 21;
	public static final int AMOUNT_OF_FRAMES_IN_GAME = 10;
	public static final int MAX_PINS_PER_FRAME = 10;

	private final int[] pinsKnockedOver = new int[MAXIMUM_ROLL_IN_GAME];
	private int currentRoll = 0;

	public void roll(int pinsRolledOver) {
		pinsKnockedOver[currentRoll++] = pinsRolledOver;
	}

	public int score() {
		int score = 0;
		int rollCounter = 0;
		for(int frame = 0; frame < AMOUNT_OF_FRAMES_IN_GAME; frame++) {
			if(isStrike(rollCounter)) {
				score += 10 + strikeBonus(rollCounter);
				rollCounter += 1;
			} else if(isSpare(rollCounter)) {
				score += sumOfPinsKnockedOverInFrame(rollCounter) + spareBonus(rollCounter);
				rollCounter += 2;
			} else {
				score += sumOfPinsKnockedOverInFrame(rollCounter);
				rollCounter += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int rollCounter) {
		return pinsKnockedOver[rollCounter] == MAX_PINS_PER_FRAME;
	}

	private boolean isSpare(int rollCounter) {
		return sumOfPinsKnockedOverInFrame(rollCounter) == MAX_PINS_PER_FRAME;
	}

	private int sumOfPinsKnockedOverInFrame(int rollCounter) {
		return pinsKnockedOver[rollCounter] + pinsKnockedOver[rollCounter + 1];
	}

	private int spareBonus(int rollCounter) {
		return pinsKnockedOver[rollCounter + 2];
	}

	private int strikeBonus(int rollCounter) {
		return pinsKnockedOver[rollCounter + 1] + pinsKnockedOver[rollCounter + 2];
	}
}
