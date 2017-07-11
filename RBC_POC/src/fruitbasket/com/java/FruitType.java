package fruitbasket.com.java;

/**
 * ENUM which hold all the fruits available and their per piece price.
 * 
 * @author user
 * 
 */
public enum FruitType {

	BANANA(10), ORANGE(12), APPLE(45), LEMON(3.5), PEACH(12.5);

	private double pricePerPiece;

	private FruitType(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}

	/**
	 * Method to return the price for the fruit This is price for 1 piece of
	 * fruit.
	 * 
	 * @return price
	 */
	public double getPricePerPiece() {
		return pricePerPiece;

	}
}
