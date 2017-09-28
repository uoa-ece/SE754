package nz.ac.auckland.se754;

public class TicTacToe {

	private final int SIZE = 3;
	private final int LOW_BOUNDARY = 1;
	
	private char[][] board = {
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}};
	
	private char currentPlayer = '\0';
	
	public String play(int xPosition, int yPosition) {
		currentPlayer = nextPlayer();
		
		checkPosition(xPosition, 'X');
		checkPosition(yPosition, 'Y');
		setBox(xPosition, yPosition);
		
		if(isWinner()) {
			return currentPlayer+" is the winner";
		}
		
		return "No winner";
	}
	
	private void checkPosition(int position, char axis) {
		if(position < LOW_BOUNDARY || position > SIZE) {
			throw new RuntimeException(axis+" position is outside board!");
		}
	}
	
	private void setBox(int xPosition, int yPosition) {
		if(board[xPosition-1][yPosition-1] != '\0') {
			throw new RuntimeException("Space is occupied!");
		}
		board[xPosition-1][yPosition-1] = 'X';
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
	
	public char nextPlayer() {
		if(currentPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
}
