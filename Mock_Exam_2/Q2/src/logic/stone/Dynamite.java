package logic.stone;

import utils.GameUtilities;

public class Dynamite extends Stone {

	public Dynamite(int posX, int posY) {
		super(posX, posY);
	}

	public void destroy() {
		super.destroy();
		GameUtilities.removeStone(this);
		for (Stone s : GameUtilities.getAdjacentStones(posX, posY)) {
			s.destroy();
		}
	}

}
