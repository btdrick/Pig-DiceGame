package edu.westga.cs6910.pig.model.strategies;

/**
 * Implements PigStrategy for
 * ComputerPlayer to make random turn decisions.
 * 
 * @author Brandon Drick
 * @version 06/19/2021
 */
public class RandomStrategy implements PigStrategy {

	@Override
	/**
	 * @see PigStrategy#rollAgain(int, int, int)
	 */
	public boolean rollAgain(int numberOfRollsTaken, int totalTurnPoints, int pointsNeeded) {
		if (numberOfRollsTaken < 0 || totalTurnPoints < 0) {
			throw new IllegalArgumentException("Integers cannot be negative");
		}
		
		if (Math.random() > 0.5 && pointsNeeded > 0) {
			return true;
		}
		
		return false;
	}

}
