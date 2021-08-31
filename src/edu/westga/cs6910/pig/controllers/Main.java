package edu.westga.cs6910.pig.controllers;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.view.PigPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Driver for the application. Creates the GUI and shows it.
 * 
 * @author CS6910
 * @version Summer 2021
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CS6910: Simple Pig");
		Game theGame = new Game(new HumanPlayer("Human"), new ComputerPlayer(new CautiousStrategy()));

		PigPane root = new PigPane(theGame);
		Scene scene = new Scene(root, 700, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Entry point into the application
	 * 
	 * @param args
	 *            Not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}