package BoardGame;

public class Piece {
	protected Position position;
	private Board board;

	public Piece(Board board) {

		this.board = board;
		position = null;
	}

	protected Board getBoard() {//Classes dentro do mesmo pacote e subclasse ter�o acesso a esse m�todo.
		return board;
	}

}
