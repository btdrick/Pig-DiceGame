package edu.westga.cs6910.pig.testing.cautiousstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests the functionality of CautiousStrategy class
 * method rollAgain(int, int, int).
 * 
 * @author Brandon Drick
 * @version 06/19/2021
 */
public class TestWhenCautiousStrategyChecksToRollAgain {

	/**
	 * Test whether CautiousStrategy returns false upon creation.
	 */
	@Test
	public void testRollAgainForNewCautiousStrategyShouldReturnFalse() {
		CautiousStrategy newCautiousStrategy = new CautiousStrategy();
		
		assertEquals(false, newCautiousStrategy.rollAgain(0, 0, 20));
	}
	
	/**
	 * Test whether CautiousStrategy returns false after a roll
	 * earning no points.
	 */
	@Test
	public void testRollAgainForCautiousStrategyAfter1RollAnd0PointsShouldReturnFalse() {
		CautiousStrategy newCautiousStrategy = new CautiousStrategy();
		
		assertEquals(false, newCautiousStrategy.rollAgain(1, 0, 20));
	}
	
	/**
	 * Test whether CautiousStrategy returns false after a roll
	 * earning 5 points.
	 */
	@Test
	public void testRollAgainForCautiousStrategyAfter1RollAnd5PointsShouldReturnFalse() {
		CautiousStrategy newCautiousStrategy = new CautiousStrategy();
		
		assertEquals(false, newCautiousStrategy.rollAgain(1, 5, 15));
	}
	
	/**
	 * Test whether CautiousStrategy returns false after a roll
	 * earning 11 points.
	 */
	@Test
	public void testRollAgainForCautiousStrategyAfter1RollAnd11PointsShouldReturnFalse() {
		CautiousStrategy newCautiousStrategy = new CautiousStrategy();
		
		assertEquals(false, newCautiousStrategy.rollAgain(1, 11, 9));
	}
	
	/**
	 * Test whether CautiousStrategy returns false after 2 rolls
	 * earning 15 points total.
	 */
	@Test
	public void testRollAgainForCautiousStrategyAfter2RollsAnd15PointsShouldReturnFalse() {
		CautiousStrategy newCautiousStrategy = new CautiousStrategy();
		
		assertEquals(false, newCautiousStrategy.rollAgain(2, 15, 5));
	}

}
