package main;

import gui.ControlGridPane;
import gui.ControlPane;
import gui.MineSweeperPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 HBox root = new HBox();
		 root.setPadding(new Insets(10));
		 root.setSpacing(10);
		 root.setPrefHeight(400);
		 root.setPrefWidth(800);
		 
		 MineSweeperPane msp = new MineSweeperPane() ;
		 ControlPane cp = new ControlPane(msp) ;
		 ControlGridPane cgp = new ControlGridPane(cp) ;
		 GameLogic.getInstance().setControlPane(cp);
		 
//		 add to MinseSweeperPane and ControlGridPane to root
		 root.getChildren().addAll(msp,cgp) ;
//		 create scene with root
		 Scene sc = new Scene(root) ;
		 primaryStage.setScene(sc);
		 primaryStage.setTitle("MineSweeper");
		 primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
