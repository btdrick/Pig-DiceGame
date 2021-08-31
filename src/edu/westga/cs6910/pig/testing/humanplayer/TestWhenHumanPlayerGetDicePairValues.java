package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * This class tests the functionality of the
 * HumanPlayer class, alongside its extended AbstractPlayer class,
 * with the getDiceValues method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenHumanPlayerGetDicePairValues {
	
	/**
	 * Test method getDiceValues for new HumanPlayer object.
	 */
	@Test
	public void testWithNewHumanPlayerShouldHaveDieValuesOf1ForEachDie() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		
		assertEquals("1, 1", newHumanPlayer.getDiceValues());
	}

}
