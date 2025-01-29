package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
	private int row;
	private int column;
	private boolean isWhite;
	private String name;
	protected int hp;
	protected int power;
	protected boolean isFlying;

	// Constructor

	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		this.setRow(startRow);
		this.setColumn(startColumn);
		this.setWhite(isWhite);
		this.setName(name);
		this.power = 1;
		this.isFlying = false;
		this.hp = 2;
	}

	// Method

	public boolean move(int direction) {
		if (direction == 0 && getRow() + 1 <= 4) {
			this.setRow(getRow() + 1);
			return true;
		} else if (direction == 1 && getColumn() + 1 <= 4) {
			this.setColumn(getColumn() + 1);
			return true;
		} else if (direction == 2 && getRow() - 1 >= 0) {
			this.setRow(getRow() - 1);
			return true;
		} else if (direction == 3 && getColumn() - 1 >= 0) {
			this.setColumn(getColumn() - 1);
			return true;
		}
		return false;
	}

	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit unit : targetPieces) {
			if (!unit.isFlying() && unit.getRow() == this.getRow()
					&& unit.getColumn() == this.getColumn()) {
				System.out.println(this.getName() + " attacks " + unit.getName());
				unit.setHp(unit.getHp() - this.getPower());
			}
		}
	}

	// Getters and Setters

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		if (row < 0) {
			this.row = 0;
		} else if (row > 4) {
			this.row = 4;
		} else {
			this.row = row;
		}
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		if (column < 0) {
			this.column = 0;
		} else if (column > 4) {
			this.column = 4;
		} else {
			this.column = column;
		}
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public boolean isFlying() {
		return isFlying;
	}

}
