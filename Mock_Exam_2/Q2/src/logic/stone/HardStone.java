package logic.stone;

public class HardStone extends Stone {
	protected int durability;

	public HardStone(int posX, int posY, int durability) {
		super(posX, posY);
		setDurability(durability);
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		if (durability >= 0 && durability <= 5) {
			this.durability = durability;
		} else if (durability < 0) {
			this.durability = 0;
		} else if (durability > 5) {
			this.durability = 5;
		}
	}

	public void dig(int digPower) {
		setDurability(this.getDurability() - digPower);
		if (getDurability() <= 0) {
			this.destroy();
		}
	}

}
