package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the changeIsMyTurn method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerChangeIsMyTurn {

	/**
	 * Test method changeIsMyTurn(true) for HumanPlayer object.
	 */
	@Test
	public void testChangeIsMyTurnToTrueShouldReturnTrue() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.changeIsMyTurn(true);
		
		assertEquals(true, newHumanPlayer.getIsMyTurn());
	}
	
	/**
	 * Test method changeIsMyTurn(false) for HumanPlayer object.
	 */
	@Test
	public void testChangeIsMyTurnToFalseShouldReturnFalse() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.changeIsMyTurn(true);
		newHumanPlayer.changeIsMyTurn(false);
		
		assertEquals(false, newHumanPlayer.getIsMyTurn());
	}

}
