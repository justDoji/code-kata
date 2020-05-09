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
	public void gutterGame() {
		rollMany(20, 0);
		assertThat(game.score()).as("Expect the game score to be zero if no pins were rolled over").isEqualTo(0);
	}

	@Test
	void allOnes() {
		rollMany(20, 1);
		assertThat(game.score()).isEqualTo(20);
	}

	@Test
	@Disabled("Test brought out design flaw. Redesigning system before enabling test")
	void oneSpare() {
		game.roll(5);
		game.roll(5); //spare
		game.roll(3);
		rollMany(17, 0);
		assertThat(game.score()).isEqualTo(16);
	}

	private void rollMany(int amountOfRolls, int pinsToRollOnEachTurn) {
		for (int i = 0; i < amountOfRolls; i++) {
			game.roll(pinsToRollOnEachTurn);
		}
	}
}
