package nz.ac.auckland.se754;

public class Dollar {

	int amount;
	
	public Dollar(int amount) {
		this.amount=amount;
	}
	
	public void multipliedBy(int multiplier) {
		amount *= multiplier;
	}
	
	public void dividedBy(int denominator) {
		amount /= denominator;
	}
}
