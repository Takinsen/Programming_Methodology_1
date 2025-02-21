package ability;

import java.util.ArrayList;

import entity.base.Bullet;
import entity.base.Piece;

public class ShootCardinal extends Shoot {
	
	// Shoot bullets in Left , Right , Up , Down direction simultaneously

	public ShootCardinal(int bulletDamage, int bulletSpeed) {
		super(bulletDamage, bulletSpeed);
	}

	@Override
	public ArrayList<Bullet> createBullet(Piece shooter) {
		// TODO Auto-generated method stub
		ArrayList<Bullet> newBullets = new ArrayList<Bullet>();
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 1 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 2 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 3 , true));
		newBullets.add(new Bullet(shooter.getGridX(), shooter.getGridY() - 1, getBulletDamage(), getBulletSpeed() , 4 , true));
		return newBullets;
	}
	
}
