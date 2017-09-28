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
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowRuntimeExceptionWhenXPlacedOutsideBoard() {
		ticTacToe.play(5, 2);
	}
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void sholdThrowRuntimeExceptionWhenYPlacedOutsideBoard() {
		expected.expect(RuntimeException.class);
		expected.expectMessage("Y position is outside board!");
		ticTacToe.play(2, 5);
	}

}
