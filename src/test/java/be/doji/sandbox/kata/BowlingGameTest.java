package be.doji.sandbox.kata;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	public void whenNoPinsWereKnockedOver_theScoreIsZero() {
		rollMany(20, 0);
		assertThat(game.score()).as("Expect the game score to be zero if no pins were rolled over").isEqualTo(0);
	}

	@Test
	void whenNoSpecialEventsHappen_theScoreIsTheSumOfAllKnockedOverPins() {
		rollMany(20, 1);
		assertThat(game.score()).isEqualTo(20);
	}

	@Test
	void whenSpareIsRolled_theBonusIsTheNextRollPins() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertThat(game.score()).isEqualTo(16);
	}

	@Test
	void whenStrikeIsRolled_theBonusIsTheNextFramePins() {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(17, 0);
		assertThat(game.score()).isEqualTo(24);
	}

	@Test
	void whenAllFramesAreStrikes_aPerfectScoreIsAchieved() {
		rollMany(12, 10);
		assertThat(game.score()).isEqualTo(300);
	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(3);
		game.roll(7);
	}

	private void rollMany(int amountOfRolls, int pinsToRollOnEachTurn) {
		for (int i = 0; i < amountOfRolls; i++) {
			game.roll(pinsToRollOnEachTurn);
		}
	}
}
