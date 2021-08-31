package edu.westga.cs6910.pig.model.strategies;

/**
 * Implements PigStrategy for
 * ComputerPlayer to make cautious turn decisions.
 * 
 * @author Brandon Drick
 * @version 06/19/2021
 */
public class CautiousStrategy implements PigStrategy {
	
	@Override
	/**
	 * @see PigStrategy#rollAgain(int, int, int)
	 */
	public boolean rollAgain(int numberOfRollsTaken, int totalTurnPoints, int pointsNeeded) {
		return false;
	}
}
