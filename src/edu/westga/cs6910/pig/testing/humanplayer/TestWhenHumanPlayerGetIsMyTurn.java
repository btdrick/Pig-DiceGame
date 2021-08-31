package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the getIsMyTurn method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerGetIsMyTurn {

	/**
	 * Test method getIsMyTurn for new HumanPlayer object.
	 */
	@Test
	public void testWithNewHumanPlayerShouldReturnFalse() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		
		assertEquals(false, newHumanPlayer.getIsMyTurn());
	}

}
