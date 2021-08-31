package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the getIsMyTurn method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerGetIsMyTurn {

	/**
	 * Test method getIsMyTurn for new Computer Player object.
	 */
	@Test
	public void testWithNewComputerPlayerShouldReturnFalse() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		
		assertEquals(false, newComputerPlayer.getIsMyTurn());
	}

}
