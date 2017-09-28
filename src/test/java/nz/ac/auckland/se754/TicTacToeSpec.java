package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

	private TicTacToe ticTacToe;
	
	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void shouldThrowRuntimeExceptionWhenXPlacedOutsideBoard() {
		expected.expect(RuntimeException.class);
		expected.expectMessage("X position is outside board!");
		ticTacToe.play(5, 2);
	}
	
	@Test
	public void sholdThrowRuntimeExceptionWhenYPlacedOutsideBoard() {
		expected.expect(RuntimeException.class);
		expected.expectMessage("Y position is outside board!");
		ticTacToe.play(2, 5);
	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenAPiecePlacedOnAnOccupiedSpace() {
		ticTacToe.play(2, 1);
		
		expected.expect(RuntimeException.class);
		expected.expectMessage("Space is occupied!");
		ticTacToe.play(2, 1);
	}
	
	@Test
	public void shouldGiveNextPlayerToXWhenFirstTurn() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void shouldGiveNextPlayerToOWhenLastTurnWasX() {
		ticTacToe.play(1, 1);
		assertEquals('O', ticTacToe.nextPlayer());
	}

}
