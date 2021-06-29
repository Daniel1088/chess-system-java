package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
	
	public Bishop(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollums()];

		Position p = new Position(0, 0);
		// nw
		p.setValues(position.getRow() - 1, position.getColums()-1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setValues(p.getRow()-1, p.getColums()-1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// ne 
		p.setValues(position.getRow()-1, position.getColums()+1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setValues(p.getRow()-1, p.getColums()+1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		//se
		p.setValues(position.getRow()+1, position.getColums()+1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setValues(p.getColums()+1, p.getColums()+1);;
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		//sw
		p.setValues(position.getRow() + 1, position.getColums()-1);

		while (getBoard().positionExists(p) && !getBoard().thereIsAPeace(p)) {
			mat[p.getRow()][p.getColums()] = true;
			p.setValues(p.getColums()+1, p.getColums()-1);
		}
		if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		return mat;
	}

}
