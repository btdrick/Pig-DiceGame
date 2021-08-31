package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the getTotal method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerGetTotal {

	/**
	 * Test method getTotal for new ComputerPlayer object.
	 */
	@Test
	public void testWithNewComputerPlayerObjectShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		
		assertEquals(0, newComputerPlayer.getTotal());
	}

}
