package edu.westga.cs6910.pig.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Defines the alert box that explains
 * the rules of Pig to the user.
 * 
 * @author Brandon Drick
 * @version 6/29/2021
 */
public class RulesBox {
	
	/**
	 * 0-param constructor for RulesBox
	 */
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Pig: Rules");
		
		Label header = new Label("Rules");
		header.setStyle("-fx-font-weight: bold");
		
		Text rules = new Text("The goal of Pig is to roll your dice to try "
				+ "\nand achieve the goal score before your opponent."
				+ "\n\n• You can keep rolling until you roll a 1 or hold"
				+ "\n• With each roll, your turn score accumulates - holding ends your turn"
				+ "\n• Rolling a 1 ends your turn and forfeits accumulated points");
		rules.setTextAlignment(TextAlignment.CENTER);
		
		Button closeButton = new Button("Got it!");
		closeButton.setOnAction(e -> window.close());
		
		VBox boxContent = new VBox(10, header, rules, closeButton);
		boxContent.setAlignment(Pos.CENTER);
		Scene boxScene = new Scene(boxContent, 500, 250);
		window.setScene(boxScene);
		window.showAndWait();
	} 
}
