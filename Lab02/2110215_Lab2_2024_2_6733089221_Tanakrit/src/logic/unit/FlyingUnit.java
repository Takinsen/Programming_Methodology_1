package logic.unit;

public class FlyingUnit extends BaseUnit {

	public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.hp = 2;
		this.isFlying = true;
	}

	@Override
	public boolean move(int direction) {
		if (direction == 0 && getRow() + 2 <= 4) {
			this.setRow(getRow() + 2);
			return true;
		} else if (direction == 1 && getColumn() + 2 <= 4) {
			this.setColumn(getColumn() + 2);
			return true;
		} else if (direction == 2 && getRow() - 2 >= 0) {
			this.setRow(getRow() - 2);
			return true;
		} else if (direction == 3 && getColumn() - 2 >= 0) {
			this.setColumn(getColumn() - 2);
			return true;
		}
		return false;
	}

}
