package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollums()];

		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColums());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColums());
			Position p2 = new Position(p.getRow() - 1, position.getColums());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPeace(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColums() - 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColums() + 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}
		} else {
			p.setValues(position.getRow() + 1, position.getColums());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColums());
			Position p2 = new Position(p.getRow() + 1, position.getColums());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPeace(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColums() - 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColums() + 1);
			if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
				mat[p.getRow()][p.getColums()] = true;
			}

		}
		return mat;
	}
	
	public String toString()
	{
		return "P";
	}

}
