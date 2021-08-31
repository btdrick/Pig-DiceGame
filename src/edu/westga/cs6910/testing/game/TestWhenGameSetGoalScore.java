package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class setGoalScore method.
 * 
 * @author Brandon Drick
 * @version 06/29/2021
 */
public class TestWhenGameSetGoalScore {

	/**
	 * Test method setGoalScore(10) for new Game.
	 */
	@Test
	public void testSetGoalScoreShouldReturn10() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.setGoalScore(10);
		
		assertEquals(10, Game.getGoalScore());
	}

	/**
	 * Test method setGoalScore(50) for new Game.
	 */
	@Test
	public void testSetGoalScoreShouldReturn50() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.setGoalScore(50);
		
		assertEquals(50, Game.getGoalScore());
	}
	
	/**
	 * Test method setGoalScore(100) for new Game.
	 */
	@Test
	public void testSetGoalScoreShouldReturn100() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.setGoalScore(100);
		
		assertEquals(100, Game.getGoalScore());
	}
	
	/**
	 * Test method setGoalScore twice.
	 */
	@Test
	public void testSetGoalScoreTwiceShouldReturn40() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.setGoalScore(10);
		newGame.setGoalScore(40);
		
		assertEquals(40, Game.getGoalScore());
	}
}
