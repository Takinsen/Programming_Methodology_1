package logic.stone;

import logic.game.GameManager;

public class Gear extends HardStone {
	private int upgradeValue;

	public Gear(int posX, int posY) {
		super(posX, posY, 2);
		this.upgradeValue = 1;
	}

	public Gear(int posX, int posY, int upgradeValue) {
		super(posX, posY, 2);
		setUpgradeValue(upgradeValue);
	}

	public int getUpgradeValue() {
		return upgradeValue;
	}

	public void setUpgradeValue(int upgradeValue) {
		this.upgradeValue = upgradeValue < 1 ? 1 : upgradeValue;
	}

	public void destroy() {
		GameManager.getInstance().addDigPower(upgradeValue);
		super.destroy();
	}

}
