package BoardGame;

public class Position {
	private int row;
	private int column;
	public Position(int row, int colums) {
		
		this.row = row;
		this.column = colums;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColums() {
		return column;
	}
	public void setColums(int colums) {
		this.column = colums;
	}
	
	public void setValues(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString()
	{
		return row+" ,"+column;
	}
	

}
