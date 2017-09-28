package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Before;
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

}
