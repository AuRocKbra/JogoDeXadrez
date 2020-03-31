package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][]pieces;
	
	public Board(int rows, int columns) {
		if(rows <1 || columns<1) {
			throw new BoardException("Erro ao criar tabulerio: deve haver pelo menos 1 linha e 1 coluna!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Erro de posicionamento: está posição não existe!(Linha e coluna Board.class)");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro de posicionamento: está posição não existe!(position Board.class)");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Erro de posicionamento: já existe uma peca na posição "+position+" !(metodo placePiece Board.class)");
		}
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position = position;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean positionExists(int row, int column) {
		return row>=0 && row< rows && column >=0 && column < columns;
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro de posicionamento: está posição não existe!(metodo thereIsAPiece Board.class)");
		}
		return piece(position) !=null; 
	}
}
