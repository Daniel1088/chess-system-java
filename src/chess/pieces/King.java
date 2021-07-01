package chess.pieces;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position)
	{
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount()==0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollums()];
		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColums());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColums());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColums() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColums() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColums() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColums() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColums() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}

		// se
		p.setValues(position.getRow() + 1, position.getColums() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColums()] = true;
		}
		// Special Move castling
		if (getMoveCount()==0 && !chessMatch.getcheck())
		{
			//#Special move castling Kingside rook
			Position posT1 = new Position(position.getRow(),position.getColums()+3);
			if(testRookCastling(posT1))
			{
				Position p1 = new Position(position.getRow(),position.getColums()+1);
				Position p2 = new Position(position.getRow(),position.getColums()+2);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null)
				{
					mat[position.getRow()][position.getColums()+2]=true;
				}
			}
			//#Special move castling queenside rook
			Position posT2 = new Position(position.getRow(),position.getColums()-4);
			if(testRookCastling(posT2))
			{
				Position p1 = new Position(position.getRow(),position.getColums()-1);
				Position p2 = new Position(position.getRow(),position.getColums()-2);
				Position p3 = new Position(position.getRow(),position.getColums()-3);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null)
				{
					mat[position.getRow()][position.getColums()-2]=true;
				}
			}
		}
		return mat;

	}
}
