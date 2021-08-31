package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Defines a GUI for the Pig game.
 * This class was started by CS6910
 * 
 * @author Brandon Drick
 * @version 6/4/2021
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	private MenuPane pnMenuBar;
	private boolean displayRules;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;
		this.displayRules = true;
		
		this.pnContent = new BorderPane();
		
		this.createBoard(theGame);
		this.setCenter(this.pnContent);
		
		PigPane.this.pnComputerPlayer.setDisable(true);
		PigPane.this.pnHumanPlayer.setDisable(true);
	}
	
	private void createBoard(Game theGame) {
		this.addMenuPane(theGame);
		this.addFirstPlayerChooserPane(theGame);
		this.addHumanPlayerStatusPane(theGame);
		this.addComputerPlayerStatusPane(theGame);
		this.addGameStatusPane(theGame);
	}
	
	/**
	 * Returns a pane for exiting the game,
	 * or altering the computer player strategy.
	 */
	private void addMenuPane(Game theGame) {
		this.pnMenuBar = new MenuPane(theGame);
		VBox menuBox = new VBox(this.pnMenuBar);
		super.setTop(menuBox);
	}
	
	/**
	 * Returns a pane for choosing the first player.
	 * @param theGame the domain model object representing the Pig game
	 */
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox selectBox = new HBox();
		selectBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		selectBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(selectBox);
	}
	
	/**
	 * Creates a pane with information about the human player.
	 * @param theGame the domain model object representing the Pig game
	 */
	private void addHumanPlayerStatusPane(Game theGame) {
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");	
		this.pnHumanPlayer = new HumanPane(theGame);
		humanBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(humanBox);
	}
	
	/**
	 * Creates a pane with information about the computer player.
	 * @param theGame the domain model object representing the Pig game
	 */
	private void addComputerPlayerStatusPane(Game theGame) {
		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");	
		this.pnComputerPlayer = new ComputerPane(theGame);
		computerBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(computerBox);
	}
	
	/**
	 * Creates a pane with information about the 
	 * current game of Pig.
	 * @param theGame the domain model object representing the Pig game
	 */
	private void addGameStatusPane(Game theGame) {
		HBox gameBox = new HBox();
		gameBox.getStyleClass().add("pane-border");	
		this.pnGameInfo = new StatusPane(theGame);
		gameBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(gameBox);
	}
	
	/**
	 * Displays the rules
	 */
	private void showRules() {
		if (this.displayRules) {
			RulesBox.display();
		}
	}
	
	/**
	 * Defines the pane in which the user can exit the game,
	 * or alter the computer player strategy.
	 */
	private final class MenuPane extends BorderPane {
		private MenuBar gameMenuBar;
		private Menu gameMenu;
		private Menu strategyMenu;
		
		private Game theGame;
		private ComputerPlayer theComputer;
		
		private MenuPane(Game theGame) {
			this.theGame = theGame;
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.gameMenuBar = new MenuBar();
			
			this.gameMenu = new Menu("_Game");
			this.gameMenu.setMnemonicParsing(true);
		    MenuItem newGameMenuItem = this.createNewGameMenuItem();
		    CheckMenuItem rulesMenuItem = this.createRulesMenuItem();
		    MenuItem exitMenuItem = this.createExitMenuItem();
		    this.gameMenu.getItems().addAll(newGameMenuItem, rulesMenuItem, exitMenuItem);
		    
		    this.strategyMenu = new Menu("_Strategy");
		    this.strategyMenu.setMnemonicParsing(true);
		    RadioMenuItem cautiousMenuItem = this.createCautiousMenuItem(this.theComputer);
		    RadioMenuItem greedyMenuItem = this.createGreedyMenuItem(this.theComputer);
		    RadioMenuItem randomMenuItem = this.createRandomMenuItem(this.theComputer);
		    
		    ToggleGroup strategyMenu = new ToggleGroup();
		    cautiousMenuItem.setToggleGroup(strategyMenu);
		    greedyMenuItem.setToggleGroup(strategyMenu);
		    randomMenuItem.setToggleGroup(strategyMenu);
		    
		    this.strategyMenu.getItems().addAll(cautiousMenuItem, greedyMenuItem, randomMenuItem);
		    
		    this.gameMenuBar.getMenus().addAll(this.gameMenu, this.strategyMenu);
		    VBox menuBox = new VBox(this.gameMenuBar);
		    super.setTop(menuBox);
		}
		
		private MenuItem createNewGameMenuItem() {
			MenuItem newGameMenuItem = new MenuItem("_New Game");
			newGameMenuItem.setMnemonicParsing(true);
			newGameMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
			newGameMenuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Player firstPlayer = PigPane.this.theGame.getFirstPlayer();
					PigPane.this.theGame.resetPlayers();
					PigPane.this.theGame.startNewGame(firstPlayer);
					if (PigPane.this.displayRules) {
						RulesBox.display();
					}
				}
            });
			
			return newGameMenuItem;
		}
		
		private CheckMenuItem createRulesMenuItem() {
			CheckMenuItem rulesMenuItem = new CheckMenuItem("_Toggle rules");
			rulesMenuItem.setSelected(true);
			rulesMenuItem.setMnemonicParsing(true);
			rulesMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.T, KeyCombination.SHORTCUT_DOWN));
			rulesMenuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					PigPane.this.displayRules = !PigPane.this.displayRules;
				}
				
			});
			
			return rulesMenuItem;
		}
		
		private MenuItem createExitMenuItem() {
			MenuItem exitMenuItem = new MenuItem("E_xit");
		    exitMenuItem.setMnemonicParsing(true);
		    exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
		    exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);					
				}
            });
		    
		    return exitMenuItem;
		}
		
		private RadioMenuItem createCautiousMenuItem(ComputerPlayer theComputer) {
		    RadioMenuItem cautiousMenuItem = new RadioMenuItem("_Cautious");
		    cautiousMenuItem.setMnemonicParsing(true);
		    cautiousMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN));
		    cautiousMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
				public void handle(ActionEvent event) {
					CautiousStrategy cautiousStrategy = new CautiousStrategy();
					theComputer.setStrategy(cautiousStrategy);				
				}
            });
		    
		    return cautiousMenuItem;
		}
		
		private RadioMenuItem createGreedyMenuItem(ComputerPlayer theComputer) {
			RadioMenuItem greedyMenuItem = new RadioMenuItem("Gr_eedy");
		    greedyMenuItem.setMnemonicParsing(true);
		    greedyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN));
		    greedyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
				public void handle(ActionEvent event) {
		    		GreedyStrategy greedyStrategy = new GreedyStrategy();
					theComputer.setStrategy(greedyStrategy);				
				}
            });
		    
		    return greedyMenuItem;
		}
		
		private RadioMenuItem createRandomMenuItem(ComputerPlayer theComputer) {
			RadioMenuItem randomMenuItem = new RadioMenuItem("_Random");
		    randomMenuItem.setMnemonicParsing(true);
		    randomMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
		    randomMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
				public void handle(ActionEvent event) {
		    		RandomStrategy randomStrategy = new RandomStrategy();
					theComputer.setStrategy(randomStrategy);
				}
            });
		    
		    return randomMenuItem;
		}
	}
	
	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		private RadioButton radRandomSelect;
		private Button gameScoreSetterButton;
		private TextField gameScoreInputField;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton("Simple computer first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			this.radRandomSelect = new RadioButton("Random first player");
			this.radRandomSelect.setOnAction(new RandomFirstListener());
			
			ToggleGroup firstChoiceGroup = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(firstChoiceGroup);
			this.radComputerPlayer.setToggleGroup(firstChoiceGroup);
			this.radRandomSelect.setToggleGroup(firstChoiceGroup);

			HBox firstChoiceBox = new HBox(20, this.radHumanPlayer, this.radComputerPlayer, this.radRandomSelect);
			firstChoiceBox.getStyleClass().add("box-padding");
			firstChoiceBox.getStyleClass().add("box-center");
			
			this.gameScoreInputField = new TextField("20");
			this.gameScoreSetterButton = new Button("Set score");
			this.gameScoreSetterButton.setOnAction(new ScoreSetterListener());
			HBox scoreSetterBox = new HBox(10, this.gameScoreInputField, this.gameScoreSetterButton);
			scoreSetterBox.getStyleClass().add("box-padding");
			scoreSetterBox.getStyleClass().add("box-center");

			super.add(firstChoiceBox, 0, 0, 6, 1);
			super.add(scoreSetterBox, 3, 1);
		}
		
		/** 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
				PigPane.this.showRules();
			}
		}

		/** 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/** 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
				PigPane.this.showRules();
			}
		}
		
		/**
		 * Defines the listener for the random first player button.
		 */
		private class RandomFirstListener implements EventHandler<ActionEvent> {
			/**
			 * Sets up user interface and starts a new game.
			 * Event handler for a click in the random player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				if (Math.random() > 0.5) {
					NewGamePane.this.radComputerPlayer.setSelected(true);
					PigPane.this.pnComputerPlayer.setDisable(false);
					PigPane.this.pnChooseFirstPlayer.setDisable(true);
					PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
					PigPane.this.showRules();
				} else {
					NewGamePane.this.radHumanPlayer.setSelected(true);
					PigPane.this.pnHumanPlayer.setDisable(false);
					PigPane.this.pnChooseFirstPlayer.setDisable(true);
					PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
					PigPane.this.showRules();
				}
			}
		}
		
		private class ScoreSetterListener implements EventHandler<ActionEvent> {
			/**
			 * Sets the goal score for the game
			 */
			@Override
			public void handle(ActionEvent event) {
				try {
					String setValue = NewGamePane.this.gameScoreInputField.getText();
					int goalScore = Integer.parseInt(setValue);
					this.updateScore(goalScore);
				} catch (NumberFormatException nfe) {
					this.updateScore(20);
				} catch (IllegalArgumentException iae) {
					this.updateScore(20);
				}
			}
			
			private void updateScore(int score) {
				PigPane.this.theGame.setGoalScore(score);
				PigPane.this.pnGameInfo.setStatus(PigPane.this.theGame.toString());
			}
		}
	}
}
