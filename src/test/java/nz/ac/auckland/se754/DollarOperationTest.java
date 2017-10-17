package nz.ac.auckland.se754;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class DollarOperationTest {

	@Test
	public void testDollarMultiplication() {
		
		// Given
		Dollar five = new Dollar(5);
		
		// When
		five.multipliedBy(2);
		
		// Then
		assertEquals(10, five.amount);
		
	}
	
	@Test
	public void testDollarDivision() {
		// Given
		Dollar ten = new Dollar(10);
		
		// When
		ten.dividedBy(2);
		
		// Then
		assertEquals(5, ten.amount);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDollarDividedByZero() {
		// Given
		Dollar ten = new Dollar(10);
		
		// When
		ten.dividedBy(0);
	}
	
	@Ignore
	@Test(timeout=5000)
	public void testDivisionTimeout() {
		while(true) {
			
		}
	}
	
	@Ignore
	@Test
	public void testEqualOperation() {
		// Given
		Dollar ten = new Dollar(10);
		Dollar anotherTen = new Dollar(10);
				
		// When
		boolean result = ten.equals(anotherTen);
				
		// Then
		assertTrue(result);
	}

}
