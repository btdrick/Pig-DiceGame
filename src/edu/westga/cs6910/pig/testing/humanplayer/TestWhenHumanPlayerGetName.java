package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the constructor for HumanPlayer and getName.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerGetName {

	/**
	 * Test method getName for new HumanPlayer object.
	 */
	@Test
	public void testWithNewHumanPlayerShouldHaveNameBrandon() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		
		assertEquals("Brandon", newHumanPlayer.getName());
	}

}
