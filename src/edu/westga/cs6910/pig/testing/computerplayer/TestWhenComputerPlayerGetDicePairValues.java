package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class, alongside its extended AbstractPlayer class,
 * with the getDiceValues method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerGetDicePairValues {
	
	/**
	 * Test method getDiceValues for new ComputerPlayer object.
	 */
	@Test
	public void testWithNewComputerPlayerShouldHaveDieValuesOf1ForEachDie() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		
		assertEquals("1, 1", newComputerPlayer.getDiceValues());
	}

}
