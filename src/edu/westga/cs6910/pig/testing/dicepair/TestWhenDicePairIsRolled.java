package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the functionality of the 
 * DicePair class rollDice method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenDicePairIsRolled {

	/**
	 * Test method rollDice for new DicePair object.
	 */
	@Test
	public void testRollWithNewDicePairShouldOnlyProduceNumbersBetween0And7() {
		DicePair newDicePair = new DicePair();
		
		for (int count = 0; count < 10000; count++) {
			newDicePair.rollDice();
			
			if (newDicePair.getDie1Value() < 1 || newDicePair.getDie1Value() > 6
					|| newDicePair.getDie2Value() < 1 || newDicePair.getDie2Value() > 6) {
				fail("Rolled a dice pair with values: " + newDicePair.getDie1Value()
						+ " " + newDicePair.getDie2Value());
			}
		}
	}

}
