package logic;

import java.util.ArrayList;
import java.util.List;

import entity.bullet.Bullet;
import javafx.scene.canvas.GraphicsContext;

public class BulletSpawner {
	private List<Bullet> bullets = new ArrayList<>();
	private double spawnTimer = 0;
	private double x = 100;
	private double speedX = 100;

	public void update(double timeElapsed) {
		spawnTimer += timeElapsed;
		if (spawnTimer > 0.5) { // Spawn bullets every 0.5 sec
			if (x + speedX > 750 || x + speedX < 50)
				speedX *= -1;
			x+=speedX;
			spawnCirclePattern(x);
			spawnTimer = 0;
		}

		bullets.forEach(Bullet::update);
		bullets.removeIf(b -> b.y > 600 || b.y < 0 || b.x > 800 || b.x < 0);
	}

	public void render(GraphicsContext gc) {
		bullets.forEach(b -> b.draw(gc));
	}

	private void spawnCirclePattern(double X) {
		double bossX = X, bossY = 100; // Boss position
		bullets.add(new Bullet(bossX, bossY, Math.toRadians(90), 3));
//		for (int i = 0; i < 12; i++) {
//			double angle = Math.toRadians(i * 30); // 30° increments
//			bullets.add(new Bullet(bossX, bossY, angle, 3));
//		}
	}
}
