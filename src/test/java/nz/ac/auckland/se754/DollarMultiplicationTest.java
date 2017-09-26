package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarMultiplicationTest {

	@Test
	public void testDollarMultiplication() {
		
		// Given
		Dollar five = new Dollar(5);
		
		// When
		five.multipliedBy(2);
		
		// Then
		assertEquals(10, five.amount);
		
	}

}
