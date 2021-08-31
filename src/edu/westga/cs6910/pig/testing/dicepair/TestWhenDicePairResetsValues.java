package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 *  Tests the functionality of the 
 *  DicePair class resetDicePairValues method.
 *  
 * @author Brandon Drick
 * @version 6/29/2021
 */
public class TestWhenDicePairResetsValues {
	
	/**
	 * Test that values reset after a roll.
	 */
	@Test
	public void testDicePairValuesResetAfterRollShouldBothReturn1() {
		DicePair testPair = new DicePair();
		testPair.rollDice();
		testPair.resetDicePairValues();
		boolean isReset = (testPair.getDie1Value() == 1 && testPair.getDie2Value() == 1);
		
		assertEquals(true, isReset);
	}

}
