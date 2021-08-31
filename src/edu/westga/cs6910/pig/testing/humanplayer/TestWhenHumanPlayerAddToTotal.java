package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the addToTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerAddToTotal {

	/**
	 * Test method addToTotal(0) for new HumanPlayer object.
	 */
	@Test
	public void testAdd0ToHumanPlayerTotalShouldReturn0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(0);
		
		assertEquals(0, newHumanPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(1) for new HumanPlayer object.
	 */
	@Test
	public void testAdd1ToHumanPlayerTotalShouldReturn1() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(1);
		
		assertEquals(1, newHumanPlayer.getTotal());
	}

	/**
	 * Test method addToTotal(7) for new HumanPlayer object.
	 */
	@Test
	public void testAdd7ToHumanPlayerTotalShouldReturn7() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(7);
		
		assertEquals(7, newHumanPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(12) for new HumanPlayer object.
	 */
	@Test
	public void testAdd12ToHumanPlayerTotalShouldReturn12() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(12);
		
		assertEquals(12, newHumanPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(36) for new HumanPlayer object.
	 */
	@Test
	public void testAdd36ToHumanPlayerTotalShouldReturn36() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(36);
		
		assertEquals(36, newHumanPlayer.getTotal());
	}
	
}
