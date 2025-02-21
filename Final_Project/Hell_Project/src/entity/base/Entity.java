package entity.base;

public abstract class Entity {
	protected int gridX, gridY;

	// Constructor

	public Entity(int x, int y) {
		this.setGridX(x);
		this.setGridY(y);
	}

	// Getters & Setters

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX < 0 ? 0 : gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int posY) {
		this.gridY = gridY < 0 ? 0 : gridY;
	}

	// Abstract Method
	
	public abstract void destroy();

}
