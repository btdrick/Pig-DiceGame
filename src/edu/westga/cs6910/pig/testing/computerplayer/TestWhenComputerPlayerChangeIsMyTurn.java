package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the changeIsMyTurn method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerChangeIsMyTurn {

	/**
	 * Test method changeIsMyTurn(true) for ComputerPlayer object.
	 */
	@Test
	public void testChangeIsMyTurnToTrueShouldReturnTrue() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.changeIsMyTurn(true);
		
		assertEquals(true, newComputerPlayer.getIsMyTurn());
	}
	
	/**
	 * Test method changeIsMyTurn(false) for ComputerPlayer object.
	 */
	@Test
	public void testChangeIsMyTurnToFalseShouldReturnFalse() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.changeIsMyTurn(true);
		newComputerPlayer.changeIsMyTurn(false);
		
		assertEquals(false, newComputerPlayer.getIsMyTurn());
	}

}
