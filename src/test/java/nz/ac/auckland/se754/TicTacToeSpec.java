package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
		ticTacToe.play(1, 1); // X
		assertEquals('O', ticTacToe.nextPlayer());
	}

	@Ignore
	@Test
	public void shouldGiveNextPlayerToXWhenLastTurnWasO() {
		ticTacToe.play(1, 1);  // X
		ticTacToe.play(2, 2);  // O
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void shouldShowNoWinnerWhenNoWinningConditionFulfilled() {
		String result = ticTacToe.play(1, 1);
		assertEquals("No winner", result);
	}
	
	@Test
	public void shouldShowXIsWinnerWhenHisPiecesOccupiedAWholeHorizontalLine() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(1, 2); // X
		ticTacToe.play(2, 2); // O
		String result = ticTacToe.play(1, 3); // X
		assertEquals(result, "X is the winner");
	}
}
