package edu.westga.cs6910.pig.testing.greedystrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

/**
 * Tests the functionality of GreedyStrategy class
 * method rollAgain(int, int, int).
 * 
 * @author Brandon Drick
 * @version 06/19/2021
 */
public class TestWhenGreedyStrategyChecksToRollAgain {

	/**
	 * Test whether GreedyStrategy returns true upon creation
	 */
	@Test
	public void testRollAgainOn1stRollShouldReturnTrue() {
		GreedyStrategy greedyStrategy = new GreedyStrategy();
		
		assertEquals(true, greedyStrategy.rollAgain(1, 0, 20));
	}
	
	/**
	 * Test whether GreedyStrategy returns true on 2nd roll
	 */
	@Test
	public void testRollAgainOn2ndRollShouldReturnTrue() {
		GreedyStrategy greedyStrategy = new GreedyStrategy();
		
		assertEquals(true, greedyStrategy.rollAgain(2, 0, 20));
	}
	
	/**
	 * Test whether GreedyStrategy returns true on 3rd roll
	 */
	@Test
	public void testRollAgainOn3rdRollShouldReturnTrue() {
		GreedyStrategy greedyStrategy = new GreedyStrategy();
		
		assertEquals(true, greedyStrategy.rollAgain(2, 0, 20));
	}
	
	/**
	 * Test whether GreedyStrategy returns false on 4th roll
	 */
	@Test
	public void testRollAgainOn4thRollShouldReturnFalse() {
		GreedyStrategy greedyStrategy = new GreedyStrategy();
		
		assertEquals(false, greedyStrategy.rollAgain(3, 0, 20));
	}

}
