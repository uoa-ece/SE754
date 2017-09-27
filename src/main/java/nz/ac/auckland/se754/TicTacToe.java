package nz.ac.auckland.se754;

public class TicTacToe {

	public void play(int xPosition, int yPosition) {
		checkPosition('X', xPosition);
		checkPosition('Y', yPosition);
	}
	
	private void checkPosition(char axis, int position) {
		if(position < 1 ||position > 3) {
			throw new RuntimeException(axis+" position is outside board!");
		}
	}
}
