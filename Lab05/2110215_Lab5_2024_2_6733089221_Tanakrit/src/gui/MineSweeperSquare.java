package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane {

	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL;
	private final String oneURL;
	private final String mineURL;
	private final String flagURL;

	public MineSweeperSquare(int x, int y) {
		super();
		this.oURL = "o.png";
		this.oneURL = "one.png";
		this.mineURL = "mine.png";
		this.flagURL = "flag.png";
		this.setxPosition(x);
		this.setyPosition(y);
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setMinWidth(100);
		this.setMinHeight(100);
		this.setBaseColor(Color.MOCCASIN);
		this.initializeCellColor();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				onClickHandler();
			}
		});

	}

	public void onClickHandler() {
		boolean isGameEnd = GameLogic.getInstance().isGameEnd();
		boolean isSecureMode = GameLogic.getInstance().isSecureMode();
		SquareState boardState = GameLogic.getInstance().getBoardState()[xPosition][yPosition];
		SquareMark boardMark = GameLogic.getInstance().getBoardMark()[xPosition][yPosition];
		if (!isGameEnd) {
			
			if (!isSecureMode && boardState != SquareState.REVEALED) {
				if (boardMark == SquareMark.ONE) {
					this.draw(new Image(getClass().getResourceAsStream(oneURL)), Color.ORANGE);
				} else if (boardMark == SquareMark.NOTHING) {
					this.draw(new Image(getClass().getResourceAsStream(oURL)), Color.YELLOW);
				} else if (boardMark == SquareMark.MINE) {
					this.draw(new Image(getClass().getResourceAsStream(mineURL)), Color.RED);
				}
				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);
			} if (isSecureMode && boardState == SquareState.CONCEALED) {
				this.draw(new Image(getClass().getResourceAsStream(flagURL)), Color.GREEN);
				GameLogic.getInstance().updateState(xPosition, yPosition, 
SquareState.SECURED);
			}
			
		}
	}

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(100, 100, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
		this.isDrawn = true;
	}

	public void initializeCellColor() {
		BackgroundFill b = new BackgroundFill(baseColor, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(b));
		this.isDrawn = false;
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String getoURL() {
		return oURL;
	}

	public String getOneURL() {
		return oneURL;
	}

	public String getMineURL() {
		return mineURL;
	}

	public String getFlagURL() {
		return flagURL;
	}

}
