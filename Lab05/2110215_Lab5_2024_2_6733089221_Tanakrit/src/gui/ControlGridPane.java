package gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox {
	private final String miningImageURL;
	private ControlPane controlPane;

	public ControlGridPane(ControlPane controlPane) {
		super();
		this.controlPane = controlPane;
		this.miningImageURL = "bitcoin.png";
		ImageView iv = new ImageView(getClass().getResource(miningImageURL).toExternalForm());
		iv.setFitWidth(150);
		iv.setFitHeight(150);
		BorderPane borderPane = new BorderPane();
		borderPane.setPrefWidth(150);
		borderPane.setPrefHeight(200);
		borderPane.setCenter(iv);
		this.getChildren().addAll(borderPane, controlPane);

	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}

	public String getMiningImageURL() {
		return miningImageURL;
	}

}
