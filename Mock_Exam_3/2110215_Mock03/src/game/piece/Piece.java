package game.piece;

import java.util.Objects;
import java.util.Set;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

public class Piece {
	protected boolean white;
	protected boolean moved;
	protected Position position;
	protected Board board;

	public Piece(boolean white, Position position, Board board) {
		this.white = white;
		this.position = position;
		this.board = board;
		board.placePiece(this, position);
	}

	public boolean isWhite() {
		return white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	// Method

	public Set<Position> getLegalMove() {
		Movement mv = new Movement(position, board);
		mv.getMovePositions(this);
		return mv.getMoves();
	}

	public Object deepCopy() {
		return new Piece(this.isWhite() , this.getPosition() , this.getBoard());
	}

	public void moveHandle(Position to) {
		this.hadMoved();
		this.setPosition(to);
	}

	public void hadMoved() {
		this.moved = true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " ( " + this.getPosition() + " ) ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(board, other.board) && moved == other.moved && Objects.equals(position, other.position)
				&& white == other.white;
	}

}
