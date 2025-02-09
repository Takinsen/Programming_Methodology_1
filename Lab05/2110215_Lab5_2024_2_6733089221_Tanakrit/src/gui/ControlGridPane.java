package gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox{
	
	private final String miningImageURL ;
	private ControlPane controlPane ;
	
	public ControlGridPane(ControlPane controlPane) {
		this.controlPane = controlPane ;
		this.miningImageURL = "bitcoin.png" ;
		ImageView img = new ImageView(getClass().getResource(miningImageURL).toExternalForm()) ;
		img.setFitWidth(150);
		img.setFitHeight(150);
		
		BorderPane bp = new BorderPane() ;
		bp.setPrefWidth(150);
		bp.setPrefHeight(200);
		bp.setCenter(img);
		this.getChildren().addAll(bp,this.controlPane);
	}
	
}
