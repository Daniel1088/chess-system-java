package BoardGame;

public class Position {
	private int row;
	private int colum;
	public Position(int row, int colums) {
		
		this.row = row;
		this.colum = colums;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColums() {
		return colum;
	}
	public void setColums(int colums) {
		this.colum = colums;
	}
	
	@Override
	public String toString()
	{
		return row+" ,"+colum;
	}
	

}
