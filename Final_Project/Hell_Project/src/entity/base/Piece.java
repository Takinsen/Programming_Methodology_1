package entity.base;

import java.util.ArrayList;

import ability.Ability;
import ability.Shoot;
import logic.GameLogic;

public abstract class Piece extends Entity implements Relocatable {
	
	private int health;
	private boolean isDead;
	private static final int GRID_BOUNDARY = 15;
	protected ArrayList<Ability> ability;

	public Piece(Double x, Double y , int hp) {
		super(x, y);
		setHealth(hp);
		ability = new ArrayList<Ability>();
	}

	@Override
	public void moveUp() {
		if (gridY > 0)
			gridY--;
	}

	@Override
	public void moveDown() {
		if (gridY < GRID_BOUNDARY)
			gridY++;
	}

	@Override
	public void moveLeft() {
		if (gridX > 0)
			gridX--;
	}

	@Override
	public void moveRight() {
		if (gridX < GRID_BOUNDARY)
			gridX++;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	public void takeDamage(int damage) {
		this.setHealth(getHealth() - damage);
	}
	
	public void shootBullet() {
        // Get player's abilities
        ArrayList<Ability> shootAbilities = getAbility();

        for (Ability ability : shootAbilities) {
        	if(ability instanceof Shoot) {
        		ArrayList<Bullet> newBullets = ((Shoot) ability).createBullet(this);
        		GameLogic.getInstance().getBullets().addAll(newBullets);
        	}
        }
    }
	
	// Getters & Setters

	public int getHealth() {
		return health;
	}

	public void setHealth(int hp) {
		this.health = hp < 0 ? 0 : hp;
	}

	public ArrayList<Ability> getAbility() {
		return ability;
	}

	public void setAbility(ArrayList<Ability> ability) {
		this.ability = ability;
	}

	public boolean isDead() {
		return this.health <= 0;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	

}
