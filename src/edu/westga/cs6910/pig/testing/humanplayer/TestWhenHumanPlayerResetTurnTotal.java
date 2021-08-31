package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the resetTurnTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerResetTurnTotal {

	/**
	 * Test method resetTurnTotal on new HumanPlayer object.
	 */
	@Test
	public void testOnNewHumanPlayerShouldReturn0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.resetTurnTotal();
		
		assertEquals(0, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method resetTurnTotal on HumanPlayer object
	 * with turn total 1.
	 */
	@Test
	public void testOnHumanPlayerWithTurnTotal1ShouldReturn0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(1);
		newHumanPlayer.resetTurnTotal();
		
		assertEquals(0, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method resetTurnTotal on HumanPlayer object
	 * with turn total 12.
	 */
	@Test
	public void testOnHumanPlayerWithTurnTotal12ShouldReturn0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(12);
		newHumanPlayer.resetTurnTotal();
		
		assertEquals(0, newHumanPlayer.getTurnTotal());
	}

}
