package ability;

import java.util.ArrayList;

import entity.base.Bullet;
import entity.base.Entity;
import entity.base.Piece;

public class ShootStraight extends Shoot {

	public ShootStraight(int bulletDamage, double bulletSpeed) {
		super(bulletDamage, bulletSpeed);
	}
	
	@Override
	public ArrayList<Bullet> createBullet(Piece shooter) {
		// TODO Auto-generated method stub
		ArrayList<Bullet> newBullets = new ArrayList<Bullet>();
		newBullets.add(new Bullet(shooter.getGridX() + centerOffset , shooter.getGridY() + centerOffset, getBulletDamage(), getBulletSpeed() , 1 , true));
		System.out.println("Bullet Created at " + "( " + shooter.getGridX() + ", " + shooter.getGridY() + " )");
		return newBullets;
	}

}
