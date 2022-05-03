import java.util.List;

class chess {
	Chessboard chessboard;
	Player[] players;
	Player currentPlayer;
	List<Move> movesList;
	GameStatus gameStatus;


	// APIs
	public boolean playerMove(CellPosition cellPosition, CellPosition otherPosition);
	public boolean endGame();
	public void changeTurn();
}

class Account {
	String name;
	String userName;
}

class Player {
	Account account;
	Color color;
	Time timeLeft; // this will be updated on changeTurn. 
}

class Time {
	int min;
	int sec;
}

public enum GameStatus {
	ACTIVE, DRAW, FORFEITED, BLACK_WIN, WHITE_WIN
}

class Chessboard {
	List<List<Cell>> chessboard;

	public boolean resetBoard();
	public boolean updateBoard(Move move);
}

class Cell {
	CellPosition cellPosition;
	Color color;
	Piece piece;
}

class CellPosition {
	int sequence;
	char ch;
}

public enum Color {
	WHITE, BLACK
}

public abstract class Piece {

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}

class King extends Piece {

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}
class Queen extends Piece {

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}
class Pawn extends Piece{

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}
class Knight extends Piece{

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}
class Rook extends Piece{

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}
class Bishop extends Piece {

	Color color;

	public boolean validateMove(CellPosition position, CellPosition destination);
	public List<Move> listofMoves getAllPossibleMoves(CellPosition fromCellPosition);
	public boolean makeMove(CellPosition position, CellPosition destination);

}

class Move {
	Player turn;
	Piece piece;
	Piece killedPiece;
	CellPosition fromCellPosition;
	CellPosition toCellPosition;
}