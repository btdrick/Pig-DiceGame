package edu.westga.cs6910.pig.model;

/**
 * Represents a pair of dice
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class DicePair {
	private Die die1;
	private Die die2;
	
	/**
	 * Sets up dice pair to be ready for rolling
	 */
	public DicePair() {
		this.die1 = new Die();
		this.die2 = new Die();
	}
	
	/**
	 * Rolls each die
	 */
	public void rollDice() {
		this.die1.roll();
		this.die2.roll();
	}
	
	/**
	 * Returns the number of pips showing on the first die
	 * @return	The number of pips showing on the first die
	 */
	public int getDie1Value() {
		return this.die1.getNumberOfPips();
	}
	
	/**
	 * Returns the number of pips showing on the second die
	 * @return	The number of pips showing on the second die
	 */
	public int getDie2Value() {
		return this.die2.getNumberOfPips();
	}
	
	/**
	 * Resets the dice pair to show 1 pip
	 * for each die.
	 */
	public void resetDicePairValues() {
		this.die1.resetNumberOfPips();
		this.die2.resetNumberOfPips();
	}
}
