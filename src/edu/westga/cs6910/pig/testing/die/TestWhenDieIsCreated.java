package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * This class tests the functionality of the
 * Die object constructor using its toString method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenDieIsCreated {

	/**
	 * Tests method toString on newly created Die object.
	 */
	@Test
	public void testShouldProduceDieWith1Pip() {
		Die testDie = new Die();
		
		assertEquals("pips: 1", testDie.toString());
	}

}
