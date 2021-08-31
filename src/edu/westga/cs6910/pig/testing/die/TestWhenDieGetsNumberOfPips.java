package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This class tests the functionality of the
 * Die class getNumberOfPips method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenDieGetsNumberOfPips {

	/**
	 * Tests method getNumberOfPips on new Die object.
	 */
	@Test
	public void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die();
		
		assertEquals(1, newDie.getNumberOfPips());
	}

}
