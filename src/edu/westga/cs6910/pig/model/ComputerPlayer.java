package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig.
 * It rolls exactly 1 time and then holds.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class ComputerPlayer extends AbstractPlayer implements Player {
	private static final String NAME = "Simple computer";
	private int maximumRolls;
	private PigStrategy currentStrategy;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * @param currentStrategy the current computer strategy
	 */
	public ComputerPlayer(PigStrategy currentStrategy) {
		super(NAME);
		super.resetTurnTotal();
		
		if (currentStrategy == null) {
			throw new NullPointerException("The strategy object cannot be null");
		}
		
		this.currentStrategy = currentStrategy;
	}
	
	/**
	 * Implements Player's setMaximumRolls, but is not normally
	 * called by client objects.  Instead, clients usually
	 * call the 0-parameter version
	 * 
	 * @param	maximumRolls	The maximum number of times the computer
	 * 							will roll before holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the 
	 * maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}
	
	/**
	 * Returns this.maximumRolls
	 * @return this.maximumRolls
	 */
	public int getMaximumRolls() {
		return this.maximumRolls;
	}
	
	/**
	 * Returns this.currentStrategy
	 * @return this.currentStrategy
	 */
	public PigStrategy getCurrentStrategy() {
		return this.currentStrategy;
	}
	
	/**
	 * Assigns this.currentStrategy to new PigStrategy object
	 * @param newStrategy the new strategy
	 */
	public void setStrategy(PigStrategy newStrategy) {
		if (newStrategy == null) {
			throw new NullPointerException("The new strategy cannot be null");
		}
		
		this.currentStrategy = newStrategy;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {				
		resetTurnTotal();
		DicePair thePair = getDicePair();
		boolean rollAgain = false;
		int turnTotal = 0;
		int totalPoints = getTotal();
		int rollsTaken = 0;
		int goalScore = Game.getGoalScore();
		int pointsNeeded = goalScore - totalPoints;
		do {
			thePair.rollDice();
			rollsTaken++;
			int die1Value = thePair.getDie1Value();
			int die2Value = thePair.getDie2Value();
			int rollAmount = (die1Value + die2Value);
			if (die1Value == 1 || die2Value == 1) {
				resetTurnTotal();
				changeIsMyTurn(false);
				return;
			} else {		
				addToTurnTotal(rollAmount);
			}
			
			turnTotal = getTurnTotal();
			pointsNeeded = pointsNeeded - rollAmount;
			rollAgain = this.currentStrategy.rollAgain(rollsTaken, turnTotal, pointsNeeded);
		} while (rollAgain);
	
		turnTotal = getTurnTotal();
		addToTotal(turnTotal);
		changeIsMyTurn(false);
	}
	
	@Override
	/**
	 * Returns a description of ComputerPlayer.
	 * @return ComputerPlayer description
	 */
	public String toString() {
		return "A computer player named " + this.getName();
	}
}
