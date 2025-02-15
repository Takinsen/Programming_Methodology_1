package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {
	private MineSweeperPane mineSweeperPane;
	private Text gameText;
	private Button newGameButton;
	private Button secureModeButton;

	public ControlPane(MineSweeperPane mineSweeperPane) {
		super();
		this.mineSweeperPane = mineSweeperPane;
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		this.initializeGameText();
		this.initializeNewGameButton();
		this.initializeSecureModeButton();
		this.getChildren().addAll(gameText, newGameButton, secureModeButton);

	}

	private void initializeGameText() {
		gameText = new Text("Tiles left : " + GameLogic.getInstance().getTileCount());
		gameText.setStyle("-fx-font-size: 35");
	}

	public void updateGameText(String text) {
		gameText.setText(text);
	}

	private void initializeNewGameButton() {
		newGameButton = new Button("New Game");
		newGameButton.setPrefWidth(100);
		newGameButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				newGameButtonHandler();
			}
		});
	}

	private void initializeSecureModeButton() {
		secureModeButton = new Button("Secure mode : OFF");
		secureModeButton.setPrefWidth(150);
		secureModeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				secureModeButtonHandler();
			}
		});
	}

	private void newGameButtonHandler() {
		GameLogic.getInstance().newGame();
		secureModeButton.setText("Secure mode : OFF");
		gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
		for (MineSweeperSquare msq : mineSweeperPane.getAllCells()) {
			msq.initializeCellColor();
		}
	}

	private void secureModeButtonHandler() {
		GameLogic.getInstance().toggleSecureMode();
		if (!GameLogic.getInstance().isSecureMode()) {
			secureModeButton.setText("Secure mode : OFF");
		} else {
			secureModeButton.setText("Secure mode : ON");
		}
	}

	public Text getGameText() {
		return gameText;
	}

	public void setGameText(Text gameText) {
		this.gameText = gameText;
	}

	public Button getNewGameButton() {
		return newGameButton;
	}

	public void setNewGameButton(Button newGameButton) {
		this.newGameButton = newGameButton;
	}

	public Button getSecureModeButton() {
		return secureModeButton;
	}

	public void setSecureModeButton(Button secureModeButton) {
		this.secureModeButton = secureModeButton;
	}

	public MineSweeperPane getMineSweeperPane() {
		return mineSweeperPane;
	}

	public void setMineSweeperPane(MineSweeperPane mineSweeperPane) {
		this.mineSweeperPane = mineSweeperPane;
	}

}
