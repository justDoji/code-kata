package be.doji.sandbox.kata;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	public void gutterGame() {
		for(int i = 0; i < 20; i++) {
			game.roll(0);
		}
		assertThat(game.score()).as("Expect the game score to be zero if no pins were rolled over").isEqualTo(0);
	}

	@Test
	void allOnes() {
		for(int i = 0; i < 20; i++) {
			game.roll(1);
		}
		assertThat(game.score()).isEqualTo(20);
	}
}
