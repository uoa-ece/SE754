package nz.ac.auckland.se754;

public class Dollar {

	int amount;
	
	public Dollar(int amount) {
		this.amount=amount;
	}
	
	public void multiplyBy(int multiplier) {
		amount *= multiplier;
	}
}
