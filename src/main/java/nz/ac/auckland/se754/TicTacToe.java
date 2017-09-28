package nz.ac.auckland.se754;

public class TicTacToe {

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
		
		for(int i=0; i<3; i++) {
			if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
				return "X is the winner";
			}
		}
		
		for(int i=0; i<3; i++) {
			if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
				return "X is the winner";
			}
		}
		
		return "No winner";
	}
	
	private void checkPosition(int position, char axis) {
		if(position < 1 || position > 3) {
			throw new RuntimeException(axis+" position is outside board!");
		}
	}
	
	private void setBox(int xPosition, int yPosition) {
		if(board[xPosition-1][yPosition-1] != '\0') {
			throw new RuntimeException("Space is occupied!");
		}
		board[xPosition-1][yPosition-1] = 'X';
	}
	
	public char nextPlayer() {
		if(currentPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
}
