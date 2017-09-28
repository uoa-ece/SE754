package nz.ac.auckland.se754;

public class TicTacToe {

	private final int SIZE = 3;
	private final int LOW_BOUNDARY = 1;
	public final char SYMBOL_X = 'X';
	public final char SYMBOL_O = 'O';
	private final char SYMBOL_EMPTY = '\0';
	
	private char[][] board;
	
	private char currentPlayer;
	
	public TicTacToe() {
		board = new char[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				board[i][j] = SYMBOL_EMPTY;
			}
		}
		currentPlayer = SYMBOL_EMPTY;
	}
	
	public String play(int xPosition, int yPosition) {
		currentPlayer = nextPlayer();
		
		checkPosition(xPosition, 'X');
		checkPosition(yPosition, 'Y');
		setBox(xPosition, yPosition);
		
		if(isWinner()) {
			return currentPlayer+" is the winner";
		}
		
		if(isDraw()) {
			return "The result is draw";
		}
		
		return "No winner";
	}
	
	private void checkPosition(int position, char axis) {
		if(position < LOW_BOUNDARY || position > SIZE) {
			throw new RuntimeException(axis+" position is outside board!");
		}
	}
	
	private void setBox(int xPosition, int yPosition) {
		if(board[xPosition-1][yPosition-1] != SYMBOL_EMPTY) {
			throw new RuntimeException("Space is occupied!");
		}
		board[xPosition-1][yPosition-1] = currentPlayer;
	}
	
	private boolean isWinner() {
		for(int i=0; i<SIZE; i++) {
			if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer  // Row
					|| board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer // Column
					|| board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer // Diagonal
					|| board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer // Anti-diagonal
					) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isDraw() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(board[i][j] == SYMBOL_EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public char nextPlayer() {
		if(currentPlayer == SYMBOL_X) {
			return SYMBOL_O;
		}
		return SYMBOL_X;
	}
}
