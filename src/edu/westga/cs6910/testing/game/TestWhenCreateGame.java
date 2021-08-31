package edu.westga.cs6910.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * This class tests the functionality of the
 * Game class constructor using its toString method.
 * 
 * @author Brandon Drick
 * @version 06/10/2021
 */
public class TestWhenCreateGame {

	/**
	 * Test Game object constructor and its toStringMethod
	 */
	@Test
	public void testCreateNewGameShouldReturnDescriptionOfNewGame() {
		HumanPlayer newHumanPlayer = new HumanPlayer("Brandon");
		ComputerPlayer newComputerPlayer = new ComputerPlayer(new CautiousStrategy());
		Game newGame = new Game(newHumanPlayer, newComputerPlayer);
		
		assertEquals("Goal Score: 20" + System.getProperty("line.separator") 
				+ "Brandon: 0" + System.getProperty("line.separator") 
						+ "Simple computer: 0", newGame.toString());
	}

}
