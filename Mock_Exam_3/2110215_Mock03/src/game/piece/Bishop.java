package game.piece;

import java.util.Set;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

public class Bishop extends Piece {

	public Bishop(boolean isWhite, Position pos, Board board) {
		super(isWhite, pos, board);
		this.moved = super.isMoved();
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
		Bishop b = new Bishop(this.isWhite() , this.getPosition() , this.getBoard());
		b.setMoved(super.isMoved());
		return b;
	}

}
