package nz.ac.auckland.se754;

public class TicTacToe {

	private char[][] board = {
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}, 
			{'\0', '\0', '\0'}};
	
	public void play(int xPosition, int yPosition) {
		checkPosition(xPosition, 'X');
		checkPosition(yPosition, 'Y');
		setBox(xPosition, yPosition);
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
		return 'X';
	}
}
