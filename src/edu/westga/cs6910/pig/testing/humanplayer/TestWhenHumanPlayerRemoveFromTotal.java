package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the removeFromTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerRemoveFromTotal {

	/**
	 * Test method removeFromTotal(1) from total of 1.
	 */
	@Test
	public void testRemove1FromHumanPlayerTotalOf1ShouldReturn0() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(1);
		newHumanPlayer.removeFromTotal(1);
		
		assertEquals(0, newHumanPlayer.getTotal());
	}
	
	/**
	 * Test method removeFromTotal(5) from total of 6.
	 */
	@Test
	public void testRemove5FromHumanPlayerTotalOf6ShouldReturn1() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		newHumanPlayer.addToTotal(6);
		newHumanPlayer.removeFromTotal(5);
		
		assertEquals(1, newHumanPlayer.getTotal());
	}

}
