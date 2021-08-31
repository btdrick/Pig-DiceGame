package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Game;

/**
 * This class tests the functionality of the
 * Game class getGoalScore method.
 * 
 * @author Brandon Drick
 * @version 06/29/2021
 */
public class TestWhenGameGetsGoalScore {

	/**
	 * Test method getGoalScore for new game.
	 */
	@Test
	public void testGetGoalScoreForNewGameShouldBe20() {
		assertEquals(20, Game.getGoalScore());
	}

}
