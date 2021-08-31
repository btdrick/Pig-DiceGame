package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the pane that lets the user either roll or hold during
 * 	their turn
 * This class was started by CS6910
 * 
 * @author Brandon Drick
 * @version 6/6/2021
 */
public class ComputerPane extends GridPane implements InvalidationListener {
	private Label lblDiceValues;
	private Label lblTurnTotal;
	private Button btnTakeTurn;
	
	private ComputerPlayer theComputer;
	private Game theGame;

	/**
	 * Creates a new ComputerPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		this.theGame.addListener(this);
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPane();
	}
	
	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");	
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ Simple Computer ~~"));
		this.add(topBox, 0, 0, 2, 1);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");		
		middleBox.getChildren().add(new Label("Dice Values: "));
		this.lblDiceValues = new Label("-, -");
		middleBox.getChildren().add(this.lblDiceValues);
		this.add(middleBox, 0, 1);

		HBox buttonBox = new HBox();
		buttonBox.getStyleClass().add("box-padding");
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
		buttonBox.getChildren().add(this.btnTakeTurn);
		this.add(buttonBox, 0, 2);
		
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("box-padding");
		bottomBox.getChildren().add(new Label("Turn Total: "));
		this.lblTurnTotal = new Label("0");
		bottomBox.getChildren().add(this.lblTurnTotal);
		this.add(bottomBox, 0, 3);
	}

	@Override
	public void invalidated(Observable theObservable) {
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		
		int turnTotal = this.theComputer.getTurnTotal();
		String result = this.theComputer.getDiceValues();
		this.lblDiceValues.setText(result);
		this.lblTurnTotal.setText("" + turnTotal);

		this.setDisable(!myTurn);
		
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
	}

	/** 
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/** 
		 * Tells the Game to have its current player (i.e., the computer player)
		 * take its turn.	
		 * 
		 * @see javafx.event.EventHandler handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			if (!ComputerPane.this.theGame.isGameOver()) {
				ComputerPane.this.theComputer.setMaximumRolls();
				ComputerPane.this.theGame.play();
			}
		}
	}
}
