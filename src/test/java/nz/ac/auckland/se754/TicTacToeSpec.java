package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
	
//	@Ignore  // Regression testing without this test
	@Test(expected = RuntimeException.class)
	public void shouldThrowRuntimeExceptionWhenYPlacedOutsideBoard() {
		ticTacToe.play(2, 5);
	}

}
