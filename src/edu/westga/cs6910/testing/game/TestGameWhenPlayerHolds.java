package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class hold method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestGameWhenPlayerHolds {
	
	/**
	 * Test method swapWhoseTurn for new Game
	 * with ComputerPlayer as initial player.
	 */
	@Test
	public void testHoldForNewGameWithComputerPlayerShouldReturnHumanPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newComputerPlayer);
		newGame.hold();
		
		assertEquals("A human player named Brandon", newGame.getCurrentPlayer().toString());
	}
	
	/**
	 * Test method swapWhoseTurn for new Game
	 * with HumanPlayer as initial player.
	 */
	@Test
	public void testHoldForNewGameWithHumanPlayerShouldReturnComputerPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newHumanPlayer);
		newGame.hold();
		
		assertEquals("A computer player named Simple computer", newGame.getCurrentPlayer().toString());
	}

}
