package BoardGame;

public class Board {
	private int rows;
	private int collums;

	private Piece[][] pieces;

	public Board(int rows, int collums) {
		if(rows<1 || collums<1)
		{
			throw new BoardException("Error Creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.collums = collums;
		pieces = new Piece[rows][collums];
	}

	public int getRows() {
		return rows;
	}

	

	public int getCollums() {
		return collums;
	}

	

	public Piece piece(int row, int collumn) {
		if(!positionExists(row,collumn))
		{
			throw new BoardException("Position not on the board");
		}
		return pieces[row][collumn];
	}

	public Piece piece(Position position) {
		if(!positionExists(position))
		{
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColums()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPeace(position))
		{
			throw new BoardException("There is already piece on position "+position);
		}
		pieces[position.getRow()][position.getColums()] = piece;
		piece.position = position;
	}

	public boolean positionExists(int row, int column) {
		return ((row >= 0) && (row < rows) && (column >= 0) && (column < collums));

	}

	public boolean positionExists(Position position)
	{
		return positionExists(position.getRow(),position.getColums());	
	}
	
	public boolean thereIsAPeace(Position position)
	{
		if(!positionExists(position))
		{
			throw new BoardException("Position not on the board");
		}
		return piece(position)!=null;
		
	}

}
