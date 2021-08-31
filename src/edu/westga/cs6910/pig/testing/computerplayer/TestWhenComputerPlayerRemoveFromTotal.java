package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the removeFromTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerRemoveFromTotal {

	/**
	 * Test method removeFromTotal(1) from total of 1.
	 */
	@Test
	public void testRemove1FromComputerPlayerTotalOf1ShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(1);
		newComputerPlayer.removeFromTotal(1);
		
		assertEquals(0, newComputerPlayer.getTotal());
	}
	
	/**
	 * Test method removeFromTotal(5) from total of 6.
	 */
	@Test
	public void testRemove5FromComputerPlayerTotalOf6ShouldReturn1() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.addToTotal(6);
		newComputerPlayer.removeFromTotal(5);
		
		assertEquals(1, newComputerPlayer.getTotal());
	}

}
