package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollums()];

		Position p = new Position(0, 0);
		// above
		p.setValues(position.getRow() - 1, position.getColums());

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColums()-1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setColums(p.getColums()-1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		//right
		p.setValues(position.getRow(), position.getColums()+1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setColums(p.getColums()+1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		//below
		p.setValues(position.getRow() + 1, position.getColums());

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		return mat;
	}
}
