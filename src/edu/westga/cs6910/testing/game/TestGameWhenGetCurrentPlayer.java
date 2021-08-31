package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class getCurrentPlayer method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestGameWhenGetCurrentPlayer {

	/**
	 * Test method getCurrentPlayer on new game with
	 * HumanPlayer as first player.
	 */
	@Test
	public void testGetCurrentPlayerForNewGameShouldBeHumanPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newHumanPlayer);
		
		assertEquals("A human player named Brandon", newGame.getCurrentPlayer().toString());
	}

	/**
	 * Test method getCurrentPlayer on new game with
	 * HumanPlayer as first player.
	 */
	@Test
	public void testGetCurrentPlayerForNewGameShouldBeComputerPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newComputerPlayer);
		
		assertEquals("A computer player named Simple computer", newGame.getCurrentPlayer().toString());
	}
	
}
