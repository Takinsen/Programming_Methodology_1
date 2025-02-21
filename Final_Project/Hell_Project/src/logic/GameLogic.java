package logic;

import entity.base.*;
import entity.piece.*;
import entity.player.Player;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    // ✅ Static instance (Singleton-like)
    private static GameLogic instance;

    private Player player;
    private ArrayList<Piece> enemies;
    private ArrayList<Bullet> bullets;
    private boolean isRunning;

    private GameLogic() {
        player = new Player(8, 15 , 100); // Start position
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        isRunning = true;
        spawnEnemies();
    }

    // ✅ Static method to get instance
    public static GameLogic getInstance() {
        if (instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

    private void spawnEnemies() {
        enemies.add(new Pawn(8, 0 , 20)); // Example enemy
    }

    public void playerShoot() {
        player.shootBullet();
    }

    public void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGame();
            }
        }.start();
    }

    private void updateGame() {
        if (!isRunning) return;

        ArrayList<Bullet> toRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getGridY() < 0) {
                toRemove.add(bullet);
            }
        }
        bullets.removeAll(toRemove);
        checkCollisions();
    }

    private void checkCollisions() {
    	ArrayList<Piece> deadEnemies = new ArrayList<>();
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();

        for (Bullet bullet : bullets) {
            for (Piece enemy : enemies) {
                if (bullet.getGridX() == enemy.getGridX() && bullet.getGridY() == enemy.getGridY()) {
                    enemy.takeDamage(bullet.getDamage());
                    bulletsToRemove.add(bullet);
                    if (enemy.isDead()) {
                        deadEnemies.add(enemy);
                    }
                }
            }
        }
        enemies.removeAll(deadEnemies);
        bullets.removeAll(bulletsToRemove);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Piece> getEnemies() {
        return enemies;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
