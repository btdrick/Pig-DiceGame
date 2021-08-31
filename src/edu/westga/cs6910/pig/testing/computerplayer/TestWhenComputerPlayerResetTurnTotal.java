package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the resetTurnTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerResetTurnTotal {

	/**
	 * Test method resetTurnTotal on new ComputerPlayer object.
	 */
	@Test
	public void testOnNewComputerPlayerShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.resetTurnTotal();
		
		assertEquals(0, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method resetTurnTotal on ComputerPlayer object
	 * with turn total 1.
	 */
	@Test
	public void testOnComputerPlayerWithTurnTotal1ShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(1);
		newComputerPlayer.resetTurnTotal();
		
		assertEquals(0, newComputerPlayer.getTurnTotal());
	}
	
	/**
	 * Test method resetTurnTotal on ComputerPlayer object
	 * with turn total 12.
	 */
	@Test
	public void testOnComputerPlayerWithTurnTotal12ShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTurnTotal(12);
		newComputerPlayer.resetTurnTotal();
		
		assertEquals(0, newComputerPlayer.getTurnTotal());
	}

}
