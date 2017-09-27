package nz.ac.auckland.se754;

public class TicTacToe {

	public void play(int xPosition, int yPosition) {
		if(xPosition < 1 || xPosition > 3) {
			throw new RuntimeException("X position is outside board!");
		}
		if(yPosition < 1 || yPosition > 3) {
			throw new RuntimeException("Y position is outside board!");
		}
	}
}
