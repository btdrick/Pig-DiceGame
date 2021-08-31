package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * @author CS6910
 * @version Summer 2021
 */
public class Game implements Observable {
	/**
	 * The goal score for the game
	 */
	private static int goalScore;

	private ObjectProperty<Player> currentPlayerObject;
	private Player firstPlayer;
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private DicePair thePair;

	/**
	 * Creates a Pig Game with the specified Players and
	 * a pair of dice.
	 * 
	 * @param theComputer	the automated player
	 * @param theHuman		the human player
	 * 
	 * @require				theHuman != null && theComputer != null
	 * 
	 * @ensure				humanPlayer().equals(theHuman) &&
	 *         				computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		this.theHuman = theHuman;
		this.theComputer = theComputer;
		
		this.currentPlayerObject = new SimpleObjectProperty<Player>();
		
		this.thePair = new DicePair();
		goalScore = 20;
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer 	the Player who takes the first turn
	 * 
	 * @require 			firstPlayer != null && 
	 * 						!firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures 			whoseTurn().equals(firstPlayer) &&
	 * 						firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		this.currentPlayerObject.setValue(firstPlayer);
		this.firstPlayer = firstPlayer;
			
		this.thePair = new DicePair();
	}
	
	/**
	 * Resets the players for a new game.
	 */
	public void resetPlayers() {
		this.theComputer.resetPlayer();
		this.theHuman.resetPlayer();
		this.swapWhoseTurn();
	}
	
	/**
	 * Assigns GOAL_SCORE to new number
	 * @param newGoalScore the new score
	 */
	public void setGoalScore(int newGoalScore) {
		if (newGoalScore < 1) {
			throw new IllegalArgumentException("The goal score cannot be less than 1");
		}
		
		goalScore = newGoalScore;
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn();

		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);
		
		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {		
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}
	
	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		this.swapWhoseTurn();
		this.isGameOver();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}
	
	/**
	 * Returns the first player selected in the game.
	 * @return this.firstPlayer
	 */
	public Player getFirstPlayer() {
		return this.firstPlayer;
	}
	
	/**
	 * Returns Game.goalScore
	 * @return Game.goalScore
	 */
	public static int getGoalScore() {
		return goalScore;
	}
	
	/** 
	 * Returns the pair of dice being used in the game
	 * 
	 * @return	the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {	
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}
		
		if (this.theHuman.getTotal() >= goalScore
				|| this.theComputer.getTotal() >= goalScore) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a String showing the goal score, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {	
		String result = "Goal Score: " + goalScore;
		result += System.getProperty("line.separator")
				+ this.theHuman.getName() + ": "
				+ this.theHuman.getTotal();
		result += System.getProperty("line.separator")
				+ this.theComputer.getName() + ": "
						+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= goalScore) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= goalScore) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	private void swapWhoseTurn() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		if (currentPlayer == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else {
			this.currentPlayerObject.setValue(this.theHuman);
		}
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
	
}
