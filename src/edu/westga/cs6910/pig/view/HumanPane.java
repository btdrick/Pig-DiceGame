package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the panel that lets the user indicate whether they want to 
 * 	roll or hold on their turn
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class HumanPane extends GridPane implements InvalidationListener {
	private Label lblDiceValues;
	private Button btnRoll;
	private Button btnHold;
	private Label lblTurnTotal;
	
	private HumanPlayer theHuman;
	private Game theGame;

	/**
	 * Creates a new HumanPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public HumanPane(Game theGame) {
		this.theGame = theGame;
		this.theGame.addListener(this);
		
		this.theHuman = this.theGame.getHumanPlayer();
		
		this.buildPane();
	}
	
	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");	
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ " + this.theHuman.getName() + " ~~"));
		this.add(topBox, 0, 0, 2, 1);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");		
		middleBox.getChildren().add(new Label("Dice Values: "));
		this.lblDiceValues = new Label("-, -");
		middleBox.getChildren().add(this.lblDiceValues);
		this.add(middleBox, 0, 1);

		HBox buttonBox = new HBox();
		buttonBox.getStyleClass().add("box-padding");
		this.btnRoll = new Button("Roll");
		this.btnRoll.setOnAction(new TakeTurnListener());
		buttonBox.getChildren().add(this.btnRoll);
		
		this.btnHold = new Button("Hold");
		this.btnHold.setOnAction(new HoldListener());
		buttonBox.getChildren().add(this.btnHold);
		this.add(buttonBox, 0, 2);
		
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("box-padding");
		bottomBox.getChildren().add(new Label("Turn Total: "));
		this.lblTurnTotal = new Label("0");
		bottomBox.getChildren().add(this.lblTurnTotal);
		this.add(bottomBox, 0, 3);
	}

	@Override
	public void invalidated(Observable observable) {
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theHuman;

		int turnTotal = this.theHuman.getTurnTotal();
		String result = this.theHuman.getDiceValues();
		this.lblDiceValues.setText(result);
		this.lblTurnTotal.setText("" + turnTotal);
		
		this.setDisable(!myTurn);
		
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
	}

	private class TakeTurnListener implements EventHandler<ActionEvent> {
		/** 
		 * Tells the Game to have its current player (i.e., the human Player)
		 * take its turn.	
		 * 
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!HumanPane.this.theGame.isGameOver()) {
				HumanPane.this.theGame.play();
			}
		}
	}
	
	private class HoldListener implements EventHandler<ActionEvent> {
		/** 
		 * Tells the Game that its current player (i.e., the human Player)
		 * will be holding	
		 * 
		 */
		@Override
		public void handle(ActionEvent event) {
			if (!HumanPane.this.theGame.isGameOver()) {
				HumanPane.this.theGame.hold();
			}
		}
	}
}
