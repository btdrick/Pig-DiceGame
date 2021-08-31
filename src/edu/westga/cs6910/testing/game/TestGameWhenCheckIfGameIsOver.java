package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class isGameOver method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestGameWhenCheckIfGameIsOver {

	/**
	 * Test method isGameOver() for new game.
	 */
	@Test
	public void testIsGameOverForNewGameShouldReturnFalse() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newComputerPlayer);
		
		assertEquals(false, newGame.isGameOver());
	}
	
	/**
	 * Test method isGameOver() for new game
	 * after a player holds on their first turn.
	 */
	@Test
	public void testIsGameOverForGameAfterPlayerHoldsShouldReturnFalse() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newComputerPlayer);
		newGame.hold();
		
		assertEquals(false, newGame.isGameOver());
	}

}
