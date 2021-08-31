package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the getTurnTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerAddToTurnTotal {

	/**
	 * Test method addToTurnTotal(0).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(0);
		
		assertEquals(0, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(1).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd1() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(1);
		
		assertEquals(1, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(5).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd5() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(5);
		
		assertEquals(5, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(12).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd12() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(12);
		
		assertEquals(12, newHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(20).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd20() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(20);
		
		assertEquals(20, newHumanPlayer.getTurnTotal());
	}

	/**
	 * Test method addToTurnTotal(24).
	 */
	@Test
	public void testWithNewHumanPlayerShouldAdd24() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTurnTotal(24);
		
		assertEquals(24, newHumanPlayer.getTurnTotal());
	}
}
