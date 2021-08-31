package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * ComputerPlayer class setMaximumRolls method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenComputerPlayerSetMaximumRolls {

	/**
	 * Test method setMaximumRolls() for new ComputerPlayer object.
	 */
	@Test
	public void test0ParameterMethodWithNewComputerPlayerShouldReturn1() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.setMaximumRolls();
		
		assertEquals(1, newComputerPlayer.getMaximumRolls());
	}

	/**
	 * Test method setMaximumRolls(0) for new ComputerPlayer object.
	 */
	@Test
	public void testSetComputerPlayerMaximumRollsAt0ShouldReturn0() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.setMaximumRolls(0);
		
		assertEquals(0, newComputerPlayer.getMaximumRolls());
	}
	
	/**
	 * Test method setMaximumRolls(3) for new ComputerPlayer object.
	 */
	@Test
	public void testSetComputerPlayerMaximumRollsAt3ShouldReturn3() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.setMaximumRolls(3);
		
		assertEquals(3, newComputerPlayer.getMaximumRolls());
	}
	
	/**
	 * Test method setMaximumRolls(5) for new ComputerPlayer object.
	 */
	@Test
	public void testSetComputerPlayerMaximumRollsAt5ShouldReturn5() {
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		newComputerPlayer.setMaximumRolls(5);
		
		assertEquals(5, newComputerPlayer.getMaximumRolls());
	}
}
