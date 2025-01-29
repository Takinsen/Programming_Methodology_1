package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

	public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.hp = 2;
	}

	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit unit : targetPieces) {
			if (this.isWhite()) {
				if (this.getRow() + 1 <= 4 && unit.getRow() == this.getRow() + 1
						&& unit.getColumn() == this.getColumn()) {
					unit.setHp(unit.getHp() - this.getPower());
					System.out.println(this.getName() + " attacks " + unit.getName());
				}
			} else {
				if (this.getRow() - 1 >= 0 && unit.getRow() == this.getRow() - 1
						&& unit.getColumn() == this.getColumn()) {
					unit.setHp(unit.getHp() - this.getPower());
					System.out.println(this.getName() + " attacks " + unit.getName());
				}
			}
		}
	}

}
