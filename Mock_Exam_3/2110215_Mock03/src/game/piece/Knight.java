package game.piece;

import java.util.Set;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

public class Knight extends Piece {

	public Knight(boolean isWhite, Position pos, Board board) {
		super(isWhite, pos, board);
	}

	@Override
	public Set<Position> getLegalMove() {
		// TODO Auto-generated method stub
		Movement mv = new Movement(position, board);
		mv.getMovePositions(this);
		return mv.getMoves();
	}

	@Override
	public Object deepCopy() {
		// TODO Auto-generated method stub
		Knight k = new Knight(this.isWhite() , this.getPosition() , this.getBoard());
		k.setMoved(super.isMoved());
		return k;
	}

}
