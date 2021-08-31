package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This class tests the functionality of the
 * Die class roll method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenDieIsRolled {

	/**
	 * Test method roll on new Die object.
	 */
	@Test
	public void testRollWithNewDieShouldOnlyProduceNumbersBetween0And7() {
		Die newDie = new Die();
		
		for (int count = 0; count < 10000; count++) {
			newDie.roll();
			
			if (newDie.getNumberOfPips() < 1 || newDie.getNumberOfPips() > 6) {
				fail("Rolled a die with value: " + newDie.getNumberOfPips());
			}
		}
	}

}
