package entity.base;

import java.util.ArrayList;

import ability.Ability;
import ability.Shoot;
import gui.GameGUI;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import logic.GameLogic;

public abstract class Piece extends Entity implements Relocatable {

	private static final int GRID_BOUNDARY = GameGUI.getBoardSize() - 1;
	private int health;
	private boolean isDead;
	protected ImageView imageView;
	protected ArrayList<Ability> ability;

	public Piece(Double x, Double y, int hp) {
		super(x, y);
		setHealth(hp);
		ability = new ArrayList<Ability>();
	}

	public void takeDamage(int damage) {
		this.setHealth(getHealth() - damage);
	}

	public void shootBullet() {
		ArrayList<Ability> shootAbilities = getAbility();
		for (Ability ability : shootAbilities) {
			if (ability instanceof Shoot) {
				ArrayList<Bullet> newBullets = ((Shoot) ability).createBullet(this);
				GameLogic.getInstance().getBullets().addAll(newBullets);
			}
		}
	}

	public void updatePlayerPosition() {
		Platform.runLater(() -> {
	        imageView.setX(getGridX() * GameGUI.getTileSize());
	        imageView.setY(getGridY() * GameGUI.getTileSize());
	    });
	}

	@Override
	public void moveUp() {
		if (gridY > 0)
			gridY--;
		updatePlayerPosition();
	}

	@Override
	public void moveDown() {
		if (gridY < GRID_BOUNDARY)
			gridY++;
		updatePlayerPosition();
	}

	@Override
	public void moveLeft() {
		if (gridX > 0)
			gridX--;
		updatePlayerPosition();
	}

	@Override
	public void moveRight() {
		if (gridX < GRID_BOUNDARY)
			gridX++;
		updatePlayerPosition();
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

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
}