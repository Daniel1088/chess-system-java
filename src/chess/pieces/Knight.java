package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
	
	public Knight(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "N";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollums()];
		Position p = new Position(0, 0);

		
		p.setValues(position.getRow() - 1, position.getColums()-2);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow() -2, position.getColums()-1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow()-2, position.getColums() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow()-1, position.getColums() + 2);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow() + 1, position.getColums() + 2);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow() +2, position.getColums() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow() + 2, position.getColums() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		
		p.setValues(position.getRow() + 1, position.getColums() - 2);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		
		return mat;

	}
}
