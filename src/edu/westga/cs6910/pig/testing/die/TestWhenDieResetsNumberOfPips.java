package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This class tests the functionality of the
 * Die class resetNumberOfPips method.
 * 
 * @author Brandon Drick
 * @version 06/29/2021
 */
public class TestWhenDieResetsNumberOfPips {

	/**
	 * Test that number of pips resets after a roll.
	 */
	@Test
	public void testResetNumberOfPipsAfterRollShouldReturn1() {
		Die testDie = new Die();
		testDie.roll();
		testDie.resetNumberOfPips();
		assertEquals(1, testDie.getNumberOfPips());
	}

}
