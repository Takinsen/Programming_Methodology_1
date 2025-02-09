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

public class MineSweeperSquare extends Pane{
	
	private boolean isDrawn ;
	private Color baseColor ;
	private int xPosition ;
	private int yPosition ;
	private final String oURL ;
	private final String oneURL ;
	private final String mineURL ;
	private final String flagURL ;
	
//	constructor
	public MineSweeperSquare(int x , int y) {
		this.oURL = "o.png" ;
		this.oneURL = "one.png" ;
		this.mineURL = "mine.png" ;
		this.flagURL = "flag.png" ;
		this.setxPosition(x);
		this.setyPosition(y);
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setBaseColor(Color.MOCCASIN);
		this.initializeCellColor();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onClickHandler();
			}
		});
	}
	
	
	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		//TODO
		this.setisDrawn(true);
	}
	
	private void onClickHandler() {
		if(!GameLogic.getInstance().isGameEnd()) {
			int xpos = this.getxPosition() ;
			int ypos = this.getyPosition() ;
			SquareState sState = GameLogic.getInstance().getBoardState()[xpos][ypos] ;
//			not secure mode and square not reveal (not draw)
//			Caution: Even a square has been secured, if it is clicked while 
//			the secure mode is off, it will make the square revealed. 
			if(!GameLogic.getInstance().isSecureMode() && 
				(sState == SquareState.CONCEALED || sState == SquareState.SECURED)) {
				//
				SquareMark mState = GameLogic.getInstance().getBoardMark()[xpos][ypos] ;
				
				if(mState == SquareMark.ONE) {
					this.draw(new Image(getClass().getResourceAsStream(getOneURL())), Color.ORANGE);
				}
				else if(mState == SquareMark.NOTHING) {
					this.draw(new Image(getClass().getResourceAsStream(getoURL())), Color.YELLOW);
				}
				else if(mState == SquareMark.MINE) {
					this.draw(new Image(getClass().getResourceAsStream(mineURL)), Color.RED);
				}
//				update state
				GameLogic.getInstance().updateState(xpos, ypos,SquareState.REVEALED );
			}
//			secure mode and square not reveal (not draw)
			else if(GameLogic.getInstance().isSecureMode() &&
					sState == SquareState.CONCEALED) {
				
				this.draw(new Image(getClass().getResourceAsStream(flagURL)), Color.GREEN);
//				update state
				GameLogic.getInstance().updateState(xpos, ypos,SquareState.SECURED );
			}
		}
	}
	
	public void initializeCellColor() {
		BackgroundFill bgColor = new BackgroundFill(baseColor, CornerRadii.EMPTY, Insets.EMPTY) ;
		this.setBackground(new Background(bgColor));
		this.setisDrawn(false);
	}

//	getter/setter
	public boolean isDrawn() {
		return isDrawn;
	}


	public void setisDrawn(boolean isDrawn) {
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
