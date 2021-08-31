package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the toString method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenCreateNewHumanPlayer {

	/**
	 * Test method toString for new HumanPlayer object.
	 */
	@Test
	public void testCreateNewHumanPlayerShouldReturnPlayerTypeAndName() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		
		assertEquals("A human player named Brandon", newHumanPlayer.toString());
	}

}
