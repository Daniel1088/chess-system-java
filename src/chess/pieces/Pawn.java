package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch=chessMatch;

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
			//#specialMove enpassant
			if(position.getRow()==3)
			{
				Position left= new Position(position.getRow(),position.getColums()-1);
				if(getBoard().positionExists(left) && isThereOponentPiece(left)&&getBoard().piece(left)==chessMatch.getenPassantVulnerable())
				{
					mat[left.getRow()-1][left.getColums()]=true;
				}
				Position right= new Position(position.getRow(),position.getColums()+1);
				if(getBoard().positionExists(right) && isThereOponentPiece(right)&&getBoard().piece(right)==chessMatch.getenPassantVulnerable())
				{
					mat[right.getRow()-1][right.getColums()]=true;
				}
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
			//#specialMove enpassant
			if(position.getRow()==4)
			{
				Position left= new Position(position.getRow(),position.getColums()-1);
				if(getBoard().positionExists(left) && isThereOponentPiece(left)&&getBoard().piece(left)==chessMatch.getenPassantVulnerable())
				{
					mat[left.getRow()+1][left.getColums()]=true;
				}
				Position right= new Position(position.getRow(),position.getColums()+1);
				if(getBoard().positionExists(right) && isThereOponentPiece(right)&&getBoard().piece(right)==chessMatch.getenPassantVulnerable())
				{
					mat[right.getRow()+1][right.getColums()]=true;
				}
			}

		}
		return mat;
	}
	
	public String toString()
	{
		return "P";
	}

}
