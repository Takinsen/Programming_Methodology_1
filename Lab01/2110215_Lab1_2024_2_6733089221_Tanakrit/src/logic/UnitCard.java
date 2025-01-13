package logic;

import java.util.Objects;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);

	}

	public void attack(UnitCard other) {

	}

	// Getter , Setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Creature";
		} else {
			this.name = name;
		}
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = (bloodCost < 0 ? 0 : bloodCost);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = (power < 0 ? 0 : power);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = (health < 1 ? 1 : health);
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitCard other = (UnitCard) obj;
		return Objects.equals(name, other.name);
	}

	// toString()

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
