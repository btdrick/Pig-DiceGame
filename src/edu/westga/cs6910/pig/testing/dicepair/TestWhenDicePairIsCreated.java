package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the functionality of the 
 * DicePair class constructor with its 
 * getDie1Value and getDie2Value methods.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenDicePairIsCreated {

	/**
	 * Test method getDie1Value for new DicePair.
	 */
	@Test
	public void testWithNewDicePairDie1ShouldHave1Pip() {
		DicePair newDicePair = new DicePair();
		
		assertEquals(1, newDicePair.getDie1Value());
	}

	/**
	 * Test method getDie2Value for new DicePair.
	 */
	@Test
	public void testWithNewDicePairDie2ShouldHave1Pip() {
		DicePair newDicePair = new DicePair();
		
		assertEquals(1, newDicePair.getDie2Value());
	}
	
	/**
	 * Test that both Die objects for DicePair are created
	 */
	@Test
	public void testWithNewDicePairShouldReturnTrueFor2DieObjectsCreated() {
		DicePair newDicePair = new DicePair();
		boolean containsDice = false;
		
		if (newDicePair.getDie1Value() == 1 && newDicePair.getDie2Value() == 1) {
			containsDice = true;
		}
		
		assertEquals(true, containsDice);
	}

}
