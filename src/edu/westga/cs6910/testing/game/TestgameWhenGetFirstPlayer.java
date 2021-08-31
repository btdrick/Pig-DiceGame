package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class getCurrentPlayer method.
 * 
 * @author Brandon Drick
 * @version 06/29/2021
 */
public class TestgameWhenGetFirstPlayer {

	/**
	 * Test getFirstPlayer after human first player is selected.
	 */
	@Test
	public void testGetFirstPlayerHumanShouldbeHumanPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newHumanPlayer);
		Player firstPlayer = newGame.getFirstPlayer();
		
		assertEquals("A human player named Brandon", firstPlayer.toString());
	}
	
	/**
	 * Test getFirstPlayer after computer first player is selected.
	 */
	@Test
	public void testGetFirstPlayerComputerShouldbeComputerPlayer() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		newGame.startNewGame(newComputerPlayer);
		Player firstPlayer = newGame.getFirstPlayer();
		
		assertEquals("A computer player named Simple computer", firstPlayer.toString());
	}

}
