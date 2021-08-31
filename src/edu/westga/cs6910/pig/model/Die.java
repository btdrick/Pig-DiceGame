package edu.westga.cs6910.pig.model;

/**
 * Die represents a 6-sided die.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class Die {
	private int numberShowing;

	/**
	 * Creates a new Die instance with 1 pip showing.
	 */
	public Die() {
		this.numberShowing = 1;
	}
	
	/**
	 * Resets this.numberShowing to 1
	 */
	public void resetNumberOfPips() {
		this.numberShowing = 1;
	}

	/**
	 * Gives the Die a new value 1 - 6.
	 */
	public void roll() {
		this.numberShowing = (int) (Math.random() * 6) + 1;
	}

	/**
	 * Returns how many pips are showing.
	 * 
	 * @return the number of pips showing
	 */
	public int getNumberOfPips() {
		return this.numberShowing;
	}

	/**
	 * Returns "pips: n" where n is the number of pips showing.
	 * 
	 * @return the String representation
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "pips: " + this.getNumberOfPips();
	}
}