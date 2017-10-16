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
		assertEquals(ticTacToe.SYMBOL_X, ticTacToe.nextPlayer());
	}
	
	@Test
	public void shouldGiveNextPlayerToOWhenLastTurnWasX() {
		ticTacToe.play(1, 1); // X
		assertEquals(ticTacToe.SYMBOL_O, ticTacToe.nextPlayer());
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
	public void shouldShowWinnerWhenHisPiecesOccupiedAWholeHorizontalLine() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(1, 2); // X
		ticTacToe.play(2, 2); // O
		String result = ticTacToe.play(1, 3); // X
		assertEquals("X is the winner", result);
	}
	
	@Test
	public void shouldShowWinnerWhenHisPiecesOccupiedAWholeVerticalLine() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 2); // O
		String result = ticTacToe.play(3, 1); // X
		assertEquals("X is the winner", result);
	}
	
	@Test
	public void shouldShowWinnerWhenHisPiecesOccupiedAWholeDiagonalOrAntidiagonalLine() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(2, 3); // O
		String result = ticTacToe.play(3, 3); // X
		assertEquals("X is the winner", result);
	}
	
	@Test
	public void shouldShowDrawWhenAllBoxesFilled() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(1, 3); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(2, 3); // X
		ticTacToe.play(2, 2); // O
		ticTacToe.play(3, 1); // X
		ticTacToe.play(3, 3); // O
		String result = ticTacToe.play(3, 2); // X
		assertEquals("The result is draw", result);
	}
	
	@Ignore
	@Test
	public void shouldFail() {
		fail("failed");
	}
}
