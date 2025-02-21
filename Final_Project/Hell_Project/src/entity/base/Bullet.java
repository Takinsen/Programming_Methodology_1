package entity.base;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends Entity implements Relocatable {
	private int damage;
	private double speed;
	private int direction;
	private boolean isPlayerBullet;
	private Rectangle icon;

	public Bullet(int posX, int posY, int damage, double speed, int direction , boolean isPlayerBullet) {
		super(posX, posY);
		this.icon = new Rectangle(10, 10, Color.RED);
		setDamage(damage);
		setSpeed(speed);
		setPlayerBullet(isPlayerBullet);
	}

	// Method

	public void move() {
		switch (this.direction) {
		case 1: {
			moveUp();
			break;
		}
		case 2: {
			moveDown();
			break;
		}
		case 3: {
			moveLeft();
			break;
		}
		case 4: {
			moveRight();
			break;
		}
		case 5: {
			moveUp();
			moveLeft();
			break;
		}
		case 6: {
			moveUp();
			moveRight();
			break;
		}
		case 7: {
			moveDown();
			moveLeft();
			break;
		}
		case 8: {
			moveDown();
			moveRight();
			break;
		}
		}
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		gridY -= speed;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		gridY += speed;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		gridX-=speed;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		gridX+=speed;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	// Getters & Setters

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage <= 0 ? 1 : damage;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed <= 0 ? 0.1 : speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isPlayerBullet() {
		return isPlayerBullet;
	}

	public void setPlayerBullet(boolean isPlayerBullet) {
		this.isPlayerBullet = isPlayerBullet;
	}

	public Rectangle getIcon() {
		return icon;
	}

	public void setIcon(Rectangle icon) {
		this.icon = icon;
	}
	
	public boolean isOffScreen() {
		return gridY <= 0 || gridY >= 15;
	}

}
