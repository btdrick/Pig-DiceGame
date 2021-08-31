package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the getTurnTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerAddToTurnTotal {

	/**
	 * Test method addToTurnTotal(0).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(0);
		
		assertEquals(0, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(1).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd1() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(1);
		
		assertEquals(1, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(5).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd5() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(5);
		
		assertEquals(5, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(12).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd12() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(12);
		
		assertEquals(12, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method addToTurnTotal(20).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd20() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(20);
		
		assertEquals(20, newComputerPlayer.getTurnTotal());
	}

	/**
	 * Test method addToTurnTotal(24).
	 */
	@Test
	public void testWithNewComputerPlayerShouldAdd24() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(24);
		
		assertEquals(24, newComputerPlayer.getTurnTotal());
	}
}
