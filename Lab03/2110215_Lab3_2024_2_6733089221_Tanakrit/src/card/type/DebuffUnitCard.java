package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {
	private int debuffPower;

	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name, flavorText, bloodCost, power, health);
		setDebuffPower(debuffPower);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		unitCard.setPower(unitCard.getPower() - debuffPower);
		return attackUnit(unitCard);
	}

	public int getDebuffPower() {
		return debuffPower;
	}

	public void setDebuffPower(int debuffPower) {
		this.debuffPower = debuffPower < 0 ? 0 : debuffPower;
	}

}
