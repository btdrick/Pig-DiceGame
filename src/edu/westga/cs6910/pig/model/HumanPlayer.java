package edu.westga.cs6910.pig.model;

/**
 * HumanPlayer represents a human player in the game Pig.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class HumanPlayer extends AbstractPlayer implements Player {
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name	this Player's name
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
	}
	
	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {	
		DicePair thePair = getDicePair();
		int turnTotal = getTurnTotal();
		thePair.rollDice();
		
		int die1Value = thePair.getDie1Value();
		int die2Value = thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {	
			removeFromTotal(turnTotal);
			changeIsMyTurn(false);
		} else {
			addToTurnTotal(die1Value + die2Value);
			addToTotal(die1Value + die2Value);
			changeIsMyTurn(true);
		}
	}
	
	@Override
	/**
	 * Returns a description of HumanPlayer.
	 * @return HumanPlayer description
	 */
	public String toString() {
		return "A human player named " + this.getName();
	}
}
