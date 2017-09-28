package nz.ac.auckland.se754;

public class TicTacToe {

	private char[][] board = {
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}};
	
	public void play(int xPosition, int yPosition) {
		if(yPosition < 1 || yPosition > 3) {
			throw new RuntimeException("Y position is outside board!");
		}
		if(xPosition < 1 || xPosition > 3) {
			throw new RuntimeException("X position is outside board!");
		}
		if(board[xPosition-1][yPosition-1] == '\0') {
			board[xPosition-1][yPosition-1] = 'X';
		}
		else {
			throw new RuntimeException("Space is occupied!");
		}
	}
}
