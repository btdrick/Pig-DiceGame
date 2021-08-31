package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the addToTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerAddToTotal {

	/**
	 * Test method addToTotal(0) for new ComputerPlayer object.
	 */
	@Test
	public void testAdd0ToComputerPlayerTotalShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(0);
		
		assertEquals(0, newComputerPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(1) for new ComputerPlayer object.
	 */
	@Test
	public void testAdd1ToComputerPlayerTotalShouldReturn1() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(1);
		
		assertEquals(1, newComputerPlayer.getTotal());
	}

	/**
	 * Test method addToTotal(7) for new ComputerPlayer object.
	 */
	@Test
	public void testAdd7ToComputerPlayerTotalShouldReturn7() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(7);
		
		assertEquals(7, newComputerPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(12) for new ComputerPlayer object.
	 */
	@Test
	public void testAdd12ToComputerPlayerTotalShouldReturn12() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(12);
		
		assertEquals(12, newComputerPlayer.getTotal());
	}
	
	/**
	 * Test method addToTotal(36) for new ComputerPlayer object.
	 */
	@Test
	public void testAdd36ToComputerPlayerTotalShouldReturn36() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(36);
		
		assertEquals(36, newComputerPlayer.getTotal());
	}
	
}
