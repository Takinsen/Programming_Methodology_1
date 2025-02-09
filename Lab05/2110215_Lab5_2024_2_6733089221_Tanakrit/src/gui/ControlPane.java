package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {
	
    private MineSweeperPane mineSweeperPane;
    private Text gameText;
    private Button newGameButton;
    private Button secureModeButton;

    public ControlPane(MineSweeperPane mineSweeperPane) {
       this.mineSweeperPane = mineSweeperPane;
        //TODO
       this.setAlignment(Pos.CENTER);
       this.setPrefWidth(300);
       this.setSpacing(20);
       this.initializeGameText();
       this.initializeNewGameButton();
       this.initializeSecureModeButton();      
//       add 
       this.getChildren().addAll(gameText,newGameButton,secureModeButton);
    }
    
    private void initializeGameText() {
    	this.gameText = new Text("Tiles left : " + GameLogic.getInstance().getTileCount()) ;
    	this.gameText.setStyle("-fx-font-size: 35");
    }
    
    public void updateGameText(String text) {
    	this.gameText.setText(text);
    }
    
    private void initializeNewGameButton() {
    	newGameButton = new Button("New Game") ;
    	newGameButton.setPrefWidth(100);
    	newGameButton.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			newGameButtonHandler();
    		}
    	});
    }
    
    private void initializeSecureModeButton() {
    	secureModeButton = new Button("Secure mode : OFF");
    	secureModeButton.setPrefWidth(150);
    	secureModeButton.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			secureModeButtonHandler() ;
    		}
    	});
    } 
    
    private void newGameButtonHandler() {
//    	reset game
    	GameLogic.getInstance().newGame();
//    	set secureModebutton to Secure mode : OFF
    	this.secureModeButton.setText("Secure mode : OFF");
//   	set game text
    	this.gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
//    	reset all cell
    	for(MineSweeperSquare sp : mineSweeperPane.getAllCells()) {
    		sp.initializeCellColor();
    	} 
    }
    
    private void secureModeButtonHandler() {
    	GameLogic.getInstance().toggleSecureMode();
    	if(!GameLogic.getInstance().isSecureMode()) {
    		secureModeButton.setText("Secure mode : OFF");
    	}
    	else {
    		secureModeButton.setText("Secure mode : ON");
    	}
    }

}
