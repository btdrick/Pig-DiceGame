package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the pane that lets the user tell the computer player to
 * take its turn and that displays the die values the computer
 * player took on its turn.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class StatusPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblStatus;
	
	/**
	 * Creates a new status pane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public StatusPane(Game theGame) {
		this.theGame = theGame;
		
		this.theGame.addListener(this);
		
		this.buildPane();
	}
	
	/**
	 * Sets new text for the status pane
	 * @param newText updated info
	 */
	public void setStatus(String newText) {
		if (newText.length() < 1) {
			throw new IllegalArgumentException("Status cannot be empty");
		}
		this.lblStatus.setText(newText);
	}

	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");	
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ Game Info ~~"));
		this.add(topBox, 0, 0);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");
		this.lblStatus = new Label(this.theGame.toString());
		middleBox.getChildren().add(this.lblStatus);
		this.add(middleBox, 0, 1);
	}

	@Override
	public void invalidated(Observable observable) {
		this.setStatus(this.theGame.toString());
	}
}
