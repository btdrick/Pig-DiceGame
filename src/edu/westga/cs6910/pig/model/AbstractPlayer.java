package edu.westga.cs6910.pig.model;

/**
 * Implements shared methods between 
 * ComputerPlayer and HumanPlayer class.
 * 
 * @author Brandon Drick
 * @version 6/6/2021
 */
public abstract class AbstractPlayer implements Player {
	private int turnTotal;
	private int total;
	private boolean isMyTurn;
	private String name;
	private DicePair thePair;
	
	/**
	 * Creates a new AbstractPlayer object 
	 * holding a new DicePair.
	 * 
	 * @param name of the player
	 */
	public AbstractPlayer(String name) {
		if (name == null) {
			throw new NullPointerException("Name cannot be null");
		}
		if (name.length() < 1) {
			throw new IllegalArgumentException("Name must contain at least 1 character");
		}
		
		this.thePair = new DicePair();
		this.name = name;
	}
	
	/**
	 * Resets the values of the player for a new game
	 */
	public void resetPlayer() {
		this.resetTotal();
		this.resetTurnTotal();
		this.resetDicePair();
	}
	
	@Override
	/**
	 * @see Player#resetTurnTotal()
	 */	
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}
	
	@Override
	/**
	 *  @see Player#resetDicePair()
	 */
	public void resetDicePair() {
		this.thePair.resetDicePairValues();
	}
	
	@Override
	/**
	 * @see Player#resetTotal()
	 */
	public void resetTotal() {
		this.total = 0;
	}
	
	@Override	
	/**
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}
	
	/**
	 * Adds to this.turnTotal
	 * @param amount to add
	 */
	public void addToTurnTotal(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must at least be 0");
		}
		
		this.turnTotal += amount;
	}
	
	@Override	
	/**
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}
	
	/**
	 * Changes the value of this.isMyTurn.
	 * @param value false or true.
	 */
	public void changeIsMyTurn(boolean value) {
		this.isMyTurn = value;
	}
	
	@Override	
	/**
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}
	
	/**
	 * Deducts amount from this.total.
	 * @param amount to deduct.
	 */
	public void removeFromTotal(int amount) {
		if (amount > this.total) {
			throw new IllegalArgumentException("Amount to remove cannot exceed total");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must at least be 0");
		}
		
		this.total -= amount;
	}
	
	/**
	 * Adds amount to this.total.
	 * @param amount to add.
	 */
	public void addToTotal(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must at least be 0");
		}
		this.total += amount;
	}
	
	@Override	
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns this.thePair
	 * @return this.thePair
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}
	
	@Override	
	/**
	 * @see Player#getDiceValues()
	 */
	public String getDiceValues() {	
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}
	
	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public abstract void takeTurn();
	
	/**
	 * Returns a description of the player.
	 * @return player description
	 */
	public abstract String toString();
}
