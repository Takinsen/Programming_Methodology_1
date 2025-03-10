package ability;

import java.util.ArrayList;

import entity.base.Bullet;
import entity.base.Entity;
import entity.base.Piece;
import entity.piece.Pawn;
import entity.player.Player;
import gui.GameGUI;

public abstract class Shoot implements Ability {
	
	private int bulletDamage;
	private double bulletSpeed;
	protected static final double centerOffset = 0.3;
	
	// Constructor
	
	public Shoot(int bulletDamage, double bulletSpeed) {
		setBulletDamage(bulletDamage);
		setBulletSpeed(bulletSpeed);
	}
	
	// Methods

	@Override
	public void activate(Entity entity) {
		// TODO Auto-generated method stub
		if (entity instanceof Piece) {
			createBullet((Piece) entity);
        }

	}
	
	public abstract ArrayList<Bullet> createBullet(Piece shooter);

	// Getters & Setters

	public int getBulletDamage() {
		return bulletDamage;
	}

	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage <= 0 ? 1 : bulletDamage;
	}

	public double getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(double bulletSpeed) {
		this.bulletSpeed = bulletSpeed <= 0 ? 1 : bulletSpeed;
	}
	
}
