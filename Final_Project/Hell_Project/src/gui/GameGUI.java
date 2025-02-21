package gui;

import entity.base.*;
import entity.player.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameLogic;

public class GameGUI extends Application {

	private static final int BOARD_SIZE = 16;
    private static final int TILE_SIZE = 40;
    private static final int WIDTH = BOARD_SIZE * TILE_SIZE;
    private static final int HEIGHT = BOARD_SIZE * TILE_SIZE;
    
    private GameLogic game;
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {
    	game = GameLogic.getInstance();
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        
        // Handle player input
        scene.setOnKeyPressed(event -> {
            Player player = game.getPlayer();
            switch (event.getCode()) {
                case UP:
                    player.moveUp();
                    break;
                case DOWN:
                    player.moveDown();
                    break;
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveRight();
                    break;
                case SPACE:
                    game.playerShoot();
                    break;
                default:
                    break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("What the Hell is This Chess?");
        primaryStage.show();

        // Start game loop
        game.startGameLoop();
        render();
    }

    private void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                drawChessBoard();
                drawEntities();
            }
        }.start();
    }

    // ♟️ Draw a proper 16x16 chessboard
    private void drawChessBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    gc.setFill(Color.LIGHTGRAY);
                } else {
                    gc.setFill(Color.DARKGRAY);
                }
                gc.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    // 🔫 Draw player, enemies, bullets
    private void drawEntities() {
        Player player = game.getPlayer();
        gc.setFill(Color.BLUE);
        gc.fillRect(player.getGridX() * TILE_SIZE, player.getGridY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        gc.setFill(Color.RED);
        for (Piece enemy : game.getEnemies()) {
            gc.fillRect(enemy.getGridX() * TILE_SIZE, enemy.getGridY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        gc.setFill(Color.YELLOW);
        for (Bullet bullet : game.getBullets()) {
            gc.fillOval(bullet.getGridX() * TILE_SIZE, bullet.getGridY() * TILE_SIZE, TILE_SIZE / 3, TILE_SIZE / 3);
        }
    }
}
