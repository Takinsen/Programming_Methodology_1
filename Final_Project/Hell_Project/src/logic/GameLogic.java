package logic;

import entity.base.*;
import entity.piece.*;
import entity.player.Player;
import gui.GameGUI;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private static GameLogic instance;
    private Player player;
    private ArrayList<Piece> enemies;
    private ArrayList<Bullet> bullets;
    private boolean isRunning;

    private GameLogic() {
        player = new Player(1.0, 1.0 , 100); 
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        isRunning = true;
        spawnEnemies();
    }

    public static GameLogic getInstance() {
        if (instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

    private void spawnEnemies() {
        enemies.add(new Pawn(8.0, 0.0 , 20)); 
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
        
        if (GameGUI.isSpacebarPressed() && Math.abs(System.currentTimeMillis() - GameGUI.getLastShootTime()) >= GameGUI.getShootCooldown()) {
            player.shootBullet();
            GameGUI.setLastShootTime(System.currentTimeMillis());
        }
        
        ArrayList<Bullet> toRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getGridY() <= 0) {
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
