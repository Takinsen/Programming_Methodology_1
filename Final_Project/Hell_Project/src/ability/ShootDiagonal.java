package ability;

import java.util.ArrayList;

import entity.base.Bullet;
import entity.base.Entity;
import entity.base.Piece;

public class ShootDiagonal extends Shoot {
	
	// Shoot bullets in all diagonal direction simultaneously
	
	public ShootDiagonal(int bulletDamage, int bulletSpeed) {
		super(bulletDamage, bulletSpeed);
	}
	
	@Override
	public ArrayList<Bullet> createBullet(Piece shooter) {
		// TODO Auto-generated method stub
		ArrayList<Bullet> newBullets = new ArrayList<Bullet>();
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 5 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 6 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 7 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 8 , true));
		return newBullets;
	}
	
}
